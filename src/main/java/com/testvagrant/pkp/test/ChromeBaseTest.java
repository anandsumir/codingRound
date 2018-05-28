package com.testvagrant.pkp.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.testvagrant.pkp.helpers.drivers.DriverHelperFactory;
import com.testvagrant.pkp.utils.CommonUtils;

public class ChromeBaseTest {
	
	@BeforeSuite
	public void setupBeforeSuite() {
		CommonUtils.setDriverPath();
	}
	
	@BeforeClass
	public void setupBeforeClass() throws Exception {
		DriverHelperFactory.initWithBrowser("Chrome");
	}
	
	@AfterClass
	public void setupAfterClass() {
		//DriverHelperFactory.getDriver().quit();
	}

}
