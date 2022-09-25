package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase  {

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr/td[4]/a")
    WebElement leaveMgtLink;

    @FindBy(xpath = "//*[@id=\"contentInnerDiv\"]/div")
    WebElement leaveMgtPageTitle;

    @FindBy(xpath = "//*[@id=\"leaveTimePlanningPage\"]/tbody/tr[1]/td/div/span[2]/a")
    WebElement leaveTimeRequestsButton;

    public ReportsPage() {
        PageFactory.initElements(driver, this);
    }

    public ReportsPage clickLeaveMgtLink() {
        leaveMgtLink.click();
        return new ReportsPage();
    }

    public Boolean leaveMgtLinkTitleVisible() {
        return leaveMgtPageTitle.isDisplayed();
    }

    public ReportsPage clickLeaveTimeRequestsButton() {
        leaveTimeRequestsButton.click();
        return new ReportsPage();
    }

}
