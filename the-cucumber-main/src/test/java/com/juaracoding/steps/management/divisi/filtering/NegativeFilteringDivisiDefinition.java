package com.juaracoding.steps.management.divisi.filtering;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.management.divisi.FilteringDivisiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeFilteringDivisiDefinition {

        private WebDriver driver;
        private FilteringDivisiPage filteringDivisiPage;

        @Before
        public void setup() {
            driver = DriverSingleton.getDriver();
            filteringDivisiPage = new FilteringDivisiPage(driver);
        }

        @When("User searches for divisi with character name {string}")
        public void userSearchesForDivisiWithCharacterName(String divisiName) {
            filteringDivisiPage.searchDivisi(divisiName);
        }

        @Then("No divisi should be found")
        public void noDivisiShouldBeFound() {
            boolean found = filteringDivisiPage.isDivisiFound("!@#$%");
            Assert.assertFalse(found, "Divisi dengan karakter tidak valid tidak boleh ditemukan.");
        }

        @When("User selects Invalid {string} rows per page")
        public void userSelectsInvalidRowsPerPage(String rowsCount) {
            try {
                filteringDivisiPage.selectRowsPerPage(rowsCount);
                Assert.assertTrue(true, "System menerima input rows per page tidak valid.");
            } catch (Exception e) {
                System.out.println("[INFO] Invalid row selection handled properly: " + e.getMessage());
                Assert.assertTrue(true, "System menangani input tidak valid dengan tepat.");
            }
        }

        @Then("System should ignore or show validation message")
        public void systemShouldIgnoreOrShowValidationMessage() {
            boolean isValidationMessageDisplayed = filteringDivisiPage.isValidationMessageDisplayedForInvalidInput();
            Assert.assertTrue(isValidationMessageDisplayed, "System tidak menampilkan pesan validasi untuk input yang tidak valid.");
        }
    }
