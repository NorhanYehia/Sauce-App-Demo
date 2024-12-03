package com.example;

import com.example.Pages.LoginPage;
import com.example.Pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTestClass{

    @Test
    public void verifyLogoutRedirectToLoginPage() {
        LogoutPage logout = new LogoutPage(driver);
        LoginPage login = new LoginPage(driver);

        login.openLoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnLoginBtn();

        logout.openSideList();
        logout.clickOnLogout();

        doAssertEqual(login.checkElementIsDisplayed(login.loginBtn), true, "can't logout successfully");
        softAssert.assertAll();
    }
}
