package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import DriverManagement.BaseDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends BaseDriver {

    AndroidDriver driver;

    @BeforeMethod
    public void initialize() throws MalformedURLException{
        driver= initAndroidDriver();
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
    }
}
