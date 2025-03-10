package com.kpi.testcases;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@Test(priority=2)
	public void registrationPageBacktoLogin() {
		action.clickOnElement(registrationpage.btnBacktoLogin);
		softAssert.assertEquals(driver.getTitle(),prop.getProperty("loginPageTitle"),"Login Page Title error is not matched");
		action.clickOnElement(registrationpage.getCreateAccoutButton());
		softAssert.assertAll();
	}
	
	@Test (priority=3)
	public void lableRegistrationPagefield() {

		registrationpage = new Registrationpage(driver);
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableSignup()),prop.getProperty("lableSignuptext"),"Lable Signup error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableFullName()),prop.getProperty("lableTxtFullName"),"Lable Full Name error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableEmail()), prop.getProperty("lableTxtEmail", "Lable Email error is not matching"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablePassword()), prop.getProperty("lableTxtPassword"), "Lable Password error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableConfPassword()), prop.getProperty("lableTxtConfPassword"), "Lable Conf Password error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableMobile()), prop.getProperty("lableTxtMobile"), "Lable Mobile error is not matched");
		softAssert.assertEquals(registrationpage.getTxtMobile().getAttribute("placeholder"), prop.getProperty("placeholderMob"), "Mobile placeholder error not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableOrg()), prop.getProperty("lableTxtOrg"), "Lable Org error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableJobTitle()), prop.getProperty("lableTxtJobTitle"), "Lable Job Title error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLablecountry()), prop.getProperty("lableTxtCountry"), "Lable Country error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getBtnNext()), prop.getProperty("lablebtnNext"), "Lable Next BTN error is not Matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLableBacktoLogin()), prop.getProperty("txtlableBacktoLogin"), "Lable Already account error is not matched");
		softAssert.assertAll();
	}
	

	@Test(priority=4,dataProvider = "registrationTestData", dataProviderClass = DataProviders.class)
    public void testRegistrationPage(String scenario, String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) throws InterruptedException{
        registrationpage = new Registrationpage(driver);
        driver.navigate().refresh();

        // Fill the form with test data
        registrationpage.setTxtFullname().sendKeys(fullname);
        registrationpage.getTxtEmail().sendKeys(email);
        registrationpage.getTxtPassword().sendKeys(pass);
        registrationpage.getTxtConfPassword().sendKeys(confirmPass);
        registrationpage.getTxtMobile().sendKeys(num);
        registrationpage.getTxtOrgName().sendKeys(organizationName);
        registrationpage.getTxtJobTitle().sendKeys(jobTitle);
        registrationpage.getTxtCountry().sendKeys(country);

        // Click the Next button
        action.clickOnElement(registrationpage.getBtnNext());

       
		// Handle assertions based on the scenario
        switch (scenario) {
            case "blankData":
            	JavascriptExecutor js = (JavascriptExecutor) driver;
//                String text1 = (String) js.executeScript("return document.querySelector(\"#fullName ~ div\").innerText");
            	String text1=action.returnErrorMessage(driver," document.querySelector(\"#fullName ~ div\").innerText");
                System.out.println("-----> text1 "+text1);
                softAssert.assertEquals(text1, prop.getProperty("errorMsgFullName"), "Full name error is not matched");
                
                String text2 = (String) js.executeScript("return document.querySelector('#email~div').innerText");
                System.out.println("-----> text2 "+text2);
                softAssert.assertEquals(text2, prop.getProperty("errorMsgEmail"), "Email error is not matched");
                
                String text3 = (String) js.executeScript("return document.querySelector('#password~div').innerText");
                System.out.println("-----> text3 "+text3);
                //document.querySelector('#password~div').innerText
                softAssert.assertEquals(text3, prop.getProperty("errorMsgPassword"), "Password error is not matched");
                String text4 = (String) js.executeScript("return document.querySelector('#confirmPassword~div').innerText");
                System.out.println("-----> text4 "+text4);
                softAssert.assertEquals(text4, prop.getProperty("errorMsgConfPassword"), "Confirm password error is not matched");
                String text5 = (String) js.executeScript("return document.querySelector(\"ngx-intl-tel-input[name='phone'] ~ div\")?.innerText;");
                System.out.println("-----> text5 "+text5);
                softAssert.assertEquals(text5, prop.getProperty("errorMsgMobile"), "Mobile error is not matched");
//                document.querySelector('#companyName~div').innerText
                String text6 = (String) js.executeScript("return document.querySelector('#companyName~div').innerText");
                System.out.println("-----> text6 "+text6);
                softAssert.assertEquals(text6, prop.getProperty("errorMsgOrg"), "Organization name error is not matched");
                String text7 = (String) js.executeScript("return document.querySelector('#job_title~div').innerText");
                System.out.println("-----> text7 "+text7);
                softAssert.assertEquals(text7, prop.getProperty("errorMsgJobTitle"), "Job title error is not matched");
//                document.querySelector('#country~div').innerText
                String text8 = (String) js.executeScript("return document.querySelector('#country~div').innerText");
                System.out.println("-----> text8 "+text8);
                softAssert.assertEquals(text8, prop.getProperty("errorMsgCountry"), "Country error is not matched");
                break;

            case "blankFullName":
            	Thread.sleep(4000);
            	JavascriptExecutor js1 = (JavascriptExecutor) driver;
                String text11 = (String) js1.executeScript("return document.querySelector(\"#fullName ~ div\").innerText");
                System.out.println("-----> text11 "+text11);
            	softAssert.assertEquals(text11, prop.getProperty("blankfullNameError"), "Full name error is not matched");
                break;

            case "invalidEmail":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.geterrMsgInvalidEmail()), prop.getProperty("errorMsgInvalidEmail"), "Invalid email error is not matched");
                break;

            case "blankEmail":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgEmail()), prop.getProperty("errorMsgEmail"), "Email error is not matched");
                break;

            case "blankPassword":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgPassword()), prop.getProperty("errorMsgPassword"), "Password error is not matched");
                break;

            case "blankConfirmPassword":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgConfPassword()), prop.getProperty("errorMsgConfPassword"), "Confirm password error is not matched");
                break;

            case "blankMobileNumber":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgMobile()), prop.getProperty("errorMsgMobile"), "Mobile error is not matched");
                break;

            case "blankOrgName":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgOrg()), prop.getProperty("errorMsgOrg"), "Organization name error is not matched");
                break;

            case "blankJobTitle":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgJobTitle()), prop.getProperty("errorMsgJobTitle"), "Job title error is not matched");
                break;

            case "blankCountry":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgCountry()), prop.getProperty("errorMsgCountry"), "Country error is not matched");
                break;

            case "mismatchPassword":
                softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getPasswordMismatchAlert()), prop.getProperty("alertPasswordMismatch"), "Password mismatch error is not matched");
                break;

            case "validData":
                softAssert.assertEquals(driver.getTitle(), prop.getProperty("signupverificationtitle"), "Signup verification title error is not matched");
                break;
        }

        softAssert.assertAll();
    }
}
