package com.aesis.test.medical_records;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aesis.base.TestBaseClass;
import com.aesis.pages.medical_records.AddMedicalRecordsPage;



public class AddMedicalRecordsTest extends TestBaseClass {
		
		
	
	//WebDriver driver;
		@BeforeSuite
		public void setup() {
			intializeBrowser("chrome");
		}
		
		@AfterSuite
		public void teardown() {
			TestBaseClass.driver.close();
		}
		
		@Test(description ="Valiadate the student medical records")
		public void aesisAddMedicalrecordTest() throws Exception {
			
			AddMedicalRecordsPage medical_record = new AddMedicalRecordsPage(driver);
			
			medical_record.setAesisLoginPageUsername();
			medical_record.setAesisLoginPagePassword();
			medical_record.clickAesisLoginPagebutton();
			Thread.sleep(20000);
			medical_record.enterSixDigitCode();
			medical_record.clickOnContinuebutton();
			Thread.sleep(3000);
			medical_record.verifyToSelectMyStudent();
			Thread.sleep(3000);
			medical_record.verifyToSelectThomasSmithStudent();
			Thread.sleep(3000);
			medical_record.verifySelectMedicalTab();
			Thread.sleep(3000);
			medical_record.verifyClickOnPlusIcon();
			Thread.sleep(3000);
			medical_record.verifyAddMedicalRecord();
			Thread.sleep(3000);
			medical_record.verifySelectCategory();
			Thread.sleep(2000);
			medical_record.verifySelectName();
			Thread.sleep(2000);
			medical_record.verifySelectComment_instruction();
			Thread.sleep(2000);
			medical_record.verifySelectRepotedDate();
			Thread.sleep(2000);
			medical_record.verifyToAddFileuploading();
			Thread.sleep(2000);
			medical_record.VerifySaveMedicalRecords();
			Thread.sleep(3000);
			
		}
				
}
