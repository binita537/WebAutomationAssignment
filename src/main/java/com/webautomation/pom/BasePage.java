package com.webautomation.pom;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.webautomation.utilities.ElementActionUtilites;

@Component
public abstract class BasePage {

	protected WebDriver driver;
    protected ElementActionUtilites elementActionUtilites;

	public BasePage(WebDriver driver,ElementActionUtilites elementActionUtilites) {
		this.driver = driver;
		this.elementActionUtilites=elementActionUtilites;
	}

	// Common methods that are shared across pages can be defined here
	public String getPageTitle() {
		return driver.getTitle();
	}
}
