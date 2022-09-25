package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div[4]/a")
    WebElement approveTimeTrackLink;

    @FindBy(xpath = "//*[@id=\"container\"]/table/tbody/tr/td/div[1]/table/tbody/tr/td[1]")
    WebElement timeTrackPageTitle;

    @FindBy(css = "#approveTTTable .childRow.ready")
    WebElement readyRow;

    @FindBy(id = "approveButton")
    WebElement approveButton;

    @FindBy(id = "rejectButton")
    WebElement rejectButton;

    @FindBy(id = "rejectWeekCommentTextArea")
    WebElement rejectInput;

    @FindBy(xpath = "/html/body/div[13]/div[3]/div/button[1]")
    WebElement rejectInputButton;

    public TimeTrackPage() {
        PageFactory.initElements(driver, this);
    }

    public TimeTrackPage clickApproveTimeTrackLink() {
        approveTimeTrackLink.click();
        return new TimeTrackPage();
    }

    public Boolean timeTrackPageDisplays() {
        return timeTrackPageTitle.isDisplayed();
    }

    public TimeTrackPage clickReadyCheckbox() {
        WebElement chkbox = readyRow.findElement(By.cssSelector("input[type=checkbox]"));
        chkbox.click();
        return new TimeTrackPage();
    }

    public void clickApprove() {
        approveButton.click();
        driver.findElement(By.cssSelector("#approveTTTable .childRow.operationWasApplied.approved"));
    }

    public void clickReject() {
        rejectButton.click();
        rejectInput.sendKeys("Type Reject reason");
        rejectInputButton.click();
        driver.findElement(By.cssSelector("#approveTTTable .childRow.operationWasApplied.rejected"));
    }

}
