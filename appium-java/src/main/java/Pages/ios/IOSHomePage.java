package Pages.ios;

import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumDriver;

public class IOSHomePage extends HomePage {

    public IOSHomePage(AppiumDriver driver){
        super(driver);
    }

    
    public boolean isNotificationBarDisplayed() {
        return isDisplayed(null);
    }
    
}
