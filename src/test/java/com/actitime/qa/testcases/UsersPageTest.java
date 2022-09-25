package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;

    public UsersPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = new UsersPage();
    }

    @Test(priority = 1)
    public void goToUserPage() {
        usersPage.goToUsersPage();
    }

    @Test(priority = 2)
    public void usersPageLogoTest() {
        boolean flag= usersPage.validateActiTimeLogo();
        Assert.assertTrue(flag,"Cannot find the Logo");
    }

    @Test(priority = 2)
    public void openNewUserPanel() {
        usersPage.goToUsersPage();
        boolean flag= usersPage.addUser();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void selectUserTest() {
        usersPage.goToUsersPage();
        boolean flag = usersPage.clickOnUsersLink();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}