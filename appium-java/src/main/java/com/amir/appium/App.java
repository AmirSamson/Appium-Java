package com.amir.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","UIAutomator2");
        capabilities.setCapability("appium:platformVersion","16");       
        capabilities.setCapability("appium:appPackage","com.android.settings");
        capabilities.setCapability("appium:appActivity","com.android.settings.Settings");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By searhBy = By.id("com.android.settings:id/search_bar_title"); // We defined the Searching ID so that we can use it in different places.
        driver.findElement(searhBy).click();
        driver.findElement(By.id("com.google.android.settings.intelligence:id/open_search_view_edit_text")).sendKeys("Battery");
        driver.findElement(By.id("android:id/switch_widget")).click();
        driver.quit();
    }
}
