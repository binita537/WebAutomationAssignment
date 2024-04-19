package com.webautomation.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webautomation.pom.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStepDefinitions extends BaseDefinition {

	static final Logger logger = LoggerFactory.getLogger(SearchProductStepDefinitions.class);

	// Step definitions for the first scenario
	@Given("I open Amazon.com")
	public void iOpenAmazon() {
		logger.info("Amazon Page is loaded successfully");
	}

	@When("I type {string} in the search field and press enter")
	public void iTypeInSearchField(String searchText) {
		logger.info("Entring text into search bar");
		searchResultsPage.enterTextSearchBar(searchText);

	}

	@When("I select the {int} item in the list")
	public void iSelectItemInList(int itemIndex) {

		String productName = searchResultsPage.getProductNameFromSearchResult(itemIndex);
		logger.info("This is the first product namet: " + productName);
		String productPrice = searchResultsPage.getProductPriceFromSearchResult(itemIndex);
		logger.info("This is the first product price: " + productPrice);
	}

}
