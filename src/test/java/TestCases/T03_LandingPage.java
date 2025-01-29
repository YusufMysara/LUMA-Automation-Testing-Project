package TestCases;

import Pages.P03_LandingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class T03_LandingPage extends TestBase{
    P03_LandingPage landingPage = new P03_LandingPage();
    SoftAssert softAssert = new SoftAssert();

    @Test
//TC1: Validate That Hot Sellers is displayed and each card contains Price in $
    public void TC1(){
        landingPage.scroll();
        List<WebElement> prices = landingPage.ListOfPrices();
        for (WebElement price : prices){
            softAssert.assertTrue(price.getText().contains("$"));
            softAssert.assertTrue(price.getText().contains("."));
        }
        softAssert.assertAll();
    }

    @Test
//Validate That each card contains “Add to Cart” button and clickable
    public void TC2(){
        landingPage.scroll();
        List<WebElement> products = landingPage.productsList();
        for (WebElement product : products){
            landingPage.hover(product);
            softAssert.assertTrue(landingPage.isAddToCartEnabled());
        }
        softAssert.assertAll();
    }

    @Test
//Validate That Guest user can add product to cart
    public void TC3() throws InterruptedException {
        landingPage.scroll();
        landingPage.hover(landingPage.productsList().get(1));
        landingPage.selectSizeMedium(landingPage.productsList().get(1));
        landingPage.selectColorYellow();
        landingPage.clickOnAddToCart(landingPage.productsList().get(1));
        Thread.sleep(2000);
        Assert.assertEquals(landingPage.cartNumber(),"1");
    }
}
