package com.kpi.action;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

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

}
