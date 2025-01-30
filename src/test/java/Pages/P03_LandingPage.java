package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static TestCases.TestBase.driver;

public class P03_LandingPage {
    By hotSeller = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[4]/h2");
    By price = By.cssSelector(".price");
    By product = By.className("product-item");
    By addToCart = By.cssSelector(".action.tocart.primary");
    By sizeM = By.cssSelector("#option-label-size-143-item-168");
    By colorYellow = By.cssSelector("#option-label-color-93-item-60");
    By cartNum = By.className("counter-number");

    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hotSeller));
    }
    public List<WebElement> ListOfPrices(){
        List<WebElement> prices = driver.findElements(price);
        return prices;
    }
    public List<WebElement> productsList(){
        List<WebElement> products = driver.findElements(product);
        return products;
    }
    public void hover(WebElement product){
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
    }
    public boolean isAddToCartEnabled(){
        return driver.findElement(addToCart).isEnabled();
    }
    public void selectSizeMedium(WebElement product){
        product.findElement(sizeM).click();
    }
    public void selectColorYellow(){
        driver.findElement(colorYellow).click();
    }
    public void clickOnAddToCart(WebElement product){
        product.findElement(addToCart).click();
    }
    public String cartNumber(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartNum)));
        return driver.findElement(cartNum).getText();
    }
}
