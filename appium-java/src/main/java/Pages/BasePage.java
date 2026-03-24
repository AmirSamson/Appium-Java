package Pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    AndroidDriver driver;

    public static final int SHORT_WAIT=60;     // This is our ExplicitWait

    WebDriverWait webDriverWait;    // First we defined this instance, here then added it in the Constructor.
    
        //this is our constructor:
    public BasePage (AndroidDriver driver){ 
        this.driver=driver;

            // Since we had this line in both of the methods, so we added it here in the constructor of the class:
        webDriverWait= new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT)); 
    }


    /*
    Explicit Waits:

        This Method  `waitAndClick(By locator)`  is created to perform the Explicit Wait actions. 
        But first, it will wait for the elements to be visible:

                    WebDriverWait webDriverWait= new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
                    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        Then it will wait for them to be clickable:

                    WebElement element = driver.findElement(locator);
                    webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        Then it will click on them:

                    element.click();

    */

    public void waitAndClick(By locator){
        // WebDriverWait webDriverWait= new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*
        For checking if something is Displayed, we can also use the same way:
    */

    public boolean isDisplayed(By locator){
        // WebDriverWait webDriverWait= new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}
