package com.webautomation.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class ElementActionUtilites {

	static final Logger logger = LoggerFactory.getLogger(ElementActionUtilites.class);
	@Autowired
	WebDriverWait wait;

	public WebElement waitUntilElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not visibled within the specified timeout.", locator);
			return null;
		}

	}

	public WebElement waitUntilElementClickable(WebDriver driver, By locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not clicked within the specified timeout.", locator);
			return null;
		}
	}

	public WebElement waitUntilElementPresent(WebDriver driver, By locator) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not present within the specified timeout.", locator);
			return null;
		}
	}

	public Boolean waitUntilElementNotVisible(WebDriver driver, By locator, int timeoutInSeconds) {

		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not visibled within the specified timeout.", locator);
			return null;
		}

	}

	public Boolean waitUntilElementSelected(WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.elementToBeSelected(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not selected within the specified timeout.", locator);
			return null;
		}
	}

	public WebElement waitUntilElementEnabled(WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(10000));
			wait.pollingEvery(Duration.ofMillis(500));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (TimeoutException e) {
			logger.error("Element {} not enabled within the specified timeout.", locator);
			return null;
		}
	}

 }
