package Pages.pageFactory;

import org.openqa.selenium.By;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

public abstract class HomePage extends BasePage {
    
    public HomePage(AppiumDriver driver){
        super(driver);
    }

    public void inspectAndSkip(){}
    public abstract boolean isNotificationBarDisplayed();

}
