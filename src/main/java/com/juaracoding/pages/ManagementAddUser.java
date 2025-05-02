package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagementAddUser {

    private WebDriver driver;

    public ManagementAddUser() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // ===== XPath =====
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[4]")
    private WebElement managementButton;

    @FindBy(xpath = "//p[normalize-space()='Pendaftaran User']")
    private WebElement addUserButton;

    // ===== Account Information =====
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//input[@id='nik']")
    private WebElement nik;

    @FindBy(xpath = "//input[@id='fullname']")
    private WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    // ===== Work Information =====
    @FindBy(xpath = "//input[@id='divisi']")
    private WebElement division;

    @FindBy(xpath = "//input[@id='unit']")
    private WebElement unit;

    @FindBy(xpath = "//input[@id='posisi-kerja']")
    private WebElement jobPosition;

    @FindBy(xpath = "//input[@id='jabatan']")
    private WebElement jobTitle;

    @FindBy(xpath = "//input[@id='tipe-kontrak']")
    private WebElement contractType;

    // ===== Attendance Settings =====
    @FindBy(xpath = "//input[@id='lokasi-kerja']")
    private WebElement workLocation;

    @FindBy(xpath = "//div[@id='shift_type']")
    private WebElement shiftType;

    @FindBy(xpath = "//input[@id='jadwal-kerja']")
    private WebElement workSchedule;

    @FindBy(xpath = "//div[@id='required_selfie']")
    private WebElement selfieRequirement;

    @FindBy(xpath = "//input[@id='jumlah-cuti']")
    private WebElement leaveQuota;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement submitButton;

    // ===== File Path =====
    private final String filePath = System.getProperty("user.dir") + "/src/main/resources/uploads/ManagementAddUser/profile.jpg";

    // ===== Actions =====

    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5); // Adjust timeout as needed
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectDropdownOption(String optionText) {
        WebElement option = driver.findElement(By.xpath("//li[contains(text(),'" + optionText + "')]"));
        option.click();
    }

    public void scrollTO(int to) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + to + ")");
    }

    public void navigateManagement() {
        System.out.println("NavigateManagement");
        managementButton.click();
    }

    public void navigateAddUser() {
        addUserButton.click();
    }

    public void uploadFile(String data) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/uploads/ManagementAddUser/"+ data;
        fileInput.sendKeys(filePath);
    }

    public void fillNik(String nikValue) {
        nik.sendKeys(nikValue);
    }

    public void fillName(String nameText) {
        name.sendKeys(nameText);
    }

    public void fillEmail(String emailText) {
        email.sendKeys(emailText);
    }

    public void fillPassword(String passwordText) {
        password.sendKeys(passwordText);
    }

    public void selectDivision(String divisionName) {
        division.click();
        selectDropdownOption(divisionName);
    }

    public void selectUnit(String unitName) {
        unit.click();
        selectDropdownOption(unitName);
    }

    public void selectJobPosition(String jobPositionName) {
        jobPosition.click();
        selectDropdownOption(jobPositionName);
    }

    public void selectJobTitle(String jobTitleName) {
        jobTitle.click();
        selectDropdownOption(jobTitleName);
    }

    public void selectContractType(String contractTypeName) {
        contractType.click();
        selectDropdownOption(contractTypeName);
    }

    public void selectWorkLocation(String workLocationName) {
        workLocation.click();
        selectDropdownOption(workLocationName);
    }

    public void selectShiftType(String shiftTypeName) {
        shiftType.click();
        selectDropdownOption(shiftTypeName);
    }

    public void selectWorkSchedule(String workScheduleName) {
        workSchedule.click();
        selectDropdownOption(workScheduleName);
    }

    public void selectSelfieRequirement(String selfieOption) {
        selfieRequirement.click();
        selectDropdownOption(selfieOption);
    }

    public void fillLeaveQuota(String leaveQuotaValue) {
        leaveQuota.sendKeys(leaveQuotaValue);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void navigateToManagementAddUser() {
        navigateManagement();
        navigateAddUser();
    }

    public WebElement getErrorMessageElement(String errorMessage) {
        try {
            return driver.findElement(By.xpath("//*[contains(text(), '" + errorMessage + "')]"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}