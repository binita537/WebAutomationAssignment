package com.webautomation.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webautomation.utilities.ElementActionUtilites;

@Component
@Scope("cucumber-glue")
public class ShoppingCartPage extends BasePage {

	public static final String SHOPPING_CARD_BUTTON_XPATH = "//a[@id='nav-cart']";
	public static final String PRODUCT_DETAIL_XPATH ="//div[@class='a-section a-spacing-mini sc-list-body sc-java-remote-feature']//div[@class='a-row sc-list-item sc-java-remote-feature'][%s]";
	public static final String PRODUCTS_NAME_XPATH =PRODUCT_DETAIL_XPATH+"//span[@class='a-truncate-full a-offscreen']";
	public static final String PRODUCT_QUNTITY_XPATH=PRODUCT_DETAIL_XPATH+"//span[@class='a-dropdown-prompt']";
	public static final String PRODUCT_PRICE_XPATH=PRODUCT_DETAIL_XPATH+"//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']";
	public static final String PRODUCT_SUBTOTAL_XPATH="//span[@id='sc-subtotal-amount-buybox']//span";
	public static final String CART_PRODUCT_COUNT_XPATH ="//span[@id='nav-cart-count']";
	
	public ShoppingCartPage(WebDriver driver, ElementActionUtilites elementActionUtilites) {
		super(driver, elementActionUtilites);
	}

	public int getProductCount() {
	    By cartProductCountElement = By.xpath(CART_PRODUCT_COUNT_XPATH);
	    elementActionUtilites.waitUntilElementClickable(driver, cartProductCountElement);
	    String countText = driver.findElement(cartProductCountElement).getText();
	    return Integer.parseInt(countText);
	}
	
	
	public void clickOnShoppingCardButton() {
		By ShoppingCartButtonElementt = By.xpath(SHOPPING_CARD_BUTTON_XPATH);
		elementActionUtilites.waitUntilElementClickable(driver, ShoppingCartButtonElementt);
		driver.findElement(ShoppingCartButtonElementt).click();
	}

	public int getProductQuntity(int index) {
		By shoppingCartButtonElement = By.xpath(String.format(PRODUCT_QUNTITY_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, shoppingCartButtonElement);
		WebElement searchResults = driver.findElement(shoppingCartButtonElement);
		return  Integer.parseInt(searchResults.getText());

	}

	public String getProductName(int index) {
		By productNameElement = By.xpath(String.format(PRODUCTS_NAME_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productNameElement);
		WebElement searchResults = driver.findElement(productNameElement);
		return searchResults.getText();

	}

	public int getProductPrice(int index) {
		By productPriceElement = By.xpath(String.format(PRODUCT_PRICE_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productPriceElement);
		WebElement searchResults = driver.findElement(productPriceElement);
		String str=searchResults.getText().replace(",", "").replace(".00", "").trim();
		return  Integer.parseInt(str);

	}

	public int getProductSubTotal() {
		By productSubTotalElement = By.xpath(PRODUCT_SUBTOTAL_XPATH);
		elementActionUtilites.waitUntilElementPresent(driver, productSubTotalElement);
		WebElement searchResults = driver.findElement(productSubTotalElement);
		String str=searchResults.getText().replace(",", "").replace(".00", "").trim();
		return  Integer.parseInt(str);


	}

}
