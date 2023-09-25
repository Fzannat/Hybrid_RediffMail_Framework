package com.qa.rediffmail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
    public WebDriver driver;

    @FindBy(id = "topcat1")
    private WebElement mensLifeStyleLink;

    @FindBy(className = "div_bread")
    private WebElement headingForMensLifeStyleOption;

    @FindBy(id = "srchword")
    private WebElement searchBox;

    @FindBy(className = "newsrchbtn")
    private WebElement searchButton;

    @FindBy(xpath = "//a [text() = 'T Shirt Online in India']")
    private WebElement searchHeadingForValidProduct;

    @FindBy(css = "div.grey1.f16.bold")
    private WebElement errorMessageForInvalidSearch;


    public ShoppingPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMensLifeStyleOption(){
        mensLifeStyleLink.click();
    }
    public String retrieveHeadingForMensLifeStyleOption(){
        String heading = headingForMensLifeStyleOption.getText();
        return heading;
    }
    public void enterProductNameToSearchBox(String productName){
        searchBox.sendKeys(productName);
    }
    public void clickOnSearchButton(){
        searchButton.click();
    }
    public String retrieveTextFromValidSearchHeading(){
        String headingForValidProductText = searchHeadingForValidProduct.getText();
        return headingForValidProductText;
    }
    public String retrieveTextFromInvalidSearchHeading(){
        String headingForInvalidProductText =errorMessageForInvalidSearch.getText();
        return headingForInvalidProductText;
    }
    public void validateSearchProduct(String product){
        searchBox.sendKeys(product);
        searchButton.click();

    }
}
