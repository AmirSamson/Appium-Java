package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

public abstract class HomePage extends BasePage {
    
    public HomePage(AppiumDriver driver){
        super(driver);
    }
}
