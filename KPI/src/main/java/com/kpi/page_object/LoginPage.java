package com.kpi.page_object;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@class='btn btn-light btn_default']")
	WebElement btnLogin;
	
	@FindBy(xpath ="//h2[@class='text-white text-center pb-4']")
	WebElement loginLable;
	
	@FindBy(xpath = "//input[@id='email']/..//label")
	WebElement labelEmail;

	@FindBy(xpath ="//label[@for='password']")
	WebElement labelPassword;
	
	@FindBy(xpath ="//label[@for='remember']")
	WebElement labelRememberMe;
	
	@FindBy(id ="password_icon")
	WebElement eyebutton;
	
	@FindBy(xpath ="//div[@class='social_login']//h5")
	WebElement lableSigninUsing;
	
	@FindBy(xpath="//div[@class='logo']")
	WebElement logoLoginPage;
	
	@FindBy(xpath ="//img[@src='assets/img/kpi-karta-logo.png']")
	WebElement clkbtnLogo;
	
	@FindBy(xpath ="//a[@class='cre_ac']")
	WebElement btnCreateAccount;
	
	@FindBy(xpath ="//a[@class='for_pass']")
	WebElement btnForgotPassword;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement toastErrorMsg;
	
	@FindBy(xpath="//div[contains(text(),'Enter a valid email address!')]")
	WebElement invalidEmailerror;
	
	@FindBy(xpath ="//div[contains(text(),'Email is required!')]")
	WebElement errblankEmail;
	
	@FindBy(xpath ="//div[contains(text(),'Password is required!')]")
	WebElement errBlankPassword;
	
	public void setEmail(String email) 
	{
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() 
	{
		btnLogin.click();
	}
	
	public WebElement getloginLable() {
		return loginLable;
	}
	
	public WebElement getlabelEmail() {
		return labelEmail;
	}

	public WebElement getlabelPassword() {
		return labelPassword;
	}
	
	public WebElement getlabelRememberMe() {
		return labelRememberMe;
	}
	
	public WebElement geteyebutton() {
		return eyebutton;
	}
	
	public WebElement getlableSigninUsing() {
		return lableSigninUsing;
	}
	
	public WebElement getbtnSubmitLabel() {
		return btnLogin;
	}
	
	public WebElement getlogoLoginPage() {
		return logoLoginPage;
	}
	
	public void clkbuttonLogo() {
		clkbtnLogo.click();
		Set<String> winIDs = driver.getWindowHandles();
		List<String> windowList = new ArrayList(winIDs);
//		String parentID = windowList.get(0);
//		String childID = windowList.get(1);
		driver.switchTo().window(windowList.get(1));
//		driver.getTitle();
//		driver.switchTo().window(parentID);	
	}
	
	public WebElement getlabelbtnCreateAccount() {
		return btnCreateAccount;
	}
	
	public void clkbtnCreateAccount() {
		btnCreateAccount.click();
	}
	
	public WebElement getLabelbtnForgotPassword() {
		return btnForgotPassword;
	}
	
	public void clkbtnForgotPassword() {
		btnForgotPassword.click();
	}
	
	public WebElement gettoastErrorMsg() {
		return toastErrorMsg;
	}
	
	public WebElement getinvalidEmailerror() {
		return invalidEmailerror;
	}
	
	public WebElement geterrblankEmail() {
		return errblankEmail;
	}
	
	public WebElement geterrBlankPassword() {
		return errBlankPassword;
	}
	
	
	
	
	
}
