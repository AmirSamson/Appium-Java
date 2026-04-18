package Pages.android;
import Pages.pageFactory.PageFactory;
import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumDriver;

public class AndroidPageFactory extends PageFactory {

    private final AppiumDriver driver;

    public AndroidPageFactory(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    @Override
    public AndroidHomePage getLaunchPage(){
        return new AndroidHomePage(driver);
    }
}