package com.kpi.testcases;

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
	
	@DataProvider
	@Test(priority=4, dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void addBlankSpaceRegField(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		
		registrationpage = new Registrationpage(driver);
		registrationpage.setTxtFullname().sendKeys(fullname);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorName()), prop.getProperty("blankfullNameError"), "Blank full Name error is not matched");
		registrationpage.getTxtEmail().sendKeys(email);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgEmail()),prop.getProperty("errorMsgEmail"),"Email error is not matched");
		registrationpage.getTxtPassword().sendKeys(pass);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Lenght Password error not matched");
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgConfPassword()), prop.getProperty("lenghtConfPassword"), "Lenght Conf Password error not matched");
		registrationpage.getTxtMobile().sendKeys(num);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgInvalidMob()), prop.getProperty("errorMsgInvalidMobile"), "Invalid Mobile error not matched");
		registrationpage.getTxtMobile().sendKeys(organizationName);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorOrg()), prop.getProperty("blankMsgOrg"), "Blank Org error not matched");
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorJobTitle()), prop.getProperty("blankMsgJobTitle"), "Blank JobTitle error not matched");	
		registrationpage.getTxtMobile().sendKeys(country);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getblkErrorCountry()), prop.getProperty("blankMsgCountry"), "Blank Country error not matched");	
	}
	@DataProvider
	@Test(priority=5,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutFullName(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgNameFull()),prop.getProperty("errorMsgFullName"),"full name error is not matched");
	}
	@DataProvider
	@Test(priority=6,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextwithInvalidEmail(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.geterrMsgInvalidEmail()),prop.getProperty("errorMsgInvalidEmail"),"Invalid Email error is not matched");
	}
	
	@DataProvider
	@Test(priority=7,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutEmail(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgEmail()),prop.getProperty("errorMsgEmail"),"Email error is not matched");
	}	
	
	@DataProvider
	@Test(priority=8,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutPass(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgPassword()),prop.getProperty("errorMsgPassword"),"Password error is not matched");
	}
	
	@DataProvider
	@Test(priority=9,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutConfPass(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgConfPassword()),prop.getProperty("errorMsgConfPassword"),"Conf Password error is not matched");
	}
	
	@DataProvider
	@Test(priority=10,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextwithoutMobNum(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgMobile()),prop.getProperty("errorMsgMobile"),"Mobile error is not matched");
	}
	
	@DataProvider
	@Test(priority=11,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutOrgName(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgOrg()),prop.getProperty("errorMsgOrg"),"Org name error is not matched");
	}
	
	@DataProvider
	@Test(priority=12,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutJobTitle(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(country);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgJobTitle()),prop.getProperty("errorMsgJobTitle"),"Job Title error is not matched");
	}
	
	@DataProvider
	@Test(priority=13,dataProvider = "registrationData",dataProviderClass = DataProviders.class)
	public void btnNextWithoutCountry(String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
		registrationpage = new Registrationpage(driver);
		driver.navigate().refresh();
		registrationpage.setTxtFullname().sendKeys(fullname);
		registrationpage.getTxtEmail().sendKeys(email);
		registrationpage.getTxtPassword().sendKeys(pass);
		registrationpage.getTxtConfPassword().sendKeys(confirmPass);
		registrationpage.getTxtMobile().sendKeys(num);
		registrationpage.getTxtMobile().sendKeys(organizationName);
		registrationpage.getTxtMobile().sendKeys(jobTitle);
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgCountry()),prop.getProperty("errorMsgCountry"),"Country error is not matched");
	}
}
