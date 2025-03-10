package com.kpi.action;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	
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
	
	public void explicitWait(WebDriver driver, WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String returnErrorMessage(WebDriver driver,String domquery) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return "+domquery);
	}
	
	
	
}
