package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hooks {

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    public static void finish(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverSingleton.closeObjectInstance();
    }

}
