package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPage extends BasePage {

    public LaunchPage(AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub 
    }

    By popUpSnackBarId = By.id("com.fedshi.res.demo:id/snackbar_text");
    By refreshButtonId = By.id("com.fedshi.res.demo:id/snackbar_action");

    public void inspectPopUp(){
        driver.findElement(popUpSnackBarId).click();
    }

    public void refreshButton(){
        driver.findElement(refreshButtonId).click();
    }

}
