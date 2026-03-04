package DriverManagement;
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseDriver {

    AndroidDriver driver ;
    AppiumDriverLocalService appiumService;

    @SuppressWarnings("null")
    public AndroidDriver initAndroidDriver() throws MalformedURLException{
        // initAppiumService();  we have disabled this line because we are calling this method inside the BaseTest.java file. 

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),getDesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","UIAutomator2");
        capabilities.setCapability("appium:platformVersion","16");     

        capabilities.setCapability(
            "appium:app",
            System.getProperty("user.dir") +
            "\\src\\main\\resources\\App\\amazon.mShop.android.shopping.apk"); //appium-java\src\main\resources\App\amazon.mShop.android.shopping.apk

        capabilities.setCapability("appium:newCommandTimeout",120);
        return capabilities;
    }

    public void initAppiumService(){
        appiumService = AppiumDriverLocalService.buildService(
            new AppiumServiceBuilder() 

            // .usingDriverExecutable(new File("/usr/local/bin/node"))      //if node is not added to the PATH
            // .withAppiumJS(new File("usr/local/lib/node_modules/appium/build/lib/main.js"))       // if Appium is not added to PATH
            .withLogFile(new File(System.getProperty("user.dir")+"/target/appiumServiceLogs.txt"))
            .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

        appiumService.start();
        
    }

    public void quitDriver(){
        driver.quit();
        System.out.println("driver has quit");
        // appiumService.stop();  we want our Appium server to be stopped after all tests are done and not for each one, so we should define a new method:
        
    }

    // now we close the server after suite, using this method:
    public void quitAppium(){
        appiumService.stop();
        System.out.println("Appium Server has stopped");
    }
}
