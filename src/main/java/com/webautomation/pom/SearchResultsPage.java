package com.webautomation.pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webautomation.utilities.ElementActionUtilites;

@Component
@Scope("cucumber-glue")
public class SearchResultsPage extends BasePage {

	public static final String SEARCH_XPATH = "//input[@id='twotabsearchtextbox']";
	public static final String SEARCH_RESULTS_XPATH = "//div[@data-component-type= 's-search-result'][%s]";
	public static final String PRODUCT_NAME_XPATH = SEARCH_RESULTS_XPATH+"//span[@class='a-size-medium a-color-base a-text-normal']";
	public static final String PRODUCT_NAME_LINK_XPATH = PRODUCT_NAME_XPATH+"/..";
		public static final String PRODUCT_PRICE_XPATH = SEARCH_RESULTS_XPATH+"//span[@class='a-price-whole']";
	public static final String PRODUCT_ADD_TO_CARD_BUTTON_XPATH ="//span[@id='submit.add-to-cart']";
	public static final String CLOSE_ADD_TO_CART_POP_UP_XPATH ="//a[@id='attach-close_sideSheet-link']";
	
	public SearchResultsPage(WebDriver driver,ElementActionUtilites elementActionUtilites) {
		super(driver, elementActionUtilites);
	}
	
	
	public void clickProductNameLinkForAddToCart(int index) {
		By productNameLinkXpath = By.xpath(String.format(PRODUCT_NAME_LINK_XPATH, index));
		elementActionUtilites.waitUntilElementClickable(driver, productNameLinkXpath);
		driver.findElement(productNameLinkXpath).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String originalWindowHandle = driver.getWindowHandle();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(originalWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		elementActionUtilites.waitUntilElementClickable(driver, By.xpath(PRODUCT_ADD_TO_CARD_BUTTON_XPATH));
		WebElement addToCartButton = driver.findElement(By.xpath(PRODUCT_ADD_TO_CARD_BUTTON_XPATH));
		addToCartButton.click();

		elementActionUtilites.waitUntilElementClickable(driver, By.xpath(CLOSE_ADD_TO_CART_POP_UP_XPATH));
		driver.findElement(By.xpath(CLOSE_ADD_TO_CART_POP_UP_XPATH)).click();
		driver.close();
		driver.switchTo().window(originalWindowHandle);
		driver.navigate().refresh();

	}

	public void enterTextSearchBar(String searchText) {
		By searchElement = By.xpath(SEARCH_XPATH);
		elementActionUtilites.waitUntilElementClickable(driver, searchElement);
		WebElement searchBar = driver.findElement(searchElement);
		searchBar.click();
		searchBar.clear();
		searchBar.sendKeys(searchText);
		searchBar.sendKeys(Keys.ENTER);

	}

	public String getProductNameFromSearchResult(int index) {
		By productNameElement = By.xpath(String.format(PRODUCT_NAME_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productNameElement);
		WebElement ProductNameWebElement = driver.findElement(productNameElement);
		return ProductNameWebElement.getText();

	}

	public int getProductPriceFromSearchResult(int index) {
		By productPriceElement = By.xpath(String.format(PRODUCT_PRICE_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productPriceElement);
		WebElement ProductPriceWebElement = driver.findElement(productPriceElement);
		String str= ProductPriceWebElement.getText().replace(",", "");
		return  Integer.parseInt(str);

	}

	
}
