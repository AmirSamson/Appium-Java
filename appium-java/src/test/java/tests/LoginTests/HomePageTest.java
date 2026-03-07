package tests.LoginTests;


import org.testng.annotations.Test;

import Pages.LaunchPage;
import tests.BaseTest;


public class HomePageTest extends BaseTest{

    @Test
    public void validateHomePageTest() throws InterruptedException {
        System.out.println("HomePage test is running");
        LaunchPage launchPage = new LaunchPage(this.driver);
        launchPage.inspectPopUp();
        launchPage.refreshButton();
    }
    
}
