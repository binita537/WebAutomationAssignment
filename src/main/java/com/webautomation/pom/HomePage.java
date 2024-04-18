package com.webautomation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webautomation.utilities.ElementActionUtilites;

@Component
@Scope("cucumber-glue")
public class HomePage extends BasePage {

	public static final String HOME_PAGE_URL = "https://www.amazon.in/";

	public HomePage(WebDriver driver,ElementActionUtilites elementActionUtilites) {
		super(driver, elementActionUtilites);
	}

	public void loadURL() {
		driver.findElement(By.xpath(HOME_PAGE_URL)).click();
	}
}
