package com.webautomation.pom;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webautomation.utilities.ElementActionUtilites;

@Component
@Scope("cucumber-glue")
public class ShoppingCartPage extends BasePage {
	
	static final Logger logger = LoggerFactory.getLogger(ShoppingCartPage.class);

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
		String productCountText = driver.findElement(cartProductCountElement).getText();

		Optional<String> optionalProductCountText = Optional.ofNullable(productCountText);
		try {
			return optionalProductCountText.map(Integer::parseInt).orElse(-1);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException occurred while parsing countText: " + optionalProductCountText, e);
			return -1;
		}
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

		String quntityText = searchResults.getText();

		Optional<String> optionalQuntityText = Optional.ofNullable(quntityText);
		try {
			return optionalQuntityText.map(Integer::parseInt).orElse(-1);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException occurred while parsing countText: " + optionalQuntityText, e);
			return -1;
		}

	}

	public String getProductName(int index) {
		By productNameElement = By.xpath(String.format(PRODUCTS_NAME_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productNameElement);
		WebElement searchResults = driver.findElement(productNameElement);
		return Optional.ofNullable(searchResults.getText()).orElse(null);

	}

	public int getProductPrice(int index) {
		By productPriceElement = By.xpath(String.format(PRODUCT_PRICE_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productPriceElement);
		WebElement searchResults = driver.findElement(productPriceElement);
		String productPriceText = searchResults.getText().replace(",", "").replace(".00", "").trim();

		Optional<String> optionalProductPriceText = Optional.ofNullable(productPriceText);
		try {
			return optionalProductPriceText.map(Integer::parseInt).orElse(-1);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException occurred while parsing countText: " + optionalProductPriceText, e);
			return -1;
		}

	}

	public int getProductSubTotal() {
		By productSubTotalElement = By.xpath(PRODUCT_SUBTOTAL_XPATH);
		elementActionUtilites.waitUntilElementPresent(driver, productSubTotalElement);
		WebElement searchResults = driver.findElement(productSubTotalElement);
		String productSubtotalText = searchResults.getText().replace(",", "").replace(".00", "").trim();

		Optional<String> optionalProductSubtotalText = Optional.ofNullable(productSubtotalText);
		try {
			return optionalProductSubtotalText.map(Integer::parseInt).orElse(-1);
		} catch (NumberFormatException e) {
			logger.error("NumberFormatException occurred while parsing countText: " + optionalProductSubtotalText, e);
			return -1;
		}

	}

}
