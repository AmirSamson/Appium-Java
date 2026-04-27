package tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import DriverManagement.BaseDriver;
import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends BaseDriver {

    protected AppiumDriver driver;
    protected static Properties appProperties;
    protected static PageFactory pageFactory;

    @BeforeSuite
    public void initSuite(){
        appProperties= getApplicatioProperties();
        initAppiumService(); // this will initialize the Appium Server for all Tests and we will not see the server to be initialized for each test.
    }

    @BeforeMethod
    public void initialize() throws Exception{
        driver= initDriver();
        pageFactory=PageFactory.getPageFactory(driver, prop.getProperty("platform"));
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

