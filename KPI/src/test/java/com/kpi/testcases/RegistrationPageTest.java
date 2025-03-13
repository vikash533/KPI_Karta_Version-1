package com.kpi.testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kpi.action.Actions;
import com.kpi.base.BaseClass;
import com.kpi.page_object.Registrationpage;

import cssSelectors.RegistrationPageSelectors;
import utils.DataProviders;

public class RegistrationPageTest extends BaseClass {
	WebDriver driver;
	Registrationpage registrationpage;
	
	SoftAssert softAssert = new SoftAssert();
	Actions action = new Actions();
	RegistrationPageSelectors rpSelectors = new RegistrationPageSelectors();
		
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
	
	@Test(priority=4)
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
	
	@Test(priority = 5)
	public void rpPasswordValidation() {
		registrationpage = new Registrationpage(driver);
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("sortPassword"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Sort Lenght Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("noUppercasePass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "No Upper Case Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("noLowercasePass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Lower Case Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("noNumPass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "No Numbers Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("onlyNumPass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Only Numbers Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("noSpCharPass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "No Special Char Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("onlySpCharPass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), " Only Special Char Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("onlyUppercasePass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Only Upper Case Password error not matched");
		registrationpage.getTxtPassword().clear();
		registrationpage.getTxtPassword().sendKeys(prop.getProperty("onlyLowercasePass"));
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getLenghtMsgPassword()), prop.getProperty("lenghtPassword"), "Only Lower Case Password error not matched");
		softAssert.assertAll();		
	}
	
	@Test(priority=6)
	public void mobileNoRp() {
		driver.navigate().refresh();
		registrationpage = new Registrationpage(driver);
		registrationpage.getTxtMobile().sendKeys("6465465");
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgInvalidMob()), prop.getProperty("errorMsgInvalidMobile"), "Invalid Mobile error not matched");
		registrationpage.getTxtMobile().clear();
		registrationpage.getTxtMobile().sendKeys("646546576576");
		action.clickOnElement(registrationpage.getBtnNext());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getErrMsgInvalidMob()), prop.getProperty("errorMsgInvalidMobile"), "Invalid Mobile error not matched");
		registrationpage.getTxtMobile().clear();
		registrationpage.getBtnCountryCode().click();
		softAssert.assertEquals(registrationpage.getTxtSearchPlaceholder().getAttribute("placeholder"), prop.getProperty("lableCountryCodeSearchPh"), "Country code placeholder error not matched");
		System.out.println(registrationpage.listCountryCodeActual());
		System.out.println(registrationpage.listCountryCodeActual().size());
		registrationpage.getListCountry().get(11).click();
		registrationpage.getBtnCountryCode().click();
		registrationpage.getTxtSearchPlaceholder().sendKeys(prop.getProperty("countryCan"));
		registrationpage.getcountrysearchclick().click();
		softAssert.assertAll();
	}
	
	@Test(priority=7,dataProvider = "registrationTestData", dataProviderClass = DataProviders.class)
    public void testRegistrationPage(String scenario, String fullname, String email, String pass, String confirmPass, String num, String organizationName, String jobTitle, String country) {
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
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_FULLNAME_ERROR), prop.getProperty("blankfullNameError"), "Full name error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_EMAIL_ERROR), prop.getProperty("errorMsgEmail"), "Email error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_PASSWORD_ERROR), prop.getProperty("lenghtPassword"), "Password error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_CONFIRM_PASSWORD_ERROR), prop.getProperty("lenghtConfPassword"), "Confirm password error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_MOBILE_ERROR), prop.getProperty("errorMsgInvalidMobile"), "Mobile error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_ORG_NAME_ERROR), prop.getProperty("BlankMsgOrg"), "Organization name error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_JOB_TITLE_ERROR), prop.getProperty("blankMsgJobTitle"), "Job title error is not matched");
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_COUNTRY_ERROR), prop.getProperty("blankMsgCountry"), "Country error is not matched");
                break;

            case "blankFullName":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_FULL_NAME_SINGLE_ERROR), prop.getProperty("errorMsgFullName"), "Full name error is not matched");
                break;

            case "invalidEmail":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.INVALID_EMAIL_ERROR), prop.getProperty("errorMsgInvalidEmail"), "Email error is not matched");
                break;

            case "blankEmail":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_EMAIL_SINGLE_ERROR), prop.getProperty("errorMsgEmail"), "Email error is not matched");
                break;

            case "blankPassword":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_PASSWORD_SINGLE_ERROR), prop.getProperty("errorMsgPassword"), "Password error is not matched");
                break;

            case "blankConfirmPassword":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_CONFIRM_PASSWORD_SINGLE_ERROR), prop.getProperty("errorMsgConfPassword"), "Confirm password error is not matched");
                break;

            case "blankMobileNumber":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_MOBILE_NUMBER_SINGLE_ERROR), prop.getProperty("errorMsgMobile"), "Mobile error is not matched");
                break;

            case "blankOrgName":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_ORG_NAME_SINGLE_ERROR), prop.getProperty("errorMsgOrg"), "Organization name error is not matched");
                break;

            case "blankJobTitle":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_JOB_TITLE_SINGLE_ERROR), prop.getProperty("errorMsgJobTitle"), "Job title error is not matched");
                break;

            case "blankCountry":
            	softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.BLANK_COUNTRY_SINGLE_ERROR), prop.getProperty("errorMsgCountry"), "Country error is not matched");
                break;

            case "mismatchPassword":
            	action.fluentWait(driver, registrationpage.getPasswordMismatchAlert());
                softAssert.assertEquals(action.returnErrorMessage(driver, rpSelectors.MISMATCH_PASSWORD_ALERT), prop.getProperty("alertPasswordMismatch"), "Job title error is not matched");
                break;

            case "validData":
            	action.waitForTitle(driver, prop.getProperty("signupverificationtitle"));
            	softAssert.assertEquals(driver.getTitle(), prop.getProperty("signupverificationtitle"), "Validation Page Title error is not matched");
                break;
                
            default: softAssert.fail("Scenario '" + scenario + "' is not recognized or implemented.");
            break;    	 
        }
        softAssert.assertAll();
    }
	
	@Test (priority=8)
	public void verificationPageValidation() throws InterruptedException {
		registrationpage = new Registrationpage(driver);
		action.fluentWait(driver, registrationpage.getsignupVerificationTxt());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getsignupVerificationTxt()), prop.getProperty("txtMsgVerifyAccount"), "Verify Account text error not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettxtVerificationLinkEmail()), prop.getProperty("txtMsgVerificationLinkEmail"), "Verification link shared error is not maatching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getlableVerificationCode()), prop.getProperty("labletxtVerificationCode"), "Lable Text Verification code error not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getbtnClickOnResend()), prop.getProperty("lableTxtResendCode"), "Lable text Resend Code error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getmsgTxtCheckSpan()), prop.getProperty("msgTexttCheckSpan"), "Check Spam Text error is not Matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getbtnClickOnVerify()), prop.getProperty("lableTxtVerify"), "Lable Verify Text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getbtnBacktoLoginVerificationPage()), prop.getProperty("labletxtBacktoLoginVerificationPage"), "Back to Login Verification Page Lable");
		registrationpage.getbtnClickOnResend().click();
		action.fluentWait(driver, registrationpage.getalertSuccessResend());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getalertSuccessResend()), prop.getProperty("toastMsgResend"), "Verification Code Resent error is not Matching");
		action.clickOnElement(registrationpage.getbtnClickOnVerify());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.geterMsgVerificationCodeRequired()), prop.getProperty("errorMsgVerificationCodeRequired"), "Blank click code required error is not matching");
		registrationpage.getinputTxtVerificationCode().sendKeys("abcdef");
		action.fluentWait(driver, registrationpage.geterrMsgInvalidCode());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.geterrMsgInvalidCode()), prop.getProperty("errorMsgInvalidCode"), "Error message invalid code is not matching");
		registrationpage.getinputTxtVerificationCode().clear();
		registrationpage.getinputTxtVerificationCode().sendKeys("676547");
		registrationpage.getbtnClickOnVerify().click();
		action.fluentWait(driver, registrationpage.geterrAlertInvalidCode());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.geterrAlertInvalidCode()), prop.getProperty("errorAlertInvalidCode"), "Toast alert invalid code error is not matching");
		registrationpage.getinputTxtVerificationCode().clear();
		Thread.sleep(Duration.ofSeconds(20));
		registrationpage.getbtnClickOnVerify().click();
		softAssert.assertAll();	
	}
	
	@Test(priority=9)
	public void selectPlanValidation() {
		action.fluentWait(driver, registrationpage.getalertTxtEmailVerified());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getalertTxtEmailVerified()), prop.getProperty("textAlertEmailVerified"), "Alert Email Verified error is not matching");
		action.waitForTitle(driver, prop.getProperty("selectPlantitle"));
    	softAssert.assertEquals(driver.getTitle(), prop.getProperty("selectPlantitle"), "Select Plan Page Title error is not matched");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getmsgCreatorLicense()), prop.getProperty("txtSelectCreator"), "Select Creator Plan Text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettxtFreeTrial()), prop.getProperty("txtMSgFreeTrial"), "Free Trial text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextPlandetailes1()), prop.getProperty("txtplandetailes1"), "Plan Access detailes1 text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextplandetailes2()), prop.getProperty("txtplandetailes2"), "Plan Access detailes2 text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextplandetailes3()), prop.getProperty("txtplandetailes3"), "Plan Access detailes3 text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextplandetailes4()), prop.getProperty("txtplandetailes4"), "Plan Access detailes4 text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getbtnSelectPlanMonth()), prop.getProperty("btnlabletxtSelectPlan"), "Label text Select Plan error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.getbtnSelectPlanYear()), prop.getProperty("btnlabletxtSelectPlan"), "Label text Select Plan error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextLablePlanPriceMonthly()), prop.getProperty("txtMonthlyPlan"), "Monthly plan text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettextLablePlanPriceYearly()), prop.getProperty("txtYearlyPlan"), "Yealy plan text error is not matching");
		registrationpage.getselectPlanLogo().isDisplayed();
		registrationpage.getloginlink().getAttribute("Login");
		registrationpage.getbtnSelectPlanMonth().click();;
		softAssert.assertAll();	
	}
	
	@Test(priority=10)
	public void thankYouPageValidation() {
		action.waitForTitle(driver, prop.getProperty("titleThankYouPage"));
    	softAssert.assertEquals(driver.getTitle(), prop.getProperty("titleThankYouPage"), "Thank You Title error is not matched");
		action.fluentWait(driver, registrationpage.gettxtMsgThankYouAfterPlan());
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettxtMsgThankYouAfterPlan()), prop.getProperty("textMsgThankYou"), "Thank You Text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.gettxtMsgActivatedPlan()), prop.getProperty("textMsgActivatedPlan"), "Activated plan Text error is not matching");
		softAssert.assertEquals(action.isElementvisibleTrue(registrationpage.clkbtnLoginThankYouPage()), prop.getProperty("btntextThankYouPage"), "Thank You page login Text error is not matching");
		registrationpage.logoThankYouPage().isDisplayed();
		registrationpage.clkbtnLoginThankYouPage().click();
		softAssert.assertAll();
	}	
}