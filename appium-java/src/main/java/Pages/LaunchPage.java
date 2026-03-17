package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;

public class LaunchPage extends BasePage {

    public LaunchPage(AndroidDriver driver) {
        super(driver);
        // PageFactory.initElements(driver, this);  this is for "WebElement"
    }

    
    /**
     * we can also use the WebElement to find the elements and use them.
     * However there is a downside to it. if the DOM changes, all tests will fail because it cannot find the DOM and ID.
     * for the sake of showing it, we will only write it here:
     

        @AndroidBy(id = "com.fedshi.res.demo:id/snackbar_action")
        public WebElement refreshBtn;

        public void clickOnRefreshBtn(){
            refreshBtn.click();
        }
        
    */


    By popUpSnackBarId = By.id("com.fedshi.res.demo:id/snackbar_text");
    By refreshBtnId = By.id("com.fedshi.res.demo:id/snackbar_action");

    public void inspectPopUp(){
        driver.findElement(popUpSnackBarId).click();
    }

    public void refreshButton(){
        driver.findElement(refreshBtnId).click();
    }

}
