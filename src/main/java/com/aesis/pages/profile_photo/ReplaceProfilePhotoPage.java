package com.aesis.pages.profile_photo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.aesis.utility.ReadConfig;
import com.aesis.utility.commonUtils;
import com.aesis.utility.readOtpByMail;

public class ReplaceProfilePhotoPage {


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
	@FindBy(xpath = "//button[text()='Account']")
	private WebElement select_account_tab;
	@FindBy(xpath = "//button[text()='Replace']")
	private WebElement select_replace_tab;
	
	// intialization

		public ReplaceProfilePhotoPage(WebDriver driver) {
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

		public void verifySelectAccountTab() {
			select_account_tab.click();
			Reporter.log("verifySelectAccountTab", true);
		}

		public void verifyToReplaceProfile() throws EncryptedDocumentException, IOException, AWTException {
			
			select_replace_tab.click();

			Robot rb = new Robot();

			// put path to file in a clipboard
			StringSelection ss = new StringSelection("Profile Photo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			// add_document.sendKeys(System.getProperty("user.dir")+"/excel_testdata/Sample
			// File .doc");
			Reporter.log("verifyToReplaceProfile", true);
		}

	
}
