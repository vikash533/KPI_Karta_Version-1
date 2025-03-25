package com.kpi.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.LoginPage;
import com.kpi.page_object.MyProfile;

public class MyProfileTest extends BaseClass {
	WebDriver driver;
	LoginPage lp;
	MyProfile mpp;
	
	SoftAssert softAssert = new SoftAssert();
	Actions action = new Actions();
		
	@BeforeClass
	public void launchBrowser() {
		try {
			driver= openBrowser();
			driver.get(prop.getProperty("baseUrl"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void myProfilePageLanding() {
		lp =new LoginPage(driver);
		mpp = new MyProfile(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		action.clickOnElement(mpp.clickNavigation());
		mpp.btnMyProfile.click();
		Assert.assertEquals(driver.getTitle(), prop.getProperty("mypRofileTitle"), "My Profile Title not matching - Test Failed");
		
	}

}
