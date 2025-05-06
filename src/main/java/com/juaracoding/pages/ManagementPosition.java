package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ManagementPosition {

    private WebDriver driver;

    public ManagementPosition() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[4]")
    private WebElement managementButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Posisi']")
    private WebElement posisiButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement reset;

    @FindBy(xpath = "//button[contains(@class, 'btn-search css-mj1r98')]")
    private WebElement search;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement tambahkan;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement namaPosisiInput;

    @FindBy(xpath = "//div[contains(@class, 'css-1wuqy62')]")
    private WebElement namaDepartementDropdown;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedSizeMedium css-4075ia')]")
    private WebElement tambah;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-textSizeMedium css-18ozr2e')]")
    private WebElement batal;


    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]/h6")
    private WebElement hasilPosisi;

    // ACTION

    public void selectDropdownOption(String optionText) {
        WebElement option = driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"));
        option.click();
    }

    public void navigateManagement() {
        System.out.println("NavigateManagement");
        managementButton.click();
    }

    public void navigatePosisi() {
        posisiButton.click();
    }

    public void navigateToManagementPosisi() {
        navigateManagement();
        navigatePosisi();
    }

    public void enterSearchPosition(String searchPosition) {
        searchInput.sendKeys(searchPosition);
    }

    public void clickReset() {
        reset.click();
    }

    public void clickSearch() {
        search.click();
    }

    public void clickTambahkan() {
        System.out.println("TAMBAHKAN");
        tambahkan.click();
    }

    public void fillNamaPosisi(String namaPosisi) {
        namaPosisiInput.sendKeys(namaPosisi);
    }

    public void fillNamaDepartementDropdown(String departementName) {
        namaDepartementDropdown.click();
        selectDropdownOption(departementName);
    }

    public void clickTambah() {
        tambah.click();
    }

    public void clickBatal() {
        batal.click();
    }

    public String hasilPosisi() {
        try {
            return hasilPosisi.getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public String getMessageElement(String message, String component) {
        try {
            String messageFromAttribute = null;
            if (Objects.equals(component, "positionName")) {
                messageFromAttribute = namaPosisiInput.getAttribute("validationMessage");
            }

            if (messageFromAttribute != null && !messageFromAttribute.isEmpty()) {
                System.out.println("MESSAGE (from text): " + messageFromAttribute);
                return messageFromAttribute;
            }
            String messageFromText = driver.findElement(By.xpath("//*[contains(text(), '" + message + "')]")).getText();
            System.out.println("=========MESSAGE (from text): " + messageFromText);

            return messageFromText;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }


}
