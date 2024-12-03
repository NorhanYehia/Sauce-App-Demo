package com.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void openURL(String url) {
        driver.navigate().to(url);
        System.out.println("Navigating to " + url);
    }

    public void sendText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(text);
    }

    public void clickElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public String getElementText(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean checkElementIsDisplayed(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element located by: " + locator);
            return false;
        }
        return true;
    }

    public List<WebElement> findElements(By locator) {
        List<WebElement> listOfWebElements = driver.findElements(locator);
        return listOfWebElements;
    }

}
