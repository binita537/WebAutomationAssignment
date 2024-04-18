package com.webautomation.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class DriverFactory {

	public WebDriver createDriver(String browserType) {
		WebDriver driver = null;
		switch (browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser type: " + browserType);
		}
		return driver;
	}

	
}
