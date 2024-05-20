package com.aesis.pages.medical_records;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.aesis.utility.ReadConfig;
import com.aesis.utility.commonUtils;
import com.aesis.utility.readOtpByMail;
import com.aesis.base.TestBaseClass;

public class AddMedicalRecordsPage extends TestBaseClass {

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
	@FindBy(xpath = "//button[text()='Medical']")
	private WebElement select_medical_tab;
	@FindBy(xpath = "//button[@aria-label='Action Bar']")
	private WebElement click_on_plus_icon;
	@FindBy(xpath = "//*[text()='Add Medical Record']")
	private WebElement select_add_medical_record;
	@FindBy(xpath = "//div[@aria-haspopup='listbox']")
	private WebElement select_category;
	@FindBy(xpath = "//*[@id='name']")
	private WebElement select_name;
	@FindBy(xpath = "//*[@id='comment_or_instruction']")
	private WebElement select_comment_or_instruction;
	@FindBy(xpath = "//button[@aria-label='Choose date, selected date is May 27, 2023']")
	private WebElement select_reported_date;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-83oy9i-MuiTypography-root']")
	private WebElement add_document;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement click_on_save_btn;

	// intialization

	public AddMedicalRecordsPage(WebDriver driver) {
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

	public void verifySelectMedicalTab() {
		select_medical_tab.click();
		Reporter.log("verifySelectMedicalTab", true);
	}

	public void verifyClickOnPlusIcon() {
		click_on_plus_icon.click();
		Reporter.log("verifyClickOnPlusIcon", true);
	}

	public void verifyAddMedicalRecord() {
		select_add_medical_record.click();
		Reporter.log("verifyAddMedicalRecord", true);
	}

	public void verifySelectCategory() {

		select_category.click();
		
		driver.findElement(By.xpath("//li[text()='Allergy']")).click();
//		Select s = new Select(select_category);
//		s.selectByVisibleText("Allergy");
		Reporter.log("verifySelectCategory", true);
	}

	public void verifySelectName() throws EncryptedDocumentException, IOException {
		select_name.sendKeys(utility.getStringTestData1(3, 2));
		Reporter.log("verifySelectName", true);
	}

	public void verifySelectComment_instruction() throws EncryptedDocumentException, IOException {
		select_comment_or_instruction.sendKeys(utility.getStringTestData1(3, 3));
		Reporter.log("verifySelectRepotedDate", true);
	}

	public void verifySelectRepotedDate() throws EncryptedDocumentException, IOException {
		select_reported_date.click();
		while (!driver
				.findElement(By.xpath(
						"//div[@class='MuiPickersCalendarHeader-label css-dplwbx-MuiPickersCalendarHeader-label']"))
				.getText().contains("May 2024")) {
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

	public void verifyToAddFileuploading() throws EncryptedDocumentException, IOException, AWTException {
		commonUtils.scrollIntoViewbyJS(driver, add_document);
		
		add_document.click();

		Robot rb = new Robot();

		// put path to file in a clipboard
		StringSelection ss = new StringSelection("Sample File .doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		// add_document.sendKeys(System.getProperty("user.dir")+"/excel_testdata/Sample
		// File .doc");
		Reporter.log("verifyToAddFileuploading", true);
	}

	public void VerifySaveMedicalRecords() {
		click_on_save_btn.click();
		Reporter.log("VerifySaveMedicalRecords", true);
	}

}
