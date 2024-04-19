package com.webautomation.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webautomation.pom.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepDefinitions extends BaseDefinition {
	
	 static final Logger logger = LoggerFactory.getLogger(ShoppingCartStepDefinitions.class);

	@When("I add the {int} item to the cart by clicking on Add to Cart")
	public void iadditeamtocart(int itemIndex) {
		
		logger.info("Iteam added to the card successfully");
		searchResultsPage.clickOnAddToCardButton(itemIndex);
	
		
	}

	@When("I open the cart from the top-left")
	public void iOpenCart()  {
		shoppingCartPage.clickOnShoppingCardButton();
		logger.info("User clicked on Shopping Cart");
	}

	@Then("I verify that the price is identical to the product page")
	public void iVerifyPriceIdentical()  {
		String productName=shoppingCartPage.getProductName(1); 
		logger.info("This is the first product namet"+productName);
	}

	@Then("I verify that the subtotal is identical to the product page")
	public void iVerifySubtotalIdentical() {
		String productQuntity=shoppingCartPage.getProductQuntity(1);
		logger.info("This is the product name"+productQuntity);
		String productPrice=shoppingCartPage.getProductPrice(1); 
		logger.info("This is the product price"+productPrice);
		String productsubtotal=shoppingCartPage.getProductSubTotal(); 
		logger.info("This is the subtotal"+productsubtotal);
		
	}

}
