package TestCases;

import Pages.P03_LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        WebElement Breathe_Easy_Tank = landingPage.productsList().get(1);
        landingPage.hover(Breathe_Easy_Tank);
        landingPage.selectSizeMedium(Breathe_Easy_Tank);
        landingPage.selectColorYellow();
        landingPage.clickOnAddToCart(Breathe_Easy_Tank);
        Assert.assertEquals(landingPage.cartNumber(),"1");
    }
}
