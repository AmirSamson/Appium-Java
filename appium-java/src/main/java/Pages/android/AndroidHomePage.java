package Pages.android;

import org.openqa.selenium.By;

import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumDriver;

public class AndroidHomePage extends HomePage{
    public AndroidHomePage(AppiumDriver driver){
        super(driver);
        inspectAndSkip();
    }

        
    By popUpSnackBarId = By.id("com.fedshi.res.demo:id/snackbar_text");
    By refreshBtnId = By.id("com.fedshi.res.demo:id/snackbar_action");

    public void inspectPopUp(){
        waitAndClick(popUpSnackBarId);
    }

    public void refreshButton(){
        waitAndClick(refreshBtnId);
    }

    @Override
    public void inspectAndSkip(){
        inspectPopUp();
        refreshButton();
    }

    @Override
    public boolean isNotificationBarDisplayed(){
        return isDisplayed(popUpSnackBarId);
    }

}
