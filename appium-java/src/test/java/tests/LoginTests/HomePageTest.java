package tests.LoginTests;


import org.testng.Assert;
import org.testng.annotations.Test;

// import Pages.LaunchPage;
import Pages.pageFactory.HomePage;
import tests.BaseTest;


public class HomePageTest extends BaseTest{

    @Test
    public void validateHomePageTest() throws InterruptedException {
        System.out.println("HomePage test is running");
        HomePage homePage = pageFactory.getLaunchPage();
        // LaunchPage launchPage = new LaunchPage(this.driver);
        Assert.assertTrue(homePage.isNotificationBarDisplayed(), "SnackBar is not Displayed!");
    }
    
}
