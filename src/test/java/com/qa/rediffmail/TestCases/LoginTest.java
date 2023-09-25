package com.qa.rediffmail.TestCases;

import com.qa.rediffmail.Pages.AccountPage;
import com.qa.rediffmail.Pages.LandingPage;
import com.qa.rediffmail.Pages.LoginPage;
import com.qa.rediffmail.TestBase.TestBase;
import com.qa.rediffmail.Utilities.ExcelCode;
import com.qa.rediffmail.Utilities.Util;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    public WebDriver driver;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public LandingPage landingPage;

    public LoginTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void loginSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);
        loginPage = landingPage.navigateToLoginPage();


    }

    @Test(priority=1, dataProvider = "Rediff", dataProviderClass = ExcelCode.class)
    public void verifyLoginWithValidCredentials(String email, String password) {
        accountPage = loginPage.navigateToAccountPage(email, password);
        Assert.assertTrue(accountPage.isLogoutButtonDisplayed());

    }

    @Test(priority=2)
    public void verifyLoginWithValidEmailInvalidPassword() {
        loginPage.navigateToAccountPage(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveErrorMessage().contains(dataprop.getProperty("signInErrorMessage")));
    }

    @Test(priority=3)
    public void verifyLoginWithInvalidEmailValidPassword() {
        loginPage.navigateToAccountPage(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
        Assert.assertTrue(loginPage.retrieveErrorMessage().contains(dataprop.getProperty("signInErrorMessage")));
    }

    @Test(priority=4)
    public void verifyLoginWithInvalidCredential() {
        loginPage.navigateToAccountPage(Util.emailWithDateTimeStamp(), dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveErrorMessage().contains(dataprop.getProperty("signInErrorMessage")));
    }

    @Test(priority = 5)
    public void verifyLoginWithNoCredential(){
        loginPage = new LoginPage(driver);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(loginPage.getAlertText().contains(dataprop.getProperty("expectedAlertMessage")));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
