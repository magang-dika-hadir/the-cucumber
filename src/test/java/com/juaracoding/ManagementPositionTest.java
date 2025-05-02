package com.juaracoding;

import com.juaracoding.pages.ManagementPosition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ManagementPositionTest {
    private static ManagementPosition managementPosition = new ManagementPosition();
    private static WebDriver driver;

    public ManagementPositionTest() {
        driver = Hooks.driver;
    }

    @Given("I navigate to the posisi page")
    public void navigateToAddUserPage() {
        managementPosition.navigateToManagementPosisi();
    }

    @When("I enter a position {string}")
    public void fillSearchForPosition(String position) {
        managementPosition.enterSearchPosition(position);
    }

    @When("I click tambahkan button")
    public void clickTambahkan() throws InterruptedException {
        Thread.sleep(2000);
        managementPosition.clickTambahkan();
    }

    @And("I click the search button")
    public void searchPosition() {
        managementPosition.clickSearch();
    }

    @And("I fill in the following position information:")
    public void fillPositionData(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("FILLL");

        java.util.List<java.util.Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
        for (java.util.Map<String, String> details : userDetails) {
            if (details.get("Nama Position") != null) {
                managementPosition.fillNamaPosisi(details.get("Nama Position"));
            }
            if (details.get("Nama Departement") != null) {
                managementPosition.fillNamaDepartementDropdown(details.get("Nama Departement"));
            }
        }
    }

    @And("I click the tambah button")
    public void clickTambah() {
        managementPosition.clickTambah();
    }

    @Then("I should be get the position list {string}")
    public void validatePosition(String expected) throws InterruptedException {
        Thread.sleep(2000);
        String actual = managementPosition.hasilPosisi();
        System.out.println(expected + " || " + actual);
        Assert.assertEquals(actual, expected);
    }

    @Then("An success message indicating {string} should be displayed")
    public void verifyMessage(String expectedMessage) throws InterruptedException {
        WebElement messageElement = managementPosition.getMessageElement(expectedMessage);
        System.out.println("ASSERT EXPECT: " + expectedMessage + " || " + "ACTUAL: " + messageElement.getText());
        Assert.assertNotNull(messageElement, "Message element not found.");
        Assert.assertTrue(messageElement.getText().contains(expectedMessage),
                "Expected message '" + expectedMessage + "' but got '" + messageElement.getText() + "'");
    }
}
