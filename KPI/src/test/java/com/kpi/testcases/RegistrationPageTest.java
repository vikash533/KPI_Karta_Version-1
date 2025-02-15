package com.kpi.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	
	@AfterClass
//	public void closeBrowser() {
//		driver.quit();
//	}
	
	@Test(priority=1)
	public void registrationPageLanding() {
		Registrationpage registrationpage = new Registrationpage(driver);
		Actions action = new Actions();

		action.clickOnElement(registrationpage.getCreateAccoutButton());
		
		
		//Title
		
	}
	
	@Test (priority=2)
	public void lableRegistrationPagefield() {
		Registrationpage registrationpage = new Registrationpage(driver);
		Actions action = new Actions();
		
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableSignup()),prop.getProperty("lableSignuptext"),"Lable Signup error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableFullName()),prop.getProperty("lableTxtFullName"),"Lable Full Name error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableEmail()), prop.getProperty("lableTxtEmail", "Lable Email error is not matching"));
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablePassword()), prop.getProperty("lableTxtPassword"), "Lable Password error is not Matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableConfPassword()), prop.getProperty("lableTxtConfPassword"), "Lable Conf Password error is not Matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableMobile()), prop.getProperty("lableTxtMobile"), "Lable Mobile error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableOrg()), prop.getProperty("lableTxtOrg"), "Lable Org error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableJobTitle()), prop.getProperty("lableTxtJobTitle"), "Lable Job Title error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablecountry()), prop.getProperty("lableTxtCountry"), "Lable Country error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getBtnNext()), prop.getProperty("lablebtnNext"), "Lable Next BTN error is not Matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableBacktoLogin()), prop.getProperty("txtlableBacktoLogin"), "Lable Already account error is not matched");
	}
	
	@Test(priority=3)
	public void addRegistrationWithoutData() {
		
		Registrationpage registrationpage = new Registrationpage(driver);
		Actions action = new Actions();
		
		action.clickOnElement(registrationpage.getBtnNext());
		
		boolean flag1 = action.isElementVisible(registrationpage.getErrMsgNameFull());
		Assert.assertTrue(flag1);
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgNameFull()),prop.getProperty("errorMsgFullName"),"full name error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgEmail()),prop.getProperty("errorMsgEmail"),"Email error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgPassword()),prop.getProperty("errorMsgPassword"),"Password error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgConfPassword()),prop.getProperty("errorMsgConfPassword"),"Conf Password error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgMobile()),prop.getProperty("errorMsgMobile"),"Mobile error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgOrg()),prop.getProperty("errorMsgOrg"),"Org name error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgJobTitle()),prop.getProperty("errorMsgJobTitle"),"Job Title error is not matched");
		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgCountry()),prop.getProperty("errorMsgCountry"),"Country error is not matched");
		
	}
	
	@Test(priority=4)
	public void addBlankSpaceRegField() throws InterruptedException {
		
		Registrationpage registrationpage = new Registrationpage(driver);
		Actions action = new Actions();
//		registrationpage.setTxtFullname().sendKeys(Keys.SPACE);
//		Thread.sleep(3000);
//		Assert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorName()), prop.getProperty("blankfullNameError"), "Blank full Name error is not matched");
	}
}
