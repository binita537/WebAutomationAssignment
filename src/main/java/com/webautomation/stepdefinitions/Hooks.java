package com.webautomation.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.webautomation.webdrivers.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseDefinition {

	static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Autowired
	DriverFactory driverFactory;

	@Before
	public void setUp(Scenario scenario) {
		try {
			MDC.put("scenarioName", scenario.getName());
			logger.info("Started scenario: " + scenario.getName());
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			logger.info("Driver object initialized and launching web application");
		} catch (Exception e) {
			logger.error("Exception occurred during setup: " + e.getMessage());
			// You might want to handle the exception further or throw it
			throw new RuntimeException("Error during setup", e);
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed())
		{
		TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", "Screenshot after step: ");
			
		}
		try {
			if (driver != null) {
				driver.quit();
				logger.info("Quitting web Driver object");
			}
			MDC.remove(scenario.getName());
			logger.info("Finished scenario: " + scenario.getName());
		} catch (Exception e) {
			logger.error("Exception occurred during teardown: " + e.getMessage());
			// You might want to handle the exception further or throw it
			throw new RuntimeException("Error during teardown", e);
		}
	}
	
	
	
	@AfterStep
	public void takeScreenshotAfterStep(Scenario scenario) {
		if(scenario.isFailed())
		{
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "Screenshot after step: ");
		} catch (Exception e) {
			System.out.println("Exception occurred while taking screenshot: " + e.getMessage());
		}
		}

	}
	 
	
	
	
}