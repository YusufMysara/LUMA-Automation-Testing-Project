package Pages;

import org.openqa.selenium.By;

import static TestCases.TestBase.driver;

public class P02_Login {
    By signInButtonHPage = By.linkText("Sign In");
    By email = By.id("email");
    By password = By.id("pass");
    By signInButton = By.cssSelector("button[id=\"send2\"]");
    By welcomeFNameLName = By.className("logged-in");

    public void clickOnSignInButtonAtHomePage(){
        driver.findElement(signInButtonHPage).click();
    }
    public void enterEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickOnSignIn(){
        driver.findElement(signInButton).click();
    }
    public String welcomeName(){
        return driver.findElement(welcomeFNameLName).getText();
    }
    public void login(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickOnSignIn();
    }
}
