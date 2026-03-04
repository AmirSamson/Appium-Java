package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import DriverManagement.BaseDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends BaseDriver {

    AndroidDriver driver;
    @BeforeSuite
    public void initSuite(){
        initAppiumService(); // this will initialize the Appium Server for all Tests and we will not see the server to be initialized for each test.
    }

    @BeforeMethod
    public void initialize() throws MalformedURLException{
        driver= initAndroidDriver();
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
    }

    @AfterSuite
    public void tearDownAppium(){
        quitAppium();
    }
}   

