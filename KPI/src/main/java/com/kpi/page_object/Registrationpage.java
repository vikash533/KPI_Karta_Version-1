package com.kpi.page_object;

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
	
	@FindBy(xpath = "//div[contains(text(),'Full name is required!')]")
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
	
	@FindBy(xpath = "(//div[contains(text(),'Password should contain at least 1 number, 1 lower')])[2]")
	public WebElement lenghtMsgConfPassword;
	
	@FindBy(xpath = "//div[@class='ng-tns-c13-4 toast-message ng-star-inserted']")
	public WebElement passwordMismatchAlert;
	
	@FindBy(xpath = "//label[@for ='mobile']")
	public WebElement lableMobile;
	
	@FindBy(id="phone")
	public WebElement txtMobile;
	
	@FindBy(xpath = "//div[contains(text(),'Mobile number is required!')]")
	public WebElement errMsgMobile;
	
	@FindBy(xpath="//div[@class='selected-dial-code']")
	public WebElement btnCountryCode;
	
	@FindBy(id = "country-search-box")
	public WebElement txtSearchPlaceholder;
	
	@FindBy(xpath ="//ul[@class='iti__country-list']/li")
	public WebElement listCountry;
	
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
	
	@FindBy(xpath = "//button[@class='btn btn-light btn_default mb-3 mt-5']")
	public WebElement btnNext;
	
	@FindBy(xpath ="(//p[@class='text-white'])[1]")
	public WebElement lableBacktoLogin;
	
//	@FindBy(linkText() = "a[href='/login']")
//	public WebElement btnBacktoLogin;
	

}
