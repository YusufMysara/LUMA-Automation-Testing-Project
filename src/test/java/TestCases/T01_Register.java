package TestCases;

import Pages.P01_Register;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T01_Register extends TestBase{
    P01_Register register = new P01_Register();

    @Test
    //validate that the confirmation password field is required to proceed
    public void validateConfirmPassword(){
        register.clickOnCreateAccountButtonAtHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
        register.enterFName(firstName);
        register.enterLName(lastName);
        register.enterEmail(email);
        register.enterPassword(password);
//        register.confirmPass("");
        register.clickOnCreateAcc();
        Assert.assertEquals("This is a required field.",register.requiredError());
    }
    @Test
    //validate that the password field and confirmation password field must be the same to proceed
    public void validatePassAndConfirmPass(){
        register.clickOnCreateAccountButtonAtHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/create/");
        register.enterFName(firstName);
        register.enterLName(lastName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.confirmPass("Hello321");
        register.clickOnCreateAcc();
        Assert.assertEquals("Please enter the same value again.",register.requiredError());
    }
    @Test
    //validate that the login function works properly
    public void validateRegistration(){
        register.clickOnCreateAccountButtonAtHomePage();
        register.enterFName(firstName);
        register.enterLName(lastName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.confirmPass(confirmPass);
        register.clickOnCreateAcc();
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/");
        Assert.assertEquals(firstName+" "+lastName+"\n"+email, register.contactInformation());
    }
}
