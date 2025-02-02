package TestCases;

import Pages.P02_Login;
import Pages.P04_Wishlist;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T04_Wishlist extends TestBase{
    private static final Logger log = LoggerFactory.getLogger(T04_Wishlist.class);
    P04_Wishlist wishList = new P04_Wishlist();

    @Test
//Validate that Guest user can’t add any product to Wishlist
    public void TC1(){
        wishList.scroll();
        WebElement Hero_Hoodie = wishList.productsList().get(3);
        wishList.hover(Hero_Hoodie);
        wishList.clickOnAddToWishList(Hero_Hoodie);
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS93aXNobGlzdC9pbmRleC9hZGQv/");
    }

    @Test
//Validate That Logged-in user can add any product to Wishlist
    public void TC2(){
        P02_Login p02Login = new P02_Login();
        wishList.scroll();
        WebElement Hero_Hoodie = wishList.productsList().get(3);
        wishList.hover(Hero_Hoodie);
        wishList.clickOnAddToWishList(Hero_Hoodie);
        p02Login.login(email,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/85351/");
    }
}
