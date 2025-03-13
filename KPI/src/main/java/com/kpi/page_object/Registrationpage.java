package com.kpi.page_object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationpage {
	WebDriver driver;
	public Registrationpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cre_fog']/a[@class='cre_ac']")
	public WebElement createAccoutButton;
	
	@FindBy(xpath = "//h2[@class='text-white text-center py-4']")
	public WebElement lableSignup;
	
	@FindBy(xpath = "//label[@for = 'fullName']")
	public WebElement lableFullName;
	
	@FindBy(id="fullName")
	public WebElement txtFullname;
	
	@FindBy(xpath = "//input[@id='fullName']/following-sibling::div[contains(normalize-space(),'Full name is required!')]")
	public WebElement errMsgNameFull;
	
	@FindBy(xpath = "//label[@for = 'email']")
	public WebElement lableEmail;
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Email is required!')]")
	public WebElement errMsgEmail;
	
	@FindBy(xpath = "//label[@for = 'password']")
	public WebElement lablePassword;
	
	@FindBy(id="password")
	public WebElement txtPassword;
	
	@FindBy(xpath = "//div[contains(text(),'Password is required!')]")
	public WebElement errMsgPassword;
	
	@FindBy(xpath = "(//div[contains(text(),'Password should contain at least 1 number, 1 lower')])[1]")
	public WebElement lenghtMsgPassword;
	
	@FindBy(xpath = "//label[@for = 'confirmPassword']")
	public WebElement lableConfPassword;
	
	@FindBy(id="confirmPassword")
	public WebElement txtConfPassword;
	
	@FindBy(xpath = "//div[contains(text(),'Confirm password is required!')]")
	public WebElement errMsgConfPassword;
	
	@FindBy(xpath = "//div[@aria-label='Password and Confirm Password are not matching']")
	public WebElement passwordMismatchAlert;
	
	@FindBy(xpath = "//label[@for ='mobile']")
	public WebElement lableMobile;
	
	@FindBy(id="phone")
	public WebElement txtMobile;
	
	@FindBy(xpath = "//div[contains(text(),'Mobile number is required!')]")
	public WebElement errMsgMobile;
	
	@FindBy(xpath = "//div[contains(text(),'Mobile number is invalid!')]")
	public WebElement errMsgInvalidMob;
	
	@FindBy(xpath="//div[@class='selected-dial-code']")
	public WebElement btnCountryCode;
	
	@FindBy(id = "country-search-box")
	public WebElement txtSearchPlaceholder;
	
	@FindBy(xpath ="//ul[@class='iti__country-list']/li")
	public WebElement listCountryl;
	
	By listCountry = By.xpath("//ul[@class='iti__country-list']/li");
	
	public List<WebElement> getListCountry()
	{
		  return driver.findElements(listCountry);
	}
	
	public List<String> listCountryCodeActual()
	{
		List<String> list = new ArrayList<>();
		for (WebElement ele : getListCountry())
		{
			list.add(ele.getText());
		}
		return list;
	}
	
	@FindBy(xpath = "//label[@for ='companyName']")
	public WebElement lableOrg;
	
	@FindBy(id="companyName")
	public WebElement txtOrgName;
	
	@FindBy(xpath = "//div[contains(text(),'Organization name is required!')]")
	public WebElement errMsgOrg;
	
	@FindBy(xpath = "//label[@for ='job_title']")
	public WebElement lableJobTitle;
	
	@FindBy(id="job_title")
	public WebElement txtJobTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Job title is required!')]")
	public WebElement errMsgJobTitle;
		
	@FindBy(xpath = "//label[@for ='country']")
	public WebElement lablecountry;
	
	@FindBy(id="country")
	public WebElement txtCountry;
	
	@FindBy(xpath = "//div[contains(text(),'Country location is required!')]")
	public WebElement errMsgCountry;
	
	@FindBy(xpath ="//ul/li/span[text()='Canada']")
	public WebElement countrysearchclick;
	
	public WebElement getcountrysearchclick() {
		return countrysearchclick;
	}
	
	@FindBy(xpath = "//button[@class='btn btn-light btn_default mb-3 mt-5']")
	public WebElement btnNext;
	
	@FindBy(xpath ="(//p[@class='text-white'])[1]")
	public WebElement lableBacktoLogin;
	
	@FindBy(xpath = "//strong[normalize-space()='login']")
	public WebElement btnBacktoLogin;


	public WebElement getCreateAccoutButton() {
		return createAccoutButton;
	}

	public void setCreateAccoutButton(WebElement createAccoutButton) {
		this.createAccoutButton = createAccoutButton;
	}

	public WebElement getLableSignup() {
		return lableSignup;
	}

	public WebElement getLableFullName() {
		return lableFullName;
	}

	public WebElement getTxtFullname() {
		return txtFullname;
	}

	public WebElement setTxtFullname() {
		return txtFullname;
	}
	
	public WebElement getErrMsgNameFull() {
		return errMsgNameFull;
	}

	public WebElement getLableEmail() {
		return lableEmail;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getErrMsgEmail() {
		return errMsgEmail;
	}

	public WebElement getLablePassword() {
		return lablePassword;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getErrMsgPassword() {
		return errMsgPassword;
	}

	public WebElement getLenghtMsgPassword() {
		return lenghtMsgPassword;
	}

	public WebElement getLableConfPassword() {
		return lableConfPassword;
	}

	public WebElement getTxtConfPassword() {
		return txtConfPassword;
	}

	public WebElement getErrMsgConfPassword() {
		return errMsgConfPassword;
	}

	public WebElement getPasswordMismatchAlert() {
		return passwordMismatchAlert;
	}

	public WebElement getLableMobile() {
		return lableMobile;
	}

	public WebElement getTxtMobile() {
		return txtMobile;
	}

	public WebElement getErrMsgMobile() {
		return errMsgMobile;
	}
	
	public WebElement getErrMsgInvalidMob() {
		return errMsgInvalidMob;
	}

	public WebElement getBtnCountryCode() {
		return btnCountryCode;
	}

	public WebElement getTxtSearchPlaceholder() {
		return txtSearchPlaceholder;
	}

	public WebElement getListCountryop() {
		return listCountryl;
	}

	public WebElement getLableOrg() {
		return lableOrg;
	}

	public WebElement getTxtOrgName() {
		return txtOrgName;
	}

	public WebElement getErrMsgOrg() {
		return errMsgOrg;
	}

	public WebElement getLableJobTitle() {
		return lableJobTitle;
	}

	public WebElement getTxtJobTitle() {
		return txtJobTitle;
	}

	public WebElement getErrMsgJobTitle() {
		return errMsgJobTitle;
	}
	
	public WebElement getLablecountry() {
		return lablecountry;
	}

	public WebElement getTxtCountry() {
		return txtCountry;
	}

	public WebElement getErrMsgCountry() {
		return errMsgCountry;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getLableBacktoLogin() {
		return lableBacktoLogin;
	}

	public WebElement getBtnBacktoLogin() {
		return btnBacktoLogin;
	}
	
	//Signup Verification Page
	
		@FindBy(xpath="//div[@class='login_form']//h2[@class='text-white text-center pb-2']")
		public WebElement signupVerificationTxt;
		
		@FindBy(xpath="//p[@class='text-white text-center mb-5']")
		public WebElement txtVerificationLinkEmail;
		
		@FindBy(xpath="//div[@class='form-group']//label")
		public WebElement lableVerificationCode;
		
		@FindBy(xpath="//div[@class='ng-star-inserted']")
		public WebElement erMsgVerificationCodeRequired;
		
		@FindBy(id="code")
		public WebElement inputTxtVerificationCode;
		
		@FindBy(xpath = "//a[normalize-space()='Resend Code']")
		WebElement btnClickOnResend;
		
		@FindBy(xpath ="//span[@class='d-block text-white']")
		public WebElement msgTxtCheckSpan;
		
		@FindBy(xpath = "//button[normalize-space()='Verify']")
		WebElement btnClickOnVerify;
		
		@FindBy(xpath="//a[@class='text-white']")
		WebElement btnBacktoLoginVerificationPage;
		
		@FindBy(xpath ="//div[@aria-label='Verification code resent successfully']")
		WebElement alertSuccessResend;
		
		@FindBy(xpath ="//div[@class='ng-star-inserted']")
		public WebElement errMsgInvalidCode;
		
		
		@FindBy(xpath= "//div[@class='ng-tns-c13-2 toast-message ng-star-inserted']")
		public WebElement errAlertInvalidCode;
		
		
	public WebElement getsignupVerificationTxt() {
		return signupVerificationTxt;
	}
	
	public WebElement gettxtVerificationLinkEmail() {
		return txtVerificationLinkEmail;
	}	
		
	public WebElement getlableVerificationCode() {
		return lableVerificationCode;
	}
	
	public WebElement geterMsgVerificationCodeRequired() {
		return erMsgVerificationCodeRequired;
	}	
	
	public WebElement getbtnClickOnResend() {
		return btnClickOnResend;
	}	
	
	public WebElement getmsgTxtCheckSpan() {
		return msgTxtCheckSpan;
	}	
	
	public WebElement getbtnClickOnVerify() {
		return btnClickOnVerify;
	}	
	
	public WebElement getinputTxtVerificationCode() {
		return inputTxtVerificationCode;
	}	
	
	public WebElement getbtnBacktoLoginVerificationPage() {
		return btnBacktoLoginVerificationPage;
	}
	
	public WebElement getalertSuccessResend() {
		return alertSuccessResend;
	}
	
	public WebElement geterrMsgInvalidCode() {
		return errMsgInvalidCode;
	}
		
	public WebElement geterrAlertInvalidCode()	{
		return errAlertInvalidCode;
	}
		
//Select Plan
	
	@FindBy(xpath="//div[@aria-label='Email is verified successfully']")
	public WebElement alertTxtEmailVerified;
	
	@FindBy(xpath = "//h4[normalize-space()='Select Creator License']")
	WebElement msgCreatorLicense;
	
	@FindBy(xpath="//p[contains(text(),'(First 14 days free. No Credit Card required. Canc')]")
	WebElement txtFreeTrial;
	
	@FindBy(xpath ="//div[normalize-space()='Create and edit Kartas']")
	WebElement textPlandetailes1;
	
	@FindBy(xpath="//div[normalize-space()='Save Kartas, Branches, Measures, and Metrics for reuse']")
	WebElement textplandetailes2;
	
	@FindBy(xpath="//div[normalize-space()='Share Elements (Kartas, Branches, Measures, and Metrics)']")
	WebElement textplandetailes3;
	
	@FindBy(xpath ="//div[normalize-space()='Enter and edit KPI Targets and Actuals']")
	WebElement textplandetailes4;
	
	@FindBy(xpath ="//div[@class='col-sm-6 pr-0']//button[@class='btn_sty_2'][normalize-space()='Select Plan']")
	WebElement btnSelectPlanMonth;
	
	@FindBy(xpath ="//div[@class='col-sm-6 pl-0']//button[@class='btn_sty_2'][normalize-space()='Select Plan']")
	WebElement btnSelectPlanYear;
	
	@FindBy(xpath="//div[@class='basic_plan']//h1[normalize-space()='$59/month']")
	WebElement textLablePlanPriceMonthly;
	
	@FindBy(xpath="//div[@class='basic_plan']//h1[normalize-space()='$595/year']")
	WebElement textLablePlanPriceYearly;
	
	@FindBy(linkText ="Login")
	WebElement loginlink;
	
	@FindBy(xpath="//div[@class='head_logo']")
	WebElement selectPlanLogo;
	
	public WebElement getalertTxtEmailVerified() {
		return alertTxtEmailVerified;
	}
	
	public WebElement getmsgCreatorLicense() {
		return msgCreatorLicense;
	}
		
	public WebElement gettxtFreeTrial() {
		return txtFreeTrial;
	}
		
	public WebElement gettextPlandetailes1() {
		return textPlandetailes1;
	}
	
	public WebElement gettextplandetailes2() {
		return textplandetailes2;
	}
	
	public WebElement gettextplandetailes3() {
		return textplandetailes3;
	}
	
	public WebElement gettextplandetailes4() {
		return textplandetailes4;
	}
		
	public WebElement getbtnSelectPlanMonth() {
		return btnSelectPlanMonth;
	}
	
	public WebElement getbtnSelectPlanYear() {
		return btnSelectPlanYear;
	}	
	
	public WebElement gettextLablePlanPriceMonthly() {
		return textLablePlanPriceMonthly;
	}
	
	public WebElement gettextLablePlanPriceYearly() {
		return textLablePlanPriceYearly;
	}
	
	public WebElement getloginlink() {
		return loginlink;
	}
	
	public WebElement getselectPlanLogo() {
		return selectPlanLogo;
	}
	
//ThankYouPage

	@FindBy(xpath = "//h2[normalize-space()='THANK YOU!']")
	WebElement txtMsgThankYouAfterPlan;
	
	@FindBy(xpath="//p[@class='text-white text-center mb-5']")
	WebElement txtMsgActivatedPlan;
	
	@FindBy(xpath="//div[@class='logo']")
	WebElement logoThankYouPage;
	
	@FindBy(xpath="//a[normalize-space()='LOGIN']")
	WebElement btnLoginThankYouPage;
	
	public WebElement gettxtMsgThankYouAfterPlan() {
		return txtMsgThankYouAfterPlan;
	}
		
	public WebElement gettxtMsgActivatedPlan() {
		return txtMsgActivatedPlan;
	}
	
	public WebElement clkbtnLoginThankYouPage() {
		return btnLoginThankYouPage;
	}
	
	public WebElement logoThankYouPage() {
		return logoThankYouPage;
	}	
}
