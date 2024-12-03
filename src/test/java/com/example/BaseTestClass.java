package com.example;

import com.example.Pages.Page;
import com.example.utils.Drivers;
import com.example.utils.URLs;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseTestClass {

    public WebDriver driver;
    Drivers testInit;
    Page page;
    SoftAssert softAssert;

    @BeforeClass
    @Parameters("browser")
    void beforeClass(@Optional("chrome") String browser) throws Exception {
        softAssert = new SoftAssert();
        Drivers testInit = new Drivers();
        driver = testInit.setUpDriver(browser);
        URLs.getBasicURL();
        page = new Page(driver);
    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTestLog(String message) {
        return message;
    }

    @Step("check that value : {0} equal to : {1} ")
    boolean doAssertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            saveTestLog(message);
            return false;
        }

        return true;
    }
}
