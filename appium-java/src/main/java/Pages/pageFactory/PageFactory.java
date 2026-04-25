package Pages.pageFactory;

import Pages.android.AndroidPageFactory;
import Pages.ios.IOSPageFactory;
import io.appium.java_client.AppiumDriver;

public abstract class PageFactory {

    AppiumDriver driver;

    public PageFactory(AppiumDriver driver){
        this.driver=driver;
    }

    public static PageFactory getPageFactory(AppiumDriver driver, String Platform) {

    switch (Platform.toLowerCase()) {
        case "android":
            return new AndroidPageFactory(driver);

        case "ios":
            return new IOSPageFactory(driver);

        default:
            throw new IllegalArgumentException(
                "Platform name: " + Platform + " is not correct!"
            );
    }
}
    public abstract HomePage getLaunchPage();
}
