package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//button[@aria-label='menu' and @aria-controls='profile-menu']")
    private WebElement btnProfil;

    @FindBy(xpath = "//button[normalize-space(text())='Logout']")
    private WebElement btnLogout;

    public void loginUsername(String username, String password){
        this.email.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void setBtnSubmit(){

        btnSubmit.click();
    }

    public void setBtnProfil(){
        btnProfil.click();
    }
    public void setBtnLogout(){

        btnLogout.click();
    }
}
