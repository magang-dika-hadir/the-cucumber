package com.juaracoding.pages.login;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



    private WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ar04jk']")
    private WebElement txtDashboard;

    public void loginUser(){
        email.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();
    }

    public void loginUsernamePassword(){
        email.sendKeys("admin@hadir.com");
        password.sendKeys("MagangSQA_JC@123");
    }

    public void setLoginBtn(){
        loginBtn.click();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }



}
