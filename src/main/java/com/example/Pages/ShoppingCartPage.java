package com.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends Page {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public By cartItem = By.xpath("//*[@class = 'cart_item']");
    public By removeBtn = By.xpath("//*[text()= 'Remove']");


    @Step
    public void clickOnRemoveBtn(){
        clickElement(removeBtn);
    }
}
