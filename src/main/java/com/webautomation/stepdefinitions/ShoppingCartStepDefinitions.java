package com.webautomation.stepdefinitions;

import org.testng.Assert;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStepDefinitions extends BaseDefinition {

	static final Logger logger = LoggerFactory.getLogger(ShoppingCartStepDefinitions.class);

	@When("I add the {int} item to the cart by clicking on Add to Cart")
	public void iadditeamtocart(int itemIndex) {
		int cartProductCount = shoppingCartPage.getProductCount();
		logger.info("Saving cart Product Count into ProductWorld: " + cartProductCount);

		searchResultsPage.clickProductNameLinkForAddToCart(itemIndex);
		logger.info("Iteam added to the card successfully");

	}

	@When("I open the cart from the top-left")
	public void iOpenCart() {
		shoppingCartPage.clickOnShoppingCardButton();
		logger.info("User clicked on Shopping Cart");
	}

	@Then("I verify that the price is identical to the product page")
	public void iVerifyPriceIdentical() {

		int ActaulproductPriceFromCart = shoppingCartPage.getProductPrice(1);
		logger.info("Getting actaul product price from cart: " + ActaulproductPriceFromCart);

		int ExpectedPriceFromProductWorld = (int) productWorld.get("productPrice");
		logger.info("Getting actaul product price from Product word: " + ExpectedPriceFromProductWorld);
		logger.info("Verifying the product name is identical :" + ExpectedPriceFromProductWorld + "\n"
				+ ActaulproductPriceFromCart);

		Assert.assertEquals(ExpectedPriceFromProductWorld, ActaulproductPriceFromCart);
		Assert.assertEquals(ExpectedPriceFromProductWorld, ActaulproductPriceFromCart,
				String.format("Product price mismatch: Expected '%s' but found '%s'", ExpectedPriceFromProductWorld,
						ActaulproductPriceFromCart));
	}

	@Then("I verify that the subtotal is identical to the product page")
	public void iVerifySubtotalIdentical() {
		int cartProductQuntity = shoppingCartPage.getProductCount();
		logger.info("Cart Product Count is : " + cartProductQuntity);

		int cartProductPriceOnCart = (int) productWorld.get("productPrice");
		logger.info("Product Price is: " + cartProductPriceOnCart);

		int actaulCartProductsubtotal = shoppingCartPage.getProductSubTotal();
		productWorld.put("cartProductsubtotal", actaulCartProductsubtotal);
		logger.info("Saving Product Subtotal into ProductWorld: " + actaulCartProductsubtotal);

		int expectedCartProductsubtotal = cartProductQuntity * cartProductPriceOnCart;

		logger.info("Verifying Product Subtotal on cart: " + expectedCartProductsubtotal);

		Assert.assertEquals(expectedCartProductsubtotal, actaulCartProductsubtotal);
		Assert.assertEquals(expectedCartProductsubtotal, actaulCartProductsubtotal,
				String.format("Product price mismatch: Expected '%s' but found '%s'", expectedCartProductsubtotal,
						actaulCartProductsubtotal));

	}

}
