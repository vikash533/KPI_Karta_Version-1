package com.kpi.action;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kpi.base.BaseClass;

public class Actions extends BaseClass {
	WebDriver driver;
	   
	public void clickOnElement(WebElement element) {
		try {
			element.click();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isElementVisible(WebElement element) {
		try {
			boolean flag = element.isDisplayed();
			if(flag==true)
				return flag;
				
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String isElementvisibleTrue(WebElement element) {
		try {element.isDisplayed();}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return element.getText();
	} 
	
	public void fluentWait(WebDriver driver, WebElement element)
	{
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (Exception e)
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			e.printStackTrace();
		}
	}
	
	public void waitForTitle(WebDriver driver, String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
	
	public String returnErrorMessage(WebDriver driver,String domquery) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return "+ domquery);
	}
	
	public void switchtoChild(WebDriver driver) {
		Set<String> winIDs = driver.getWindowHandles();
		Iterator<String> winditr = winIDs.iterator();
		@SuppressWarnings("unused")
		String parentID = winditr.next();
		String childID =  winditr.next();
		driver.switchTo().window(childID);
	}
	
	public void switchtoParent(WebDriver driver) {
		Set<String> winIDs = driver.getWindowHandles();
		Iterator<String> winditr = winIDs.iterator();
		String parentID = winditr.next();
		@SuppressWarnings("unused")
		String childID =  winditr.next();
		driver.switchTo().window(parentID);
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String randomEmail() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+ num +"@yopmail.com");
		
	}

}
