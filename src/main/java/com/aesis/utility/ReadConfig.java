package com.aesis.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

public class ReadConfig {

	Properties p;
	FileInputStream fis;
	
	public ReadConfig() {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/configuration/testConfig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getUserName() {
		return p.getProperty("username");
	}
	
	public String getPassword() {
		return p.getProperty("password");
	}
	
	public String getUrl() {
		return p.getProperty("stage_url");
	}
	
}
