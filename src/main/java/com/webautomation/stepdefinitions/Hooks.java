package com.webautomation.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import com.webautomation.webdrivers.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseDefinition {

	 static final Logger logger = LoggerFactory.getLogger(Hooks.class);
	 
	 
	@Autowired
	DriverFactory driverFactory;
	
	@Before
	public void setUp(Scenario scenario) {
		 MDC.put("scenarioName", scenario.getName());
		 logger.info("Started scenario: "+scenario.getName());
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		logger.info("Driver object initilise and lunching we application");
	}

	@After
	public void tearDown(Scenario scenario) {
		if (driver != null) {
	        driver.quit();
	        logger.info("Quiting web Driver object");
	    }
		 MDC.remove(scenario.getName());
		 logger.info("Finished scenario: "+scenario.getName());
	}

}