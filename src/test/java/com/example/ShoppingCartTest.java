package com.example;

import com.example.Pages.LoginPage;
import com.example.Pages.ProductPage;
import com.example.Pages.ShoppingCartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTestClass {

    @BeforeMethod
    public void setUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginBtn();
    }

    @Test
    public void checkIfShoppingCartHasItem() {
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        productPage.clickOnAddToCart().goToCartPage();
        doAssertEqual(shoppingCartPage.checkElementIsDisplayed(shoppingCartPage.cartItem) , true , "item not added to cart");
        shoppingCartPage.clickOnRemoveBtn();
        softAssert.assertAll();
    }

    @Test
    public void checkRemoveButtonWorkCorrectly() {
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        productPage.clickOnAddToCart().goToCartPage();
        shoppingCartPage.clickOnRemoveBtn();
        doAssertEqual(shoppingCartPage.checkElementIsDisplayed(shoppingCartPage.cartItem) , false , "item not added to cart");
        softAssert.assertAll();
    }

    @Test
    public void makeSureShoppingCardBadgeUpdated() {
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        productPage.clickOnAddToCart();
        doAssertEqual(productPage.checkElementIsDisplayed(productPage.shoppingCartBadge) , true , "item not added to cart");
        productPage.clickOnRemoveButton();
        doAssertEqual(productPage.checkElementIsDisplayed(productPage.shoppingCartBadge) , false , "item not deleted from cart");
        softAssert.assertAll();
    }
}
