package DriverManagement;
import java.net.URL;
import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.net.UrlChecker.TimeoutException; // Import this
import java.io.File;
import java.time.Duration;


public class BaseDriver {

    AndroidDriver driver ;
    private AppiumDriverLocalService appiumService;
    private File logFile;


    @SuppressWarnings("null")
    public AndroidDriver initAndroidDriver() throws MalformedURLException{
        initAppiumService();  // we have disabled this line because we are calling this method inside the BaseTest.java file. 

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
            "\\src\\main\\resources\\App\\FEDSHI-Demo-Release-1.10.0.apk"); 
            
            //   "\\src\\main\\resources\\App\\amazon.mShop.android.shopping.apk"
            //   "\\src\\main\\resources\\App\\FEDSHI-Demo-Release-1.10.0.apk"

        capabilities.setCapability("appium:newCommandTimeout",120);
        return capabilities;
    }

        public void initAppiumService() {
            try {
                File nodeExecutable = new File("C:\\nvm4w\\nodejs\\node.exe");
                File appiumJsFile = new File("C:\\Users\\98930\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");


                String logFilePath = System.getProperty("user.dir") + "/target/appiumServiceLogs.txt";
                logFile = new File(logFilePath);

                if (logFile.getParentFile() != null && !logFile.getParentFile().exists()) {
                    logFile.getParentFile().mkdirs();
                }

                AppiumServiceBuilder builder = new AppiumServiceBuilder()
                        .usingDriverExecutable(nodeExecutable)
                        .withAppiumJS(appiumJsFile)
                        .withIPAddress("127.0.0.1")
                        .usingPort(4723)
                        .withTimeout(Duration.ofSeconds(900))
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                        .withLogFile(logFile); 
                
                
                    appiumService = AppiumDriverLocalService.buildService(builder);
                
                    System.out.println(">>> Starting Appium Server...");
                appiumService.start();

                int attempts = 0;
                int maxAttempts = 10;
                boolean isRunning = false;
                while (attempts < maxAttempts) {
                    if (appiumService.isRunning()) {
                        isRunning = true;
                        break;
                    }
                    attempts++;
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Interrupted while waiting for Appium server to start.");
                        break;
                    }
                }

                if (!isRunning) {
                    System.err.println("❌ Appium Server did not start correctly within the timeout period.");
                    System.err.println("   Please check the log file for detailed errors: " + logFile.getAbsolutePath());
                    throw new RuntimeException("Appium Server failed to start.");
                }

                System.out.println("✅ Appium Server started successfully at: " + appiumService.getUrl());

            } catch (Exception e) {
                e.printStackTrace();
                if (e.getMessage() != null && (e.getMessage().contains("Cannot run program") || e.getMessage().contains("failed to start process") || e.getMessage().contains("A required class was not found"))) {
                    System.err.println("Error: Could not execute the Appium JS file. Please verify the path to 'appium.js' and Node.js executable. Ensure necessary Appium modules are installed globally.");
                }
                if (logFile != null) {
                    System.err.println("   Attempted log file path: " + logFile.getAbsolutePath());
                }
                throw new RuntimeException("Failed to initialize Appium Service: " + e.getMessage(), e);
            }
        }

    // public void initAppiumService(){
    //     appiumService = AppiumDriverLocalService.buildService(
    //         new AppiumServiceBuilder() 

    //         // .usingDriverExecutable(new File("/usr/local/bin/node"))      //if node is not added to the PATH
    //         // .withAppiumJS(new File("usr/local/lib/node_modules/appium/build/lib/main.js"))       // if Appium is not added to PATH
    //         .withLogFile(new File(System.getProperty("user.dir")+"/target/appiumServiceLogs.txt"))
    //         .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

    //     appiumService.start();
        
    // }

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
