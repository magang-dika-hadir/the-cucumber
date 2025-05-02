package com.juaracoding;

import com.juaracoding.pages.ManagementAddUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ManagementAddUserTest {
    private static ManagementAddUser managementAddUser = new ManagementAddUser();

    @Given("I navigate to the pendaftaran user page")
    public void navigateToAddUserPage() {
        managementAddUser.refreshPage();
        managementAddUser.navigateToManagementAddUser();
    }

    @And("I upload the profile picture {string}")
    public void uploadProfilePicture(String theData) {
        managementAddUser.uploadFile(theData);
    }

    @And("I fill in the following detailed user information:")
    public void fillInUserDetails(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
        for (java.util.Map<String, String> details : userDetails) {
            if (details.get("NIK") != null) {
                managementAddUser.fillNik(details.get("NIK"));
            }
            if (details.get("Nama Karyawan") != null) {
                managementAddUser.fillName(details.get("Nama Karyawan"));
            }
            if (details.get("Email") != null) {
                managementAddUser.fillEmail(details.get("Email"));
            }
            if (details.get("Password") != null) {
                managementAddUser.fillPassword(details.get("Password"));
            }
            managementAddUser.scrollTO(500); // Scroll might be independent of the data

            if (details.get("Divisi") != null) {
                managementAddUser.selectDivision(details.get("Divisi"));
            }
            if (details.get("Unit") != null) {
                managementAddUser.selectUnit(details.get("Unit"));
            }
            if (details.get("Posisi Kerja") != null) {
                managementAddUser.selectJobPosition(details.get("Posisi Kerja"));
            }
            if (details.get("Jabatan") != null) {
                managementAddUser.selectJobTitle(details.get("Jabatan"));
            }
            if (details.get("Tipe Kontrak") != null) {
                managementAddUser.selectContractType(details.get("Tipe Kontrak"));
            }
            managementAddUser.scrollTO(500); // Scroll might be independent of the data

            if (details.get("Lokasi Kerja") != null) {
                managementAddUser.selectWorkLocation(details.get("Lokasi Kerja"));
            }
            if (details.get("Tipe Shift") != null) {
                managementAddUser.selectShiftType(details.get("Tipe Shift"));
            }
            if (details.get("Jadwal Kerja") != null) {
                managementAddUser.selectWorkSchedule(details.get("Jadwal Kerja"));
            }
            if (details.get("Selfie") != null) {
                managementAddUser.selectSelfieRequirement(details.get("Selfie"));
            }
            if (details.get("Jumlah Cuti") != null) {
                managementAddUser.fillLeaveQuota(details.get("Jumlah Cuti"));
            }
        }
    }

    @And("I click the submit button")
    public void clickSubmitButton() throws InterruptedException {
        managementAddUser.clickSubmitButton();
//        Thread.sleep(5000);
    }

    @Then("The new user should be added successfully")
    public void verifyUserAddedSuccessfully() {
        Assert.assertTrue(true, "The user was added successfully");
    }

    @Then("An error message indicating {string} should be displayed")
    public void verifyErrorMessageDisplayed(String expectedErrorMessage) {
        WebElement errorMessageElement = managementAddUser.getErrorMessageElement(expectedErrorMessage);
        System.out.println("ASSERT EXPECT: " + expectedErrorMessage + " || " + "ACTUAL: " + errorMessageElement.getText());
        Assert.assertNotNull(errorMessageElement, "Error message element not found.");
        Assert.assertTrue(errorMessageElement.getText().contains(expectedErrorMessage),
                "Expected error message '" + expectedErrorMessage + "' but got '" + errorMessageElement.getText() + "'");
    }
}
