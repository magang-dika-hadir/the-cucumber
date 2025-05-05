package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ManagementUserPage {
    private WebDriver driver;

    public ManagementUserPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[normalize-space()='Management']")
    private WebElement btnManagement;

    @FindBy(xpath = "//p[normalize-space()='User']")
    private WebElement btnUser;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputNamaUser;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement btnReset;

    @FindBy(xpath = "//button[normalize-space(text())='Search']")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@id, 'job_departement_id')]")
    private WebElement dropDownUnit;

    @FindBy(xpath = "//li[@role='option' and text()='Air Asia']")
    private WebElement airAsia;

    @FindBy(xpath = "//div[@id='mui-component-select-job_level_id']")
    private WebElement dropDownJobLevel;

    @FindBy(xpath = "//li[@role='option' and contains(., 'CS 2')]")
    private WebElement cs2;

    @FindBy(xpath = "//div[contains(@id, 'employee_type_id')]")
    private WebElement dropDownTipeKaryawan;

    @FindBy(xpath = "//li[@role='option' and contains(., 'Mitra')]")
    private WebElement mitra;

    @FindBy(xpath = "//div[@id='mui-component-select-job_position_id']")
    private WebElement dropDownPosisiKerja;

    @FindBy(xpath = "//li[@role='option' and contains(., 'Field Officer')]")
    private WebElement fieldOfficer;

    @FindBy(xpath = "//div[contains(@id, 'location_point_id')]")
    private WebElement dropDownLocation;

    @FindBy(xpath = "//li[@role='option' and contains(., 'Menara BCA')]")
    private WebElement menaraBca;

    @FindBy(xpath = "//div[@id='demo-select-small']")
    private WebElement dropDownStatus;

    @FindBy(xpath = "//li[@role='option' and text()='Aktif']")
    private WebElement aktif;

    @FindBy(xpath = "//button[contains(text(), 'Terapkan')]")
    private WebElement btnTerapkan;

    @FindBy(xpath = "//div[@id='alert-dialog-slide-description']//p[contains(text(), 'Data sisa cuti')]")
    private WebElement txtInvalid;

    @FindBy(xpath = "//h2[contains(text(),'Application error')]")
    private WebElement txtAppError;


    public void setBtnManagement(){
        btnManagement.click();
    }

    public void setBtnUser(){
        btnUser.click();
    }

    public String getTxtAppError(){
        return txtAppError.getText();
    }
}
