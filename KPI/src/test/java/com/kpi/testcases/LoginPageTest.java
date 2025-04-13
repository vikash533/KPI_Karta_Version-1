package com.kpi.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.LoginPage;

public class LoginPageTest extends BaseClass {
	WebDriver driver;
	LoginPage lp;
	
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
	
	@Test(priority=1, enabled =true)
	public void lablefieldLogin() {
		lp =new LoginPage(driver);
		action.waitForTitle(driver, prop.getProperty("loginPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("loginPageTitle"), "Login Page Title error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getloginLable()), prop.getProperty("loginLabletxt"), "Login Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getlabelEmail()), prop.getProperty("emailLabeltxt"), "Email Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getlabelPassword()), prop.getProperty("passwordLabeltxt"), "Password Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getlabelRememberMe()), prop.getProperty("remembermeLabeltxt"), "Remember Me Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getlableSigninUsing()), prop.getProperty("lableSignupUsingtxt"), "Sign In Using Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getbtnSubmitLabel()), prop.getProperty("labeltxtSubmit"), "Submit button lable text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getlabelbtnCreateAccount()), prop.getProperty("lableCreateAccounttxt"), "Create Account Label text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(lp.getLabelbtnForgotPassword()), prop.getProperty("lableforgotPasswordtxt"), "Forgot Password Label text error is not matching");
		softAssert.assertAll();
	}
	
	@Test (priority=2, enabled =true)
	public void loginPagebuttonclk() {
		lp =new LoginPage(driver);
		lp.clkbuttonLogo();
		action.switchWindow(driver, "child", prop.getProperty("logoclickpagetitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("logoclickpagetitle"), "Logo Click Page Title error is not matched");

		action.switchWindow(driver, "parent", prop.getProperty("loginPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("loginPageTitle"));
		
		lp.clkbtnCreateAccount();
		action.waitForTitle(driver, prop.getProperty("signupPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("signupPageTitle"), "Create Account Page Title error is not matched");
		driver.navigate().back();
		lp.clkbtnForgotPassword();
		action.waitForTitle(driver, prop.getProperty("forgotPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("forgotPageTitle"), "Forgot Password Page Title error is not matched");
		driver.navigate().back();
		softAssert.assertAll();
	}
	
	@Test(priority=3, enabled =true)
	public void test_Login()
	{		
			lp =new LoginPage(driver);
			
			lp.setEmail(prop.getProperty("email"));
			
			lp.setPassword(prop.getProperty("password"));
			
			lp.clickLogin();
			action.waitForTitle(driver, prop.getProperty("homePageTitle"));
			softAssert.assertEquals(driver.getTitle(), prop.getProperty("homePageTitle"), "Home Page Title error is not matched");
			softAssert.assertAll();
	}
}
