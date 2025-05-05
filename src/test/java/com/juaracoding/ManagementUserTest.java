package com.juaracoding;

import com.juaracoding.Utils.Constants;
import com.juaracoding.Utils.Utils;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ManagementUserPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ManagementUserTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static ManagementUserPage managementUserPage = new ManagementUserPage();
    private static LoginPage loginPage = new LoginPage();

    public ManagementUserTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    @Given("I am on the user page")
    public void i_am_on_the_user_page(){
        driver.get(Constants.URL);
        loginPage.loginUsername("admin@hadir.com","MagangSQA_JC@123");
        loginPage.setBtnSubmit();
        extentTest.log(LogStatus.PASS,"I am on the user page");
    }
    @When("I click button management")
    public void i_click_button_management(){
        managementUserPage.setBtnManagement();
        extentTest.log(LogStatus.PASS,"I click button management");
    }
    @And("I click button user")
    public void i_click_button_user(){
        Utils.delay(2);
        managementUserPage.setBtnUser();
        extentTest.log(LogStatus.PASS,"I click button user");
    }
    @Then("I see message application error on the user page")
    public void i_see_message_application_error_on_the_user_page(){
        Utils.delay(2);
        Assert.assertEquals(managementUserPage.getTxtAppError(),"Masuk ke halaman user");
        extentTest.log(LogStatus.PASS,"I see message application error on the user page");
    }
}
