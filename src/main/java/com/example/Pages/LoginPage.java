package com.example.Pages;

import com.example.utils.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By username = By.id("user-name");
    public By password = By.id("password");
    public By loginBtn = By.id("login-button");

    public By errorMsg = By.xpath("//h3[@data-test = 'error']");


    @Step
    public LoginPage openLoginPage(){
        openURL(URLs.URL.LOGIN.getValue());
        return this;
    }

    @Step
    public LoginPage enterUsername(String text){
        sendText(username , text);
        return this;
    }

    @Step
    public LoginPage enterPassword(String text){
        sendText(password , text);
        return this;
    }

    @Step
    public LoginPage clickOnLoginBtn(){
        clickElement(loginBtn);
        return this;
    }

    @Step
    public String getErrorMsg(){
        System.out.println("invalid error msg: "+ getElementText(errorMsg));
       return getElementText(errorMsg);
    }
}
