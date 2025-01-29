package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.util.List;

import static TestCases.TestBase.driver;

public class P04_Wishlist {
    By hotSeller = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[4]/h2");
    By productsList = By.className("product-item");
    By wishlist = By.cssSelector(".action.towishlist");

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hotSeller));
    }
    public List<WebElement> productsList(){
        List<WebElement> products = driver.findElements(productsList);
        return products;
    }
    public void hover(WebElement product){
        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
    }
    public void clickOnAddToWishList(WebElement product){
        product.findElement(wishlist).click();
    }
}
