package com.example;

import com.example.Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTestClass {

    @Test
    public void verifyLoginFunctionality() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginBtn();
        doAssertEqual(login.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"), true, "can't login successfully");
        softAssert.assertAll();
    }

    @Test
    public void verifyCantLoginWithInvalidCredentials() {
        LoginPage login = new LoginPage(driver);
        String expectedError = "Epic sadface: Username and password do not match any user in this service";

        login.openLoginPage()
                .enterUsername("standard_user123")
                .enterPassword("secret_sauce")
                .clickOnLoginBtn();

        doAssertEqual(login.getErrorMsg(), expectedError, "can login successfully with invalid credentials");
        softAssert.assertAll();
    }


}
