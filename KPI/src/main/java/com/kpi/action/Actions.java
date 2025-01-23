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
		finally{
			System.out.print("Click onElement method executed");
		}
	}

}
