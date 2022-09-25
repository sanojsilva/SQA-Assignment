package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.TimeTrackPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeTrackPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TimeTrackPage timeTrackPage;

	public TimeTrackPageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		timeTrackPage = new TimeTrackPage();
	}
	
	@Test(priority = 1)
	public void homePageLogoTest() {
		boolean flag = homePage.validateActiTimeLogo();
		Assert.assertTrue(flag, "Cannot find the Logo");
	}

	@Test(priority = 2)
	public void approveTimeTrackPageOpens() {
		timeTrackPage.clickApproveTimeTrackLink().timeTrackPageDisplays();
	}

	@Test(priority = 3)
	public void approveTimeSheet() {
		timeTrackPage.clickApproveTimeTrackLink().timeTrackPageDisplays();
		timeTrackPage.clickReadyCheckbox().clickApprove();
	}

	@Test(priority = 4)
	public void rejectTimeSheet() {
		timeTrackPage.clickApproveTimeTrackLink().timeTrackPageDisplays();
		timeTrackPage.clickReadyCheckbox().clickReject();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
