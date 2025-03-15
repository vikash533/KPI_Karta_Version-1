package com.kpi.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class='text-white text-center pb-2']")
	WebElement msgForgot;
	
	@FindBy(xpath ="//p[@class='text-white text-center mb-5']")
	WebElement txtMsgResettingPassword;
	
	@FindBy(xpath = "//a[@class='text-white']")
	WebElement btnBacktoLogin;
	
	@FindBy(xpath ="//div[@class='text-white text-center']")
	WebElement LabelclkonBacktoLogin;
	
	@FindBy (xpath = "//div[contains(text(),'Email is required!')]")
	WebElement MsgclkSubmitWithoutEnterEmail;
	
	@FindBy(xpath="//label[@for='email']")
	WebElement labelEmail;
	
	@FindBy(xpath = "//div[@role='alert']")
	WebElement MsgNonRegisteredEmail;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(xpath = "//button[@class='btn btn-light btn_default mb-3 mt-2']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[text()='Enter a valid email address!']")
	WebElement MsgInvalidEmail;
	
	@FindBy(xpath ="//img[@src='assets/img/kpi-karta-logo.png']")
	WebElement OrgLogoForgotPassword;
	
	@FindBy(xpath ="//p[@class='alert mb-2 alert-success']")
	WebElement emailResettxtMsg;
	
	public WebElement getmsgForgot() {
		return msgForgot;
	}
	
	public WebElement gettxtMsgResettingPassword() {
		return txtMsgResettingPassword;
	}
	
	public WebElement getlabelEmail() {
		return labelEmail;
	}
	
	public WebElement getOrgLogoForgotPassword() {
		return OrgLogoForgotPassword;
	}
	
	public void clickonBacktoLogin() {
		btnBacktoLogin.click();
	}
	
	public WebElement getLabelclkonBacktoLogin() {
		return LabelclkonBacktoLogin;
	}
	
	public WebElement getErrorMsgclkSubmitWithoutEnterEmail() {
	return MsgclkSubmitWithoutEnterEmail;
	}
	
	public WebElement getmsgToastUserNotExist() {
		return MsgNonRegisteredEmail;
	}
	
	public WebElement getMsgInvalidEmail() {
		return MsgInvalidEmail;
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public WebElement getEmailinput() {
		return txtEmail;
	}
	
	public void clickonSubmit() {
		btnSubmit.click();
	}
	
	public WebElement getLabelclickonSubmit() {
		return btnSubmit;
	}
	
	public WebElement getemailResettxtMsg() {
		return emailResettxtMsg;
	}

}
