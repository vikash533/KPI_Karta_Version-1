package com.kpi.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.Registrationpage;

import utils.DataProviders;

public class RegistrationPageTest extends BaseClass {
	WebDriver driver;
	Registrationpage registrationpage;
	
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
	
	@Test(priority=1)
	public void registrationPageLanding() {

		registrationpage = new Registrationpage(driver);
		action.clickOnElement(registrationpage.getCreateAccoutButton());
		softAssert.assertEquals(driver.getTitle(),prop.getProperty("signupPageTitle"),"Page Title error is not matched");	
		softAssert.assertAll();	
	}
	
	@Test (priority=2)
	public void lableRegistrationPagefield() {

		registrationpage = new Registrationpage(driver);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableSignup()),prop.getProperty("lableSignuptext"),"Lable Signup error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableFullName()),prop.getProperty("lableTxtFullName"),"Lable Full Name error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableEmail()), prop.getProperty("lableTxtEmail", "Lable Email error is not matching"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablePassword()), prop.getProperty("lableTxtPassword"), "Lable Password error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableConfPassword()), prop.getProperty("lableTxtConfPassword"), "Lable Conf Password error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableMobile()), prop.getProperty("lableTxtMobile"), "Lable Mobile error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableOrg()), prop.getProperty("lableTxtOrg"), "Lable Org error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableJobTitle()), prop.getProperty("lableTxtJobTitle"), "Lable Job Title error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablecountry()), prop.getProperty("lableTxtCountry"), "Lable Country error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getBtnNext()), prop.getProperty("lablebtnNext"), "Lable Next BTN error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableBacktoLogin()), prop.getProperty("txtlableBacktoLogin"), "Lable Already account error is not matched");
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void addRegistrationWithoutData() {
		
		registrationpage = new Registrationpage(driver);
		action.clickOnElement(registrationpage.getBtnNext());

		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgNameFull()),prop.getProperty("errorMsgFullName"),"full name error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgEmail()),prop.getProperty("errorMsgEmail"),"Email error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgPassword()),prop.getProperty("errorMsgPassword"),"Password error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgConfPassword()),prop.getProperty("errorMsgConfPassword"),"Conf Password error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgMobile()),prop.getProperty("errorMsgMobile"),"Mobile error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgOrg()),prop.getProperty("errorMsgOrg"),"Org name error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgJobTitle()),prop.getProperty("errorMsgJobTitle"),"Job Title error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgCountry()),prop.getProperty("errorMsgCountry"),"Country error is not matched");
		softAssert.assertAll();	
	}
	
	@Test(priority=4)
	public void addBlankSpaceRegField() {
		
		registrationpage = new Registrationpage(driver);
		registrationpage.setTxtFullname().sendKeys(Keys.SPACE);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorName()), prop.getProperty("blankfullNameError"), "Blank full Name error is not matched");
	}
	@DataProvider
	@Test(priority=5,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void SignUp(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		 registrationpage.setTxtFullname().sendKeys(fullname);
	       registrationpage.getTxtEmail().sendKeys(email);
	        registrationpage.getTxtPassword().sendKeys(pass);  // Fixed incorrect cast
	        registrationpage.getTxtConfPassword().sendKeys(confirmPass);
	        registrationpage.getTxtMobile().sendKeys(num);  // No need for CharSequence[]
	        registrationpage.getTxtOrgName().sendKeys(organizationName);
	        registrationpage.getTxtJobTitle().sendKeys(jobTitle);
	        registrationpage.getTxtCountry().sendKeys(country);
	
	}
	
}
