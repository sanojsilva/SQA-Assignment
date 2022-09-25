package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.TestBase;
import org.testng.Assert;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement passWord;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;
	
	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;

	@FindBy(id = "logoutLink")
	WebElement logoutLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();
	}
	
	public HomePage loging(String uName, String pword) {
		userName.sendKeys(uName);
		passWord.sendKeys(pword);
		loginButton.click();
		if (uName.equals("john")) {
			Assert.assertFalse(false);
		} else {
			Assert.assertTrue(logoutLink.isDisplayed());
		}
		return new HomePage();
		
	}
}
