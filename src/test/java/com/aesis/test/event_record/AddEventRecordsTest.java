package com.aesis.test.event_record;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aesis.base.TestBaseClass;
import com.aesis.pages.events_records.AddEventRecordPage;
import com.aesis.pages.medical_records.AddMedicalRecordsPage;

public class AddEventRecordsTest extends TestBaseClass {

	//WebDriver driver;
//			@BeforeClass
//			public void setup() {
//				intializeBrowser("chrome");
//			}
//			
//			@AfterClass
//			public void teardown() {
//				TestBaseClass.driver.close();
//			}
			
			@Test(description ="Valiadate the student Event records")
			public void aesisEventRecord() throws Exception {
				
				AddEventRecordPage event_record = new AddEventRecordPage(driver);
				
//				event_record.setAesisLoginPageUsername();
//				event_record.setAesisLoginPagePassword();
//				event_record.clickAesisLoginPagebutton();
//				Thread.sleep(20000);
//				//event_record.enterSixDigitCode();
//				event_record.clickOnContinuebutton();
//				Thread.sleep(2000);
				event_record.verifyToSelectMyStudent();
				Thread.sleep(3000);
				event_record.verifyToSelectThomasSmithStudent();
				Thread.sleep(3000);
				event_record.verifySelectEventTab();;
				Thread.sleep(3000);
				event_record.verifyClickOnPlusIcon();
				Thread.sleep(3000);
				event_record.verifyAddEventRecord();
				Thread.sleep(3000);
				event_record.verifySelectCategory();
				Thread.sleep(3000);
				event_record.verifySelectComment();
				Thread.sleep(3000);
				event_record.verifyActionneeded_Taken();
				Thread.sleep(3000);
				event_record.verifyInternalNotes();
				Thread.sleep(3000);
				event_record.verifySelectRepotedDate();
				Thread.sleep(2000);
				event_record.VerifySaveEventRecords();
				Thread.sleep(3000);
				
			}
}
