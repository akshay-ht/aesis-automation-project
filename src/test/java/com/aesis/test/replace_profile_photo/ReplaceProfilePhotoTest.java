package com.aesis.test.replace_profile_photo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aesis.base.TestBaseClass;
import com.aesis.pages.events_records.AddEventRecordPage;
import com.aesis.pages.profile_photo.ReplaceProfilePhotoPage;

public class ReplaceProfilePhotoTest extends TestBaseClass {

	//WebDriver driver;
//	@BeforeClass
//	public void setup() {
//		intializeBrowser("chrome");
//	}
//	
//	@AfterClass
//	public void teardown() {
//		//TestBaseClass.driver.close();
//	}
	
	@Test(description ="Valiadate the student replace profile photo")
	public void aesisReplaceProfilePhoto() throws Exception {
		
		ReplaceProfilePhotoPage replace_profile = new ReplaceProfilePhotoPage(driver);
		
//		replace_profile.setAesisLoginPageUsername();
//		replace_profile.setAesisLoginPagePassword();
//		replace_profile.clickAesisLoginPagebutton();
//		Thread.sleep(40000);
//		//replace_profile.enterSixDigitCode();
//		replace_profile.clickOnContinuebutton();
//		Thread.sleep(4000);
		replace_profile.verifyToSelectMyStudent();
		Thread.sleep(4000);
		replace_profile.verifyToSelectThomasSmithStudent();
		Thread.sleep(4000);
		replace_profile.verifySelectAccountTab();;
		Thread.sleep(4000);
		replace_profile.verifyToReplaceProfile();
		Thread.sleep(5000);
		
		
	}
}
