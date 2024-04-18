package com.webautomation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webautomation.config.AppConfig;
import com.webautomation.config.SpringContextConfiguration;
import com.webautomation.pom.HomePage;
import com.webautomation.pom.SearchResultsPage;
import com.webautomation.pom.ShoppingCartPage;
import com.webautomation.utilities.ElementActionUtilites;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringContextConfiguration.class)
public class BaseDefinition {
	@Autowired
	WebDriver driver;

	@Autowired
	AppConfig appConfig;

	@Autowired
	HomePage homePage;

	@Autowired
	SearchResultsPage searchResultsPage;

	@Autowired
	ShoppingCartPage shoppingCartPage;
	
	@Autowired
	ElementActionUtilites elementActionUtilites;

}
