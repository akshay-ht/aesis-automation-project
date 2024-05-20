package com.aesis.pages.events_records;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aesis.base.TestBaseClass;
import com.aesis.utility.ReadConfig;
import com.aesis.utility.commonUtils;
import com.aesis.utility.readOtpByMail;

public class AddEventRecordPage extends TestBaseClass{

	// Declaration

	ReadConfig readConfig = new ReadConfig();
	readOtpByMail readotp = new readOtpByMail();
	commonUtils utility = new commonUtils();

	@FindBy(xpath = "//*[@id='email-required']")
	private WebElement enter_ae_id;
	@FindBy(xpath = "//*[@id='password-required']")
	private WebElement enter_password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_btn;
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div/form/div[1]")
	private WebElement enter_otp;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickon_continue_btn;
	@FindBy(xpath = "//a[text()='My Students']")
	private WebElement select_my_student;
	@FindBy(xpath = "//*[text()='Thomas  Smith']")
	private WebElement select_thomas_smith_student;
	@FindBy(xpath = "//button[text()='Events']")
	private WebElement select_events_tab;
	@FindBy(xpath = "//button[@aria-label='Action Bar']")
	private WebElement click_on_plus_icon;
	@FindBy(xpath = "//*[text()='Add Event']")
	private WebElement select_add_event;
	@FindBy(xpath = "//div[@id='event_category']")
	private WebElement select_category;
	@FindBy(xpath = "//textarea[@id='comment']")
	private WebElement select_comment;
	@FindBy(xpath = "//textarea[@id='event_action']")
	private WebElement select_actionneeded_taken;
	@FindBy(xpath = "//textarea[@id='internal_notes']")
	private WebElement select_internal_notes;
	@FindBy(xpath = "//button[@aria-label='Choose date']")
	private WebElement select_action_date;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement click_on_save_btn;

	// intialization

	public AddEventRecordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// usage

	public void setAesisLoginPageUsername() {

		enter_ae_id.sendKeys(readConfig.getUserName());
		// enter_ae_id.sendKeys("akshay.patil1541@gmail.com");
		Assert.assertTrue(enter_ae_id.isDisplayed(), "Aesis Username Field is not displayed on login page");
		Assert.assertTrue(enter_ae_id.isEnabled(), "Aesis Username Field is not enabled on login page");
		Reporter.log("setAesisLoginPageUsername", true);
	}

	public void setAesisLoginPagePassword() {

		enter_password.sendKeys(readConfig.getPassword());
		// enter_password.sendKeys("password");
		Assert.assertTrue(enter_password.isDisplayed(), "Aesis Password Field is not displayed on login page");
		Assert.assertTrue(enter_password.isEnabled(), "Aesis Password Field is not enabled on login page");
		Reporter.log("setAesisLoginPagePassword", true);
	}

	public void clickAesisLoginPagebutton() {

		login_btn.click();
		Assert.assertTrue(login_btn.isDisplayed(), "Aesis Login Button is not displayed on login page");
		Assert.assertTrue(login_btn.isEnabled(), "Aesis Login Button is not Enabled on login page");
		Reporter.log("clickAesisLoginPagebutton", true);
	}

	public void enterSixDigitCode() throws Exception {
		// enter_otp.sendKeys(readotp.getReadOtpByEmail());
		//Reporter.log("enterSixDigitCode", true);

	}

	public void clickOnContinuebutton() {
		clickon_continue_btn.click();
		Reporter.log("clickOnContinuebutton", true);

	}

	public void verifyToSelectMyStudent() {
		select_my_student.click();
		Reporter.log("verifyToSelectMyStudent", true);

	}

	public void verifyToSelectThomasSmithStudent() {
		select_thomas_smith_student.click();
		Reporter.log("verifyToSelectThomasSmithStudent", true);

	}
	
	public void verifySelectEventTab() {
		select_events_tab.click();
		Reporter.log("verifySelectEventTab", true);

	}

	public void verifyClickOnPlusIcon() {
		click_on_plus_icon.click();
		Reporter.log("verifyClickOnPlusIcon", true);

	}

	public void verifyAddEventRecord() {
		select_add_event.click();
		Reporter.log("verifyAddEventRecord", true);

	}

	public void verifySelectCategory() {

		select_category.click();
		
		driver.findElement(By.xpath("//li[text()='Academic']")).click();
//		Select s = new Select(select_category);
//		s.selectByVisibleText("Allergy");
		Reporter.log("verifySelectCategory", true);

	}
	
	public void verifySelectComment() throws EncryptedDocumentException, IOException {
		select_comment.sendKeys(utility.getStringTestData(3, 2));
		Reporter.log("verifySelectComment", true);

	}

	public void verifyActionneeded_Taken() throws EncryptedDocumentException, IOException {
		select_actionneeded_taken.sendKeys(utility.getStringTestData(3, 3));
		Reporter.log("verifyActionneeded_Taken", true);

	}
	
	public void verifyInternalNotes() throws EncryptedDocumentException, IOException {
		select_internal_notes.sendKeys(utility.getStringTestData(3, 4));
		Reporter.log("verifyInternalNotes", true);

	}

	public void verifySelectRepotedDate() throws EncryptedDocumentException, IOException {
		
		select_action_date.click();
		while (!driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-label css-dplwbx-MuiPickersCalendarHeader-label']")).getText().contains("May 2024")) {
			driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			
		}

		List<WebElement> datelist = driver.findElements(By.xpath("//div[@role='rowgroup']/div/button"));
		System.out.println("Total days in months:" + datelist.size());

		for (int i = 1; i < datelist.size(); i++) {
			String datetext = datelist.get(i).getText();
			if (datetext.equalsIgnoreCase("28")) {
				datelist.get(i).click();
				break;
			}
		}
		Reporter.log("verifySelectRepotedDate", true);

	}
	
	public void VerifySaveEventRecords() {
		click_on_save_btn.click();
		Reporter.log("VerifySaveEventRecords", true);

	}

}
