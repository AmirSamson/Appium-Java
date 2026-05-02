// package Pages;
import org.openqa.selenium.By;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LaunchPage extends BasePage {

    public LaunchPage(AppiumDriver driver) {
        super(driver);
        // PageFactory.initElements(driver, this);     // this is for "WebElement"
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
        waitAndClick(popUpSnackBarId);
    }

    public void refreshButton(){
        waitAndClick(refreshBtnId);
    }

    /*
    Since we added the Explicit wait in the BasePage.java file, 
    we can now use the Method name alone without needing to use the .Click(); function
    Using the "waitAndClick(By Locator)" function available in the framework. 
    */
}
