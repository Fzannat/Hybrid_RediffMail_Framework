package com.qa.rediffmail.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "login1")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passwordAddress;

    @FindBy(className = "signinbtn")
    private WebElement signInButton;

    @FindBy(id = "div_login_error")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void sendUserName(String email){
        userName.sendKeys(email);
    }

    public void enterPassword(String password){
       passwordAddress.sendKeys(password);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }


    public AccountPage clickOnLoginButton() {
        signInButton.click();
        return new AccountPage(driver);
    }


    public AccountPage navigateToAccountPage(String emailText, String passwordText) {
        userName.sendKeys(emailText);
      passwordAddress.sendKeys(passwordText);
        signInButton.click();
        return new AccountPage(driver);
    }


    public String retrieveErrorMessage(){
        String errorMessage = loginErrorMessage.getText();
        return errorMessage;
    }
    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;

    }

}
