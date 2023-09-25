package com.qa.rediffmail.TestCases;

import com.qa.rediffmail.Pages.LandingPage;
import com.qa.rediffmail.Pages.ShoppingPage;
import com.qa.rediffmail.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {
    public WebDriver driver;
    public ShoppingPage shoppingPage;
    public LandingPage landingPage;

    public ShoppingTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void loginSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);
        shoppingPage = landingPage.clickOnShoppingLink();
    }
    @Test(priority = 1)
    public void verifyMensLifestyleOption(){
        shoppingPage.clickOnMensLifeStyleOption();
        Assert.assertTrue(shoppingPage.retrieveHeadingForMensLifeStyleOption()
                .contains(dataprop.getProperty("headingTextForMensLifeStyleOption")));

    }
    @Test(priority = 2)
    public void verifySearchWithValidProduct(){
        shoppingPage.validateSearchProduct(dataprop.getProperty("validProduct"));
        Assert.assertTrue(shoppingPage.retrieveTextFromValidSearchHeading()
                .contains(dataprop.getProperty("headingTextForValidProductSearch")));
    }

    @Test(priority = 3)
    public void verifyInvalidSearch(){
        shoppingPage.validateSearchProduct(dataprop.getProperty("invalidProduct"));
        Assert.assertTrue(shoppingPage.retrieveTextFromInvalidSearchHeading()
                .contains(dataprop.getProperty("invalidProductSearchErrorMessage")));

    }

    @AfterMethod()
    public void tearUp(){
        driver.quit();
    }
}
