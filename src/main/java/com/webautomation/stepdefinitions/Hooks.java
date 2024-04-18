package com.webautomation.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;


import com.webautomation.webdrivers.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseDefinition {

	@Autowired
	DriverFactory driverFactory;
	
	@Before
	public void setUp() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}