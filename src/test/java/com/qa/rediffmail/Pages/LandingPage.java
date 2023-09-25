package com.qa.rediffmail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class = 'cell topicons']//a[text() = 'Shopping']")
    private WebElement shoppingLink;

    @FindBy(linkText = "Create Account")
    private WebElement createAccountLink;


    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginPage() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public ShoppingPage clickOnShoppingLink(){
        shoppingLink.click();
        return new ShoppingPage(driver);
    }

    public void clickOnSignInLink(){
        signInLink.click();
    }
    public CreateAccountPage navigateToCreateAccountLink(){
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }
}
