package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends ApplicationManager {

    @Test
    public void startTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
    }
}
