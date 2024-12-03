package com.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends Page {
    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public By sideList = By.id("react-burger-menu-btn");
    public By logoutBtn = By.id("logout_sidebar_link");

    @Step
    public void openSideList(){
        clickElement(sideList);
    }

    @Step
    public void clickOnLogout(){
        clickElement(logoutBtn);
    }
}
