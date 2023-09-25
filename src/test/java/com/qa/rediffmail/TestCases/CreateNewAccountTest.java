package com.qa.rediffmail.TestCases;

import com.qa.rediffmail.Pages.CreateAccountPage;
import com.qa.rediffmail.Pages.LandingPage;
import com.qa.rediffmail.TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TestBase {
    public WebDriver driver;
    public LandingPage landingPage;
    public CreateAccountPage createAccountPage;

    public CreateNewAccountTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void loginSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);
        createAccountPage = landingPage.navigateToCreateAccountLink();
    }
    @Test(priority = 1)
    public void verifyCreateAccountWithValidDetail(){
        createAccountPage.enterFullName("Fatema Zannat");
        createAccountPage.enterRediffMailId("fz2638");
        createAccountPage.enterPassword("Fatema@123");
        createAccountPage.reEnterPassword("Fatema@123");
        //createAccountPage.driver.findElement(By.xpath("//td[@width = '185']//input[@name='altemail8e989bac']")).sendKeys("aaa");
        createAccountPage.enterPhoneNumber("1234567654");
        Assert.assertTrue(createAccountPage.isCreateMyAccountButtonDisplayed());
    }

    @AfterMethod
    public void tearUp(){
        driver.quit();
    }


}
