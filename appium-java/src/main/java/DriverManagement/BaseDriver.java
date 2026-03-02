package DriverManagement;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseDriver {

    AndroidDriver driver ;
    AppiumDriverLocalService appiumService;

    @SuppressWarnings("null")
    public AndroidDriver initAndroidDriver() throws MalformedURLException{
        initAppiumService();
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

    public void quitDriver(){
        driver.quit();
    }
}
