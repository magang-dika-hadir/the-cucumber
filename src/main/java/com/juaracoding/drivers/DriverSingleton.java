package com.juaracoding.drivers;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplementer;
import com.juaracoding.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager; // Add this import
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;

    public DriverSingleton(String driver) {
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy) {
        // Setup WebDriverManager depending on the browser strategy
        if (strategy.equalsIgnoreCase(Constants.CHROME)) {
            WebDriverManager.chromedriver().setup();
        } else if (strategy.equalsIgnoreCase(Constants.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
        } else if (strategy.equalsIgnoreCase(Constants.EDGE)) {
            WebDriverManager.firefoxdriver().setup();
        }

        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }
}
