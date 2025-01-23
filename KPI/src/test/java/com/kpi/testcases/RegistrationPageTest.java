package com.kpi.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.Registrationpage;

public class RegistrationPageTest extends BaseClass {
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		try {
			driver= openBrowser();
			driver.get(prop.getProperty("baseUrl"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	@AfterClass
//	public void closeBrowser() {
//		driver.quit();
//	}
	@Test
	public void registrationPageLanding() {
		Registrationpage registrationpage = new Registrationpage(driver);
		Actions action = new Actions();

		action.clickOnElement(registrationpage.getCreateAccoutButton());
		
		
	}
	

}
