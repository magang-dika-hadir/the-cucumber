package com.juaracoding.steps;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.drivers.utils.Constants;
import com.juaracoding.pages.dashboard.DashboardPage;
import com.juaracoding.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        driver.get(Constants.URL);
        loginPage.loginUsernamePassword();
        loginPage.setLoginBtn();

        Assert.assertEquals(dashboardPage.getManagementMenu(), "Management", "Gagal masuk dashboard");
    }
    @Given("User is on the Management Divisi page")
    public void userIsOnTheManagementDivisiPage() {
        driver = DriverSingleton.getDriver();
        dashboardPage = new DashboardPage(driver);
        driver.get(Constants.URLDASHBOARD);

        dashboardPage.clickManagementMenu();
        dashboardPage.clickDivisiMenu();
    }

}
