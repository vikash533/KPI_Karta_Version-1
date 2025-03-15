package com.kpi.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.ForgotPassword;
import com.kpi.page_object.LoginPage;

public class ForgotPasswordTest extends BaseClass {
	
	WebDriver driver;
	LoginPage lp;
	ForgotPassword forgotp;
	
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
	public void forgotPasswordclk() {
		forgotp = new ForgotPassword (driver);
		LoginPage lp = new LoginPage(driver);
		lp.clkbtnForgotPassword();
		forgotp.clickonBacktoLogin();
		action.waitForTitle(driver, prop.getProperty("loginPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("loginPageTitle"), "Login Page Title error is not matched");
		lp.clkbtnForgotPassword();
		action.waitForTitle(driver, prop.getProperty("forgotPageTitle"));
		softAssert.assertEquals(driver.getTitle(), prop.getProperty("forgotPageTitle"), "Forgot Password Page Title error is not matched");
		softAssert.assertAll();
	}
	
	@Test(priority =2)
	public void labelForgotPassword() {
		forgotp = new ForgotPassword (driver);
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getmsgForgot()), prop.getProperty("txtMSgForgotPassword"), "Forgot Password text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.gettxtMsgResettingPassword()), prop.getProperty("MsgResettingPasswordtxt"), "Resetting Password text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getlabelEmail()), prop.getProperty("labelEmailtxt"), "Label Email text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getLabelclkonBacktoLogin()), prop.getProperty("backtoLoginLabel"), "Back to Login text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getLabelclickonSubmit()), prop.getProperty("submitlabeltxt"), "Label Submit text error is not matching");
		System.out.println("Forgot Password Logo: " + forgotp.getOrgLogoForgotPassword().isDisplayed());
		softAssert.assertAll();
  }
	@Test (priority=3)
	public void unregisteredValidation() {
		forgotp = new ForgotPassword (driver);
		forgotp.clickonSubmit();
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getErrorMsgclkSubmitWithoutEnterEmail()), prop.getProperty("blkSubmiterror"), "Blank Submit error is not matching");
		forgotp.setEmail(action.randomAlphaNumeric());
		forgotp.clickonSubmit();
		action.fluentWait(driver, forgotp.getMsgInvalidEmail());
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getMsgInvalidEmail()), prop.getProperty("invalidEmail"), "Invalid email error is not matching");
		forgotp.getEmailinput().clear();
		forgotp.setEmail(action.randomEmail());
		forgotp.clickonSubmit();
		action.fluentWait(driver, forgotp.getmsgToastUserNotExist());
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getmsgToastUserNotExist()), prop.getProperty("unregistredEmailerror"), "Unregistered Email error is not matching");
		softAssert.assertAll();
	}
	
	@Test (priority =4)
	public void registeredEmailValidation() {
		forgotp = new ForgotPassword (driver);
		driver.navigate().refresh();
		forgotp.setEmail(prop.getProperty("email"));
		forgotp.clickonSubmit();
		action.fluentWait(driver, forgotp.getemailResettxtMsg());
		softAssert.assertEquals(action.isElementvisibleTrue(forgotp.getemailResettxtMsg()), prop.getProperty("passwordResettxt"), "Email Reset Text error is not matching");
		softAssert.assertAll();
	}	
}
