package com.qa.rediffmail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    public WebDriver driver;

    @FindBy(xpath = "//td[@width = '200']//input" )
    private WebElement fullNameAddressBox;

    @FindBy(xpath = "//td[@valign = 'bottom']//input[@type = 'text']")
    private WebElement chooseRediffMailId;

    @FindBy(id = "newpasswd")
    private WebElement passwordAddressBox;

    @FindBy(id = "newpasswd1")
    private WebElement reEnterPasswordAddressBox;

    @FindBy(xpath = "//td[@width = '185']//input[@name='altemail8e989bac']")
    private WebElement alternateEmailAddressBox;

    @FindBy(id = "mobno")
    private WebElement mobileNumberAddressBox;

    @FindBy(id = "Register")
    private WebElement createMyAccountButton;


   public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String fullName){
       fullNameAddressBox.sendKeys(fullName);
    }
    public void enterRediffMailId(String rediffMailId){
       chooseRediffMailId.sendKeys(rediffMailId);
    }

    public void enterPassword(String password){
       passwordAddressBox.sendKeys(password);
    }
    public void reEnterPassword(String password){
        reEnterPasswordAddressBox.sendKeys(password);
    }
    public void enterAlternateEmail(String alternateEmail){
       alternateEmailAddressBox.sendKeys(alternateEmail);
    }
    public void enterPhoneNumber(String phoneNumber){
       passwordAddressBox.sendKeys(phoneNumber);
    }
    public boolean isCreateMyAccountButtonDisplayed(){
       boolean createMyAccountButtonIsDisplayed = createMyAccountButton.isDisplayed();
       return createMyAccountButtonIsDisplayed;
    }
}
