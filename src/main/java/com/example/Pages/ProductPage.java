package com.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends Page{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public By sortingList = By.xpath("//*[@data-test = 'product-sort-container']");
    public By productName = By.xpath("//*[@class = 'inventory_item'][1]//div[@class = 'inventory_item_name ']");
    public By productDescription = By.xpath("//*[@class = 'inventory_item'][1]//div[@class = 'inventory_item_desc']");
    public By productPrice = By.xpath("//*[@class = 'inventory_item'][1]//div[@class = 'inventory_item_price']");
    public By priceList = By.xpath("//*[@class = 'inventory_item_price']");
    public By addToCartBtn = By.xpath("//*[@class = 'inventory_item'][1]//button[contains(@data-test , 'add-to-cart')]");
    public By goToCartBtn = By.xpath("//*[@data-test ='shopping-cart-link']");
    public By shoppingCartBadge = By.xpath("//*[@class='shopping_cart_badge']");
    public By removeBtn = By.xpath("//*[text() = 'Remove']");


   @Step
    public void clickOnSortingList(){
       clickElement(sortingList);
   }

   @Step
    public void selectSortingByPrice(){
       Select list = new Select(driver.findElement(sortingList));
       list.selectByVisibleText("Price (low to high)");
   }

    @Step
    public boolean pricesOrderAscending() throws InterruptedException {
        List<WebElement> prices = findElements(priceList);
        List<String> pricesList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();

        for (WebElement t : prices) {
            pricesList.add(t.getText().replace("$",""));
        }

        for(String s : pricesList) {
            doubleList.add(Double.valueOf(s));
        }

        for (int i =0 ; i<doubleList.size()-1 ; i++){
            if(doubleList.get(i)> doubleList.get(i+1)){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    @Step
    public ProductPage clickOnAddToCart(){
        clickElement(addToCartBtn);
        return this;
    }

    @Step
    public ShoppingCartPage goToCartPage(){
       clickElement(goToCartBtn);
       return new ShoppingCartPage(driver);
    }

    @Step
    public ProductPage clickOnRemoveButton(){
       clickElement(removeBtn);
       return this;
    }
}
