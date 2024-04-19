package com.webautomation.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchProductStepDefinitions extends BaseDefinition {

	static final Logger logger = LoggerFactory.getLogger(SearchProductStepDefinitions.class);

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
		productWorld.put("productName", productName);
		logger.info("Saving Product name into ProductWorld: " + productName);

		int productPrice = searchResultsPage.getProductPriceFromSearchResult(itemIndex);
		
		
		
		Integer totalPrice = (Integer) productWorld.get("productPrice");
	    
	    // If the product already exists in the map, add the new price to the existing total
	    if (totalPrice != null) {
	        totalPrice += productPrice;
	    } else {
	        totalPrice = productPrice;
	    }
	    
	    productWorld.put("totalPrice", totalPrice);
	    
	    productWorld.put("productPrice", productPrice);
		logger.info("Saving Product price into ProductWorld:" + productPrice);
		
	}

}
