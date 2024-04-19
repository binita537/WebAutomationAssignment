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


}