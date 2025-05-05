package com.juaracoding.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
//        System.setProperty("webdriver.gecko.driver");
        return new FirefoxDriver();
    }
}
