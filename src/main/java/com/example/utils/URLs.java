package com.example.utils;

import com.example.Pages.ProductPage;

public class URLs {

    public static String basicURL = "https://www.saucedemo.com";

    public static String getBasicURL(){
        return basicURL;
    }

    public enum URL{
        LOGIN(basicURL),
        PRODUCTPAGE(basicURL+"/inventory.html"),
        SHOPPINGCART(basicURL+"/cart.html"),
        LOGGOUT(basicURL);



        private String value;

        URL(String value) {
            this.setValue(value);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
