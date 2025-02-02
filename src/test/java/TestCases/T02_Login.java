package TestCases;

import Pages.P02_Login;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T02_Login extends TestBase{
    P02_Login login = new P02_Login();
    SoftAssert softAssert = new SoftAssert();

    @Test
//Validate That user can log in with registered email and password
    public void TC1(){
        login.clickOnSignInButtonAtHomePage();
        login.login(email,password);
        softAssert.assertEquals("Welcome, "+firstName+" "+lastName+"!",login.welcomeName());
        softAssert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/");
        softAssert.assertAll();
    }
}
