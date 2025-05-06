package com.juaracoding.pages.management.divisi;

import com.juaracoding.drivers.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditDivisiPage {

        private WebDriver driver;
        private WebDriverWait wait;

        @FindBy(css = "li.MuiMenuItem-root")
        private WebElement editButton;

        @FindBy(css = "input#name[name='name']")
        private WebElement inputNamaDivisi;

        @FindBy(xpath = "//button[contains(text(),'Simpan')]")
        private WebElement simpanButton;

        @FindBy(css = "button[type='button']:contains('Batal')")
        private WebElement batalButton;

        @FindBy(xpath = "//*[text()='harap isi bidang']")
        private WebElement warningEmptyEdit;

        @FindBy(xpath = "//*[contains(text(),'sudah ada')]")
        private WebElement warningDuplicateEdit;

        @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and contains(text(),'Berhasil Menambahkan Divisi')]")
        private WebElement successTambahMessage;

        @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and contains(text(),'Berhasil Delete Divisi')]")
        private WebElement successDeleteMessage;

        @FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message') and contains(text(),'Berhasil Edit Divisi')]")
        private WebElement successEditMessage;

        public EditDivisiPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            PageFactory.initElements(driver, this);
        }


        public void clickThreeDotButton(String divisiName) {
            String xpath = "//tr[.//td//h6[normalize-space()='" + divisiName + "']]//button[@aria-label='action']";
            Utils.clickElement(driver, By.xpath(xpath));

        }

        public void clickEditButton() {
            Utils.clickElement(driver, editButton);
        }

        public void inputNamaDivisi(String nama) {
            Utils.sendKeysToElement(driver, inputNamaDivisi, nama);
        }

        public void clickSimpan() {
            Utils.clickElement(driver, simpanButton);
        }

        public void clickBatal() {
            Utils.clickElement(driver, batalButton);
        }


        public boolean isWarningEmptyEditDisplayed() {
            return Utils.isElementVisible(driver, By.id("warningEmptyEdite"));
        }

        public boolean isWarningDuplicateEditDisplayed() {
            return Utils.isElementVisible(driver, By.id("warningDuplicateEdit"));
        }

        public boolean isSuccessTambahMessageDisplayed() {
            return Utils.isElementVisible
                    (driver, By.id("successTambahMessage"));
        }

        public boolean isSuccessDeleteMessageDisplayed() {
            return Utils.isElementVisible(driver, By.id("successDeleteMessage"));
        }

        public boolean isSuccessEditMessageDisplayed() {
            return Utils.isElementVisible(driver, By.id("successEditMessage"));
        }


        public String getSuccessEditMessage() {
            try {
                WebElement message = Utils.waitUntilVisible(driver, By.xpath("//div[@role='alert']//div[contains(@class, 'MuiSnackbarContent-message')]"));
                return message != null ? message.getText() : "";
            } catch (NoSuchElementException | TimeoutException e) {
                return "";
            }
        }

        public String getValidationMessageOfNamaDivisi() {
            WebElement field = Utils.waitUntilVisible(driver, By.id("name"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript("return arguments[0].validationMessage;", field);
        }
    }

