package com.juaracoding;

import com.juaracoding.pages.login.LoginPage;
import com.juaracoding.drivers.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage = new LoginPage(driver);

    public LoginTest(){
        driver = Hooks.driver;
    }

    @Given("I am on the login page")
    public void goToLoginPage(){
        driver.get(Constants.URL);
    }

    @When("I enter a valid email and password")
    public void fillEmailandPassword(){
        loginPage.loginUsernamePassword();
    }

    @And("I click the login button")
    public void verifyLogin(){
        loginPage.setLoginBtn();
    }

    @Then("I should be redirected to dashboard page")
    public void validateDahboard(){
        System.out.println(loginPage.getTxtDashboard());
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard Menu");
    }

}
