package TestCases;

import Pages.P02_Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T02_Login extends TestBase{
    P02_Login login = new P02_Login();
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void login(){
        login.clickOnSignInButtonAtHomePage();
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickOnSignIn();
        softAssert.assertEquals("Welcome, "+firstName+" "+lastName+"!",login.welcomeName());
        softAssert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/");
        softAssert.assertAll();
    }
}
