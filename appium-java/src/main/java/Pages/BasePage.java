package Pages;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    AndroidDriver driver;
    
    //this is our constructor:
    public BasePage (AndroidDriver driver){ 
        this.driver=driver;
    }
}
