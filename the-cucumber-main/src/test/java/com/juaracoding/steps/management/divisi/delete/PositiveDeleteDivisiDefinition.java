package com.juaracoding.steps.management.divisi.delete;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.management.divisi.DeleteDivisiPage;
import com.juaracoding.pages.management.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PositiveDeleteDivisiDefinition {

        private WebDriver driver;
        private FilteringDivisiPage filteringDivisiPage;
        private DeleteDivisiPage deleteDivisiPage;

        @Before
        public void setup() {
            driver = DriverSingleton.getDriver();
            filteringDivisiPage = new FilteringDivisiPage(driver);
            deleteDivisiPage = new DeleteDivisiPage(driver);
        }

        @When("User clicks the three dot button for the divisi {string}")
        public void userClicksTheThreeDotButtonForTheDivisi(String divisiName) {
            deleteDivisiPage.clickThreeDotButton(divisiName);
        }

        @And("User selects the delete option from the menu")
        public void userSelectsTheDeleteOptionFromTheMenu() {
            deleteDivisiPage.clickDelete();
        }

        @Then("A confirmation popup for deleting divisi should appear with message containing {string}")
        public void aConfirmationPopupForDeletingDivisiShouldAppear(String expectedDivisiName) {
            String actualMessage = deleteDivisiPage.getDeleteConfirmationText();
            Assert.assertTrue(actualMessage.contains(expectedDivisiName), "Pesan konfirmasi tidak sesuai.");
        }

        @And("User confirms deletion by clicking Ya")
        public void userConfirmsDeletionByClickingYa() {
            deleteDivisiPage.clickYa();
        }

        @Then("Divisi with name {string} should be deleted successfully")
        public void divisiWithNameShouldBeDeletedSuccessfully(String divisiName) {
            filteringDivisiPage.searchDivisi(divisiName).clickSearchButton();

            boolean isDivisiAdaSebelumnya = filteringDivisiPage.isDivisiFound(divisiName);
            Assert.assertTrue(isDivisiAdaSebelumnya, "Divisi '" + divisiName + "' seharusnya muncul sebelum dihapus.");

            boolean isDivisiMasihAda = deleteDivisiPage.isDivisiListed(divisiName);
            Assert.assertFalse(isDivisiMasihAda, "Divisi '" + divisiName + "' seharusnya sudah terhapus.");
        }
    }

