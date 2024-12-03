package com.example;

import com.example.Pages.LoginPage;
import com.example.Pages.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTestClass{

    @BeforeMethod
    public void setUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginBtn();
    }

    @Test(description = "make sure first product cart contain title, description and price")
    public void checkFirstProductItems(){
        ProductPage productPage = new ProductPage(driver);
        doAssertEqual(productPage.checkElementIsDisplayed(productPage.productName) , true , "product name doesn't displayed");
        doAssertEqual(productPage.checkElementIsDisplayed(productPage.productDescription) , true , "product description doesn't displayed");
        doAssertEqual(productPage.checkElementIsDisplayed(productPage.productPrice) , true , "product price doesn't displayed");
        softAssert.assertAll();
    }

    @Test
    public void checkSortingFunctionWorkCorrectly() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnSortingList();
        productPage.selectSortingByPrice();
        doAssertEqual(productPage.pricesOrderAscending(), true , "sorting not work correctly");
        softAssert.assertAll();
    }
}
