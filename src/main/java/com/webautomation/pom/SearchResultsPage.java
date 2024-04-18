package com.webautomation.pom;

import java.time.Duration;

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
		public static final String PRODUCT_PRICE_XPATH = SEARCH_RESULTS_XPATH+"//span[@class='a-price-whole']";
	public static final String PRODUCT_ADD_TO_CARD_BUTTON_XPATH = SEARCH_RESULTS_XPATH+"//button[text()='Add to cart']";
	
	public SearchResultsPage(WebDriver driver,ElementActionUtilites elementActionUtilites) {
		super(driver, elementActionUtilites);
	}


	public void enterTextSearchBar(String searchText) {
		By SearchElement=By.xpath(SEARCH_XPATH);
		elementActionUtilites.waitUntilElementClickable(driver, SearchElement);
		driver.findElement(SearchElement).click();
		driver.findElement(SearchElement).clear();
		driver.findElement(SearchElement).sendKeys(searchText);
		driver.findElement(SearchElement).sendKeys(Keys.ENTER);
		
	}
	

	public String getProductNameFromSearchResult(int index) {
		By productNameElement=By.xpath(String.format(PRODUCT_NAME_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver,productNameElement);
		WebElement ProductNameWebElement = driver.findElement(productNameElement);
		return ProductNameWebElement.getText();

	}

	public String getProductPriceFromSearchResult(int index) {
		By productPriceElement=By.xpath(String.format(PRODUCT_PRICE_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productPriceElement);
		WebElement ProductPriceWebElement = driver.findElement(productPriceElement);
		return ProductPriceWebElement.getText();

	}

	
	
	public void clickOnAddToCardButton(int index) {
		
		 FluentWait<WebDriver> wait = new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(30)) // Adjust the timeout as needed
		            .pollingEvery(Duration.ofSeconds(2)) // Adjust the polling interval as needed
		            .ignoring(Exception.class); // Ignore exceptions such as NoSuchElementException

		driver.navigate().refresh();
		By productAddToCartElement=By.xpath(String.format(PRODUCT_ADD_TO_CARD_BUTTON_XPATH, index));
		elementActionUtilites.waitUntilElementPresent(driver, productAddToCartElement);
		WebElement searchResults = driver.findElement(By.xpath(String.format(PRODUCT_ADD_TO_CARD_BUTTON_XPATH, index)));
		searchResults.click();
	}
}
