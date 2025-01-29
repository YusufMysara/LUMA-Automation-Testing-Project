package Pages;

import org.openqa.selenium.By;

import static TestCases.TestBase.driver;

public class P01_Register {
    By createAccountButtonHPage = By.linkText("Create an Account");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.name("email");
    By password = By.xpath("//*[@id=\"password\"]");
    By confirmPassword = By.id("password-confirmation");
    By createAccount = By.cssSelector("button[type=\"submit\"][title=\"Create an Account\"]");
    By required_field = By.id("password-confirmation-error");
    By contactInfo = By.cssSelector(".box-content p");

    public void clickOnCreateAccountButtonAtHomePage(){
        driver.findElement(createAccountButtonHPage).click();
    }
    public void enterFName(String FName){
        driver.findElement(firstName).sendKeys(FName);
    }
    public void enterLName(String LName){
        driver.findElement(lastName).sendKeys(LName);
    }
    public void enterEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void confirmPass(String confirm){
        driver.findElement(confirmPassword).sendKeys(confirm);
    }
    public void clickOnCreateAcc(){
        driver.findElement(createAccount).click();
    }
    public String requiredError(){
        return driver.findElement(required_field).getText();
    }
    public String contactInformation(){
        return driver.findElement(contactInfo).getText();
    }

}
