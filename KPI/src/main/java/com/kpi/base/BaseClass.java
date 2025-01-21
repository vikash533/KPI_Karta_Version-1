package com.kpi.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	public WebDriver driver;

	public WebDriver openBrowser() {

		String fileLocation = System.getProperty("user.dir") + "//src/main/java/config.properties";
		try {
			FileInputStream fis = new FileInputStream(fileLocation);
			Properties prop = new Properties();
			prop.load(fis);
			String Browser = prop.getProperty("Browser");
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("firfox")) {
				driver = new FirefoxDriver();
			} else if (Browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (Browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;

	}

}
