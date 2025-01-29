package TestCases;

import Pages.P04_Wishlist;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T04_Wishlist extends TestBase{
    P04_Wishlist wishList = new P04_Wishlist();

    @Test
//Validate that Guest user can’t add any product to Wishlist
    public void TC1(){
        wishList.scroll();
        wishList.hover(wishList.productsList().get(3));
        wishList.clickOnAddToWishList(wishList.productsList().get(3));
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS93aXNobGlzdC9pbmRleC9hZGQv/");
    }

    @Test
//Validate That Logged-in user can add any product to Wishlist
    public void TC2(){
        wishList.scroll();
        wishList.hover(wishList.productsList().get(3));
        wishList.clickOnAddToWishList(wishList.productsList().get(3));
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/85351/");
    }
}
