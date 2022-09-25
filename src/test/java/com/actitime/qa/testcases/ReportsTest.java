package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ReportsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportsTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ReportsPage reportsPage;

    public ReportsTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
        reportsPage = new ReportsPage();
        homePage.switchToActiPlans();
    }

    @Test(priority = 1)
    public void goToLeaveManagementWorks() {
        reportsPage.clickLeaveMgtLink().leaveMgtLinkTitleVisible();
    }

    @Test(priority = 2)
    public void goToLeaveTimeRequests() {
        reportsPage.clickLeaveMgtLink().leaveMgtLinkTitleVisible();
        reportsPage.clickLeaveTimeRequestsButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
