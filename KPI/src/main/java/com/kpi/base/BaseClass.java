package com.kpi.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;

    public WebDriver openBrowser() {
        String configFilePath = System.getProperty("user.dir") + "//src/main/resources/config.properties";
        String configurationFilePath = System.getProperty("user.dir") + "//src/main/resources/Configuration.properties";

        try (FileInputStream fis = new FileInputStream(configFilePath);
             FileInputStream fis1 = new FileInputStream(configurationFilePath)) {

            prop = new Properties();
            prop.load(fis);
            prop.load(fis1);

            String browser = prop.getProperty("Browser");
            if (browser == null) {
                throw new IllegalArgumentException("Browser property is not set in the configuration file.");
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // Initialize NgWebDriver for Angular applications
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            NgWebDriver ngDriver = new NgWebDriver(js);
//            ngDriver.waitForAngularRequestsToFinish();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading configuration file: " + e.getMessage());
            e.printStackTrace();
        }

        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}