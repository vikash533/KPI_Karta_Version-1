package com.kpi.page_object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath ="//input[@id='fullName']/following-sibling::div[@class='invalid-feedback']")
	public WebElement blkErrorName;
	
	@FindBy(xpath = "//input[@id='fullName']/following-sibling::div[contains(normalize-space(),'Full name is required!')]")
	public WebElement errMsgNameFull;
	
	@FindBy(xpath = "//label[@for = 'email']")
	public WebElement lableEmail;
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Email is required!')]")
	public WebElement errMsgEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Enter a valid email address!')]")
	public WebElement errMsgInvalidEmail;
	
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
	
	@FindBy(xpath = "(//div[contains(text(),'Password should contain at least 1 number, 1 lower')])[2]")
	public WebElement lenghtMsgConfPassword;
	
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
	
	public List<String> listCountryCode()
	{
		List<String> list = new ArrayList<>();
		for (WebElement ele : getListCountry())
		{
			list.add(ele.getText());
		}
		return list;
	}
	
	@FindBy(xpath ="//div[@class='iti__flag-box']")
	public WebElement listCountryflag;
	
	@FindBy(xpath = "//span[@class='iti__country-name']")
	public WebElement listCountryName;
	
	@FindBy(xpath = "//span[@class='iti__dial-code']")
	public WebElement listCountryCode;
	
	@FindBy(xpath = "//label[@for ='companyName']")
	public WebElement lableOrg;
	
	@FindBy(id="companyName")
	public WebElement txtOrgName;
	
	@FindBy(xpath = "//div[contains(text(),'Organization name is required!')]")
	public WebElement errMsgOrg;
	
	@FindBy(xpath = "//input[@id='companyName']/following-sibling::div[@class='invalid-feedback']")
	public WebElement blkErrorOrg;
	
	@FindBy(xpath = "//label[@for ='job_title']")
	public WebElement lableJobTitle;
	
	@FindBy(id="job_title")
	public WebElement txtJobTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Job title is required!')]")
	public WebElement errMsgJobTitle;
	
	@FindBy(xpath ="//input[@id='job_title']/following-sibling::div[@class='invalid-feedback']//div")
	public WebElement blkErrorJobTitle;
	
	@FindBy(xpath = "//label[@for ='country']")
	public WebElement lablecountry;
	
	@FindBy(id="country")
	public WebElement txtCountry;
	
	@FindBy(xpath = "//div[contains(text(),'Country location is required!')]")
	public WebElement errMsgCountry;
	
	@FindBy(xpath ="//input[@id='country']/following-sibling::div[@class='invalid-feedback']")
	public WebElement blkErrorCountry;
	
	@FindBy(xpath = "//button[@class='btn btn-light btn_default mb-3 mt-5']")
	public WebElement btnNext;
	
	@FindBy(xpath ="(//p[@class='text-white'])[1]")
	public WebElement lableBacktoLogin;
	
	@FindBy(xpath = "//strong[normalize-space()='login']")
	public WebElement btnBacktoLogin;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCreateAccoutButton() {
		return createAccoutButton;
	}

	public void setCreateAccoutButton(WebElement createAccoutButton) {
		this.createAccoutButton = createAccoutButton;
	}

	public WebElement getLableSignup() {
		return lableSignup;
	}

	public void setLableSignup(WebElement lableSignup) {
		this.lableSignup = lableSignup;
	}

	public WebElement getLableFullName() {
		return lableFullName;
	}

	public void setLableFullName(WebElement lableFullName) {
		this.lableFullName = lableFullName;
	}

	public WebElement getTxtFullname() {
		return txtFullname;
	}

	public WebElement setTxtFullname() {
		return txtFullname;
	}
	
	public WebElement getblkErrorName() {
		return blkErrorName;
	}

	public WebElement getErrMsgNameFull() {
		return errMsgNameFull;
	}

	public void setErrMsgNameFull(WebElement errMsgNameFull) {
		this.errMsgNameFull = errMsgNameFull;
	}

	public WebElement getLableEmail() {
		return lableEmail;
	}

	public void setLableEmail(WebElement lableEmail) {
		this.lableEmail = lableEmail;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(WebElement txtEmail) {
		this.txtEmail = txtEmail;
	}

	public WebElement getErrMsgEmail() {
		return errMsgEmail;
	}

	public void setErrMsgEmail(WebElement errMsgEmail) {
		this.errMsgEmail = errMsgEmail;
	}
	
	public WebElement geterrMsgInvalidEmail() {
		return errMsgInvalidEmail;
	}

	public WebElement getLablePassword() {
		return lablePassword;
	}

	public void setLablePassword(WebElement lablePassword) {
		this.lablePassword = lablePassword;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	public WebElement getErrMsgPassword() {
		return errMsgPassword;
	}

	public void setErrMsgPassword(WebElement errMsgPassword) {
		this.errMsgPassword = errMsgPassword;
	}

	public WebElement getLenghtMsgPassword() {
		return lenghtMsgPassword;
	}

	public void setLenghtMsgPassword(WebElement lenghtMsgPassword) {
		this.lenghtMsgPassword = lenghtMsgPassword;
	}

	public WebElement getLableConfPassword() {
		return lableConfPassword;
	}

	public void setLableConfPassword(WebElement lableConfPassword) {
		this.lableConfPassword = lableConfPassword;
	}

	public WebElement getTxtConfPassword() {
		return txtConfPassword;
	}

	public void setTxtConfPassword(WebElement txtConfPassword) {
		this.txtConfPassword = txtConfPassword;
	}

	public WebElement getErrMsgConfPassword() {
		return errMsgConfPassword;
	}

	public void setErrMsgConfPassword(WebElement errMsgConfPassword) {
		this.errMsgConfPassword = errMsgConfPassword;
	}

	public WebElement getLenghtMsgConfPassword() {
		return lenghtMsgConfPassword;
	}

	public void setLenghtMsgConfPassword(WebElement lenghtMsgConfPassword) {
		this.lenghtMsgConfPassword = lenghtMsgConfPassword;
	}

	public WebElement getPasswordMismatchAlert() {
		return passwordMismatchAlert;
	}

	public void setPasswordMismatchAlert(WebElement passwordMismatchAlert) {
		this.passwordMismatchAlert = passwordMismatchAlert;
	}

	public WebElement getLableMobile() {
		return lableMobile;
	}

	public void setLableMobile(WebElement lableMobile) {
		this.lableMobile = lableMobile;
	}

	public WebElement getTxtMobile() {
		return txtMobile;
	}

	public void setTxtMobile(WebElement txtMobile) {
		this.txtMobile = txtMobile;
	}

	public WebElement getErrMsgMobile() {
		return errMsgMobile;
	}

	public void setErrMsgMobile(WebElement errMsgMobile) {
		this.errMsgMobile = errMsgMobile;
	}
	
	public WebElement getErrMsgInvalidMob() {
		return errMsgInvalidMob;
	}

	public WebElement getBtnCountryCode() {
		return btnCountryCode;
	}

	public void setBtnCountryCode(WebElement btnCountryCode) {
		this.btnCountryCode = btnCountryCode;
	}

	public WebElement getTxtSearchPlaceholder() {
		return txtSearchPlaceholder;
	}

	public void setTxtSearchPlaceholder(WebElement txtSearchPlaceholder) {
		this.txtSearchPlaceholder = txtSearchPlaceholder;
	}

	public WebElement getListCountryop() {
		return listCountryl;
	}
//
//	public void setListCountry(WebElement listCountry) {
//		this.listCountry = listCountry;
//	}

	public WebElement getListCountryflag() {
		return listCountryflag;
	}

	public void setListCountryflag(WebElement listCountryflag) {
		this.listCountryflag = listCountryflag;
	}

	public WebElement getListCountryName() {
		return listCountryName;
	}

	public void setListCountryName(WebElement listCountryName) {
		this.listCountryName = listCountryName;
	}

	public WebElement getListCountryCode() {
		return listCountryCode;
	}

	public void setListCountryCode(WebElement listCountryCode) {
		this.listCountryCode = listCountryCode;
	}

	public WebElement getLableOrg() {
		return lableOrg;
	}

	public void setLableOrg(WebElement lableOrg) {
		this.lableOrg = lableOrg;
	}

	public WebElement getTxtOrgName() {
		return txtOrgName;
	}

	public void setTxtOrgName(WebElement txtOrgName) {
		this.txtOrgName = txtOrgName;
	}

	public WebElement getErrMsgOrg() {
		return errMsgOrg;
	}

	public void setErrMsgOrg(WebElement errMsgOrg) {
		this.errMsgOrg = errMsgOrg;
	}

	public WebElement getblkErrorOrg() {
		return blkErrorOrg;
	}
	
	public WebElement getLableJobTitle() {
		return lableJobTitle;
	}

	public void setLableJobTitle(WebElement lableJobTitle) {
		this.lableJobTitle = lableJobTitle;
	}

	public WebElement getTxtJobTitle() {
		return txtJobTitle;
	}

	public void setTxtJobTitle(WebElement txtJobTitle) {
		this.txtJobTitle = txtJobTitle;
	}

	public WebElement getErrMsgJobTitle() {
		return errMsgJobTitle;
	}

	public void setErrMsgJobTitle(WebElement errMsgJobTitle) {
		this.errMsgJobTitle = errMsgJobTitle;
	}

	public WebElement getblkErrorJobTitle() {
		return blkErrorJobTitle;
	}
	
	public WebElement getLablecountry() {
		return lablecountry;
	}

	public void setLablecountry(WebElement lablecountry) {
		this.lablecountry = lablecountry;
	}

	public WebElement getTxtCountry() {
		return txtCountry;
	}

	public void setTxtCountry(WebElement txtCountry) {
		this.txtCountry = txtCountry;
	}

	public WebElement getErrMsgCountry() {
		return errMsgCountry;
	}

	public void setErrMsgCountry(WebElement errMsgCountry) {
		this.errMsgCountry = errMsgCountry;
	}
	
	public WebElement getblkErrorCountry() {
		return blkErrorCountry;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(WebElement btnNext) {
		this.btnNext = btnNext;
	}

	public WebElement getLableBacktoLogin() {
		return lableBacktoLogin;
	}

	public void setLableBacktoLogin(WebElement lableBacktoLogin) {
		this.lableBacktoLogin = lableBacktoLogin;
	}

	public WebElement getBtnBacktoLogin() {
		return btnBacktoLogin;
	}

	public void setBtnBacktoLogin(WebElement btnBacktoLogin) {
		this.btnBacktoLogin = btnBacktoLogin;
	}
	
	//Signup Verification Page
	
		@FindBy(xpath="//div[@class='login_form']//h2")
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
	
	public void setinputTxtVerificationCode(WebElement inputTxtVerificationCode) {
		this.inputTxtVerificationCode = inputTxtVerificationCode;
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
