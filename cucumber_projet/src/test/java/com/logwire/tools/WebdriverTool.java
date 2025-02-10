package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverTool {

    static public WebDriver driver;

    static public void setupDriver() {
        driver = new FirefoxDriver();
    }

    static public WebDriver getDriver() {
        return driver;
    }

    static public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
