package com.webautomation.stepdefinitions;

import com.webautomation.pom.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStepDefinitions extends BaseDefinition {

	// Step definitions for the first scenario
	@Given("I open Amazon.com")
	public void iOpenAmazon() throws InterruptedException {
		System.out.println("Amazon Page is loaded successfully");
		Thread.sleep(2000);
	}

	@When("I type {string} in the search field and press enter")
	public void iTypeInSearchField(String searchText) throws InterruptedException {
		searchResultsPage.enterTextSearchBar(searchText);
		Thread.sleep(2000);

	}

	@When("I select the {int} item in the list")
	public void iSelectItemInList(int itemIndex) throws InterruptedException {
		String productName = searchResultsPage.getProductNameFromSearchResult(itemIndex);
		String productPrice = searchResultsPage.getProductPriceFromSearchResult(itemIndex);
		System.out.println("This is the first product in serch result: + " + productName);
		System.out.println("This is the first product in serch result: + " + productPrice);
		Thread.sleep(2000);
	}

}
