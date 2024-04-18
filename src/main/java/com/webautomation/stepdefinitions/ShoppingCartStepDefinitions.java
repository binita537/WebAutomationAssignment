package com.webautomation.stepdefinitions;

import com.webautomation.pom.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepDefinitions extends BaseDefinition {

	@When("I add the {int} item to the cart by clicking on Add to Cart")
	public void i_add_the_1st_item_to_the_cart_by_clicking_on_add_to_cart(int itemIndex) throws InterruptedException {
		
		searchResultsPage.clickOnAddToCardButton(itemIndex);
		Thread.sleep(2000);
		System.out.println("Iteam added to the card successfully");
		
	}

	@When("I open the cart from the top-left")
	public void iOpenCart() throws InterruptedException {
		shoppingCartPage.clickOnShoppingCardButton();
		Thread.sleep(2000);
	}

	@Then("I verify that the price is identical to the product page")
	public void iVerifyPriceIdentical() throws InterruptedException {
		String productName=shoppingCartPage.getProductName(1); 
		System.out.println(productName);
		Thread.sleep(2000);
	}

	@Then("I verify that the subtotal is identical to the product page")
	public void iVerifySubtotalIdentical() {
		String productQuntity=shoppingCartPage.getProductQuntity(1); 
		String productPrice=shoppingCartPage.getProductPrice(1); 
		String productsubtotal=shoppingCartPage.getProductSubTotal(); 
		System.out.println(productQuntity+productPrice+productsubtotal);
	}

}
