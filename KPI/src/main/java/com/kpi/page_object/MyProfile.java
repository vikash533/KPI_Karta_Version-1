package com.kpi.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile {
	
	WebDriver driver;
	
	public MyProfile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=' My Profile ' and @class='dropdown-item']")
	public WebElement btnMyProfile;
	
	@FindBy (xpath = "//div//div[2]//h3")
	public WebElement msgUserName;
	
	@FindBy(xpath = "//p//span")
	public WebElement msgStateCountryName;
	
	@FindBy(xpath= "//a[@class='nav-link nav-link-cus active']")
	public WebElement btnPersonalDetails;
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Upload'])[1]")
	public WebElement btnImageUpload;
	
	@FindBy(xpath  = "(//button[@type='button' and @class='close'])[2]")
	public WebElement btnUploadImgPopupClose;
	
	@FindBy(xpath = "(//h5[@id='passwordModalLabel'])[2]")
	public WebElement msgUploadImage;
	
	@FindBy(xpath = "//span[@class='upload-text-msg']")
	public WebElement msgUploadYourPicture;
	
	@FindBy(xpath = "//span[text()='Recommended Dimensions: 300 x 300 pixels.']")
	public WebElement msgRecommendedDimensions;
	
	@FindBy (xpath = "//input[@id='company_logo' and @name='company_logo']")
	public WebElement btnUploadYourProfile;
	
	@FindBy(xpath = "//h5[text()='Crop Image']")
	public WebElement msgCropImage;
	
	@FindBy(xpath= "//h5[text() = 'Upload picture']")
	public WebElement lblUploadPictureAfterUploadImage;
	
	@FindBy(xpath = "//p[contains(text(),'To crop this image')]")
	public WebElement msgTxtCrop; 
	
	@FindBy(xpath = "//p[normalize-space()='Recommended Dimensions: 300 x 300 pixels.']")
	public WebElement RecDimensionMsg;
	
	@FindBy(xpath = "//img[@class='ngx-ic-source-image']")
	public WebElement imgProfile;
	
	@FindBy(xpath="//div[@class='ngx-ic-cropper']")
	public WebElement sldImageCropper;
	
	@FindBy(xpath="//input[@type='range']")
	public WebElement btnRange;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button")
	public WebElement btnUpload;

	@FindBy(xpath = "//img[@class='profile_logo']")
	public WebElement imgProfileLogo;
	
	@FindBy(xpath = "//label[text()='Full Name']")
	public WebElement msgProfileName;
	
	@FindBy(xpath = "//input[@id='fullName']")
	public WebElement txtProfileName;
	
	@FindBy(xpath= "//div[contains(text(),'Blank space is not allowed!')]")
	public WebElement msgBlankSpaceIsnotallowed;
	
	@FindBy(xpath = "//div[contains(text(),'Full name is required!')]")
	public WebElement msgFullNameisRequired;
	
	@FindBy(xpath="//label[text()='Email']")
	public WebElement msgEmailId;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement textEmailId;
	
	@FindBy(xpath = "//label[text()='Telephone Number']")
	public WebElement msgTelephoneNumber;
	
	@FindBy(id="telephone")
	public WebElement txtTelephoneNumber;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone number is not valid!')]")
	public WebElement msgInvalidTelephoneNumber;
	
	@FindBy(xpath= "//div[@id='tabs-1']//div[4]")
	public WebElement blankSpace;
	
	@FindBy(xpath = "//div[@class='invalid-feedback d-block']//div")
	public WebElement msgTelephoneNumTotalDigit;
	
	@FindBy(xpath="//label[text()='Mobile Number']")
	public WebElement msgMobileNumber;
	
	@FindBy(id="phone")
	public WebElement textMobileNumber;
	
	@FindBy(xpath="//span[@title='Verify mobile number']")
	public WebElement btnEditandVerifyMobNo;
	
	@FindBy(xpath = "//h5[@id = 'passwordModalLabel' and text() = 'Verify Phone Number']")
	public WebElement msgVerifyMobileNumber;
	
	@FindBy(xpath = "(//button[@type='button' and @class='close']/span)[1]")
	public WebElement btnbEditandVerifyMobNoPopupClose;
	
	@FindBy(xpath="//button[@class='btn btn-outline-danger btn-sm mr-2']")
	public WebElement btnCancel;
	
	@FindBy(xpath="(//label[text()='Mobile Number'])[2]")
	public WebElement labelMobileNumberEdit;
	
	@FindBy(xpath= "//div[@class='iti__flag-container']")
	public WebElement btnCountryCode;
	
	@FindBy(id="country-search-box")
	public WebElement txtCountrySearchBox;
	
	By listCountryName = By.xpath("//ul[@class='iti__country-list']//li");
	
	@FindBy(xpath="(//input[@id='phone' and @type='tel'])[2]")
	public WebElement txtEditMobileNumber;
	
	@FindBy(xpath="//button[text()='Send Code']")
	public WebElement btnSendCode;
	
	@FindBy (xpath = "//label[text()='Verification Code']")
	public WebElement lblVerificationCode;
	
	@FindBy (xpath = "//a[normalize-space()='Resend Code']")
	public WebElement btnResendCode;
	
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	public WebElement btnVerifyEditMobile;
	
	@FindBy(xpath= "//input[@placeholder='Enter verification code']")
	public WebElement txtEnterVerificationCode;
	
	@FindBy(xpath = "//div[@class='ng-star-inserted']")
	public WebElement lblErrorVerCodeReq;
	
	@FindBy(xpath= "(//button[@class='close' and @type='button'])[1]")
	public WebElement btnVerifyMobPopupClose;
	
	@FindBy(xpath="//div//h4")
	public WebElement msgAddress;
	
	@FindBy(xpath="//label[text()='Street']")
	public WebElement msgStreet;
	
	@FindBy(id="street")
	public WebElement txtStreet;
	
	@FindBy(xpath="//label[text()='City']")
	public WebElement msgCity;
	
	@FindBy(id="city")
	public WebElement txtCity;
	
	@FindBy(xpath="//label[text()='Province/State']")
	public WebElement msgProvinceState;
	
	@FindBy(id="state")
	public WebElement txtProvinceState;
	
	@FindBy(xpath="//label[text()='Postal/Zip Code']")
	public WebElement msgPostalZipCode;
	
	@FindBy(id="postal_code")
	public WebElement txtPostalZipCode;
	
	@FindBy(xpath="//label[text()='Country']")
	public WebElement msgCountry;
	
	@FindBy(id="country")
	public WebElement txtCountry;
	
	@FindBy(xpath="(//button[text()='Update'])[1]")
	public WebElement btnUpdate;
	
//	WebElement imgProfile;
//	WebElement sldImageCropper;
//	WebElement btnRange;
//	WebElement imgProfileLogo
	
	@FindBy (id="navbarDropdown")
	WebElement lnkNav;
	
	public WebElement clickNavigation()
	{
		return lnkNav;
	}		
}
