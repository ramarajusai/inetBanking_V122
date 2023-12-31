package com.inetBanking_V122.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking_V122.Listeners.Sleep;

public class SearchPage {

	WebDriver ldriver;
	Sleep s1;

	public SearchPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	static int priceOfFirstProductinInt;
	static String priceOfFirstProductinString;
	static String nameOfFirstProduct;
	static String priceOfSecondProduct;
	static String nameOfSecondProduct;
	static String priceOfThirdProduct;
	static String nameOfThirdProduct;
	static String productPriceWithoutDuplicates;
	static String firstProductQuantity;
	static String secondProductQuantity;
	static String thirdProductQuantity;

	@FindBy(className = "search-keyword")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//div/div/h4")
	List<WebElement> listOfProductNames;

	@FindBy(xpath = "//div/div/h4")
	List<WebElement> listOfSortedProductNames;

	@FindBy(xpath = "//div[@class=\"no-results\"]//img//following-sibling::h2")
	WebElement noProductsMessage;

	@FindBy(xpath = "//div[@class=\"product-action\"]/button")
	List<WebElement> addToCartButtons;

	@FindBy(xpath = "(//tr/td/strong)[1]")
	WebElement itemFiedNumber;

	@FindBy(xpath = "(//tr/td/strong)[2]")
	WebElement priceFieldNumber;

	@FindBy(xpath = "//div[@class=\"product\"]/p")
	List<WebElement> pricesOfProducts;

	@FindBy(xpath = "//a[@class=\"decrement\"]")
	List<WebElement> decrement;

	@FindBy(xpath = "//a[@class=\"increment\"]")
	List<WebElement> increment;

	@FindBy(xpath = "//img[@alt=\"Cart\"]")
	WebElement cartButton;

	public void listOfProductNamesLocator() {

		ldriver.findElement(By.xpath("//div/div/h4"));
	}

	public List<String> getListOfDefaultProductNames() {

		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < listOfProductNames.size(); i++) {

			String productNameWithCompleteText = listOfProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0];
			System.out.println(productName);
			al.add(productName);
		}
		return al;
	}

	public List<String> getListOfSortedProductNames() {

		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < listOfSortedProductNames.size(); i++) {

			String productNameWithCompleteText = listOfSortedProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0];
			al.add(productName);
		}
		return al;
	}

	public int getNumberOfDefaultProduct() {

		return listOfProductNames.size();
	}

	public boolean searchBoxIsDisplayed() {
		return searchBox.isDisplayed();

	}

	public boolean searchButtonIsDisplayed() {
		return searchButton.isDisplayed();

	}

	public String getSearchTextBoxPlaceholder() {
		return searchBox.getAttribute("placeholder");

	}

	public void enterDataIntoSearchTextBox(String text) {

		searchBox.sendKeys(text);

	}

	public void clearTextInSearchTextBox() {

		searchBox.clear();
	}

	public void checkifSortedProductNamesContainsInputData(String inputtext) {

		for (int i = 0; i < listOfSortedProductNames.size(); i++) {

			String productNameWithCompleteText = listOfSortedProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0];

			System.out.println("PRODUCT NAME = " + productName);
			System.out.println("INPUT TEXT = " + inputtext);
			if (productName.contains(inputtext)) {

				Assert.assertEquals(true, true);

			}

			else {
				Assert.assertEquals(true, false);

			}
		}
	}

	public String getTheTextOfNoProductsMessage() {

		return noProductsMessage.getText();
	}

	public String adduniqueProductsToThecart(String p1, String p2, String p3) throws InterruptedException {

		s1 = new Sleep(ldriver);

		for (int i = 0; i < listOfProductNames.size(); i++) {

			String productNameWithCompleteText = listOfProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0].trim();

			s1.waitForSomeSecondsHardSleep(1000);
			// System.out.println("P1="+p1);

			if (p1.contains(productName) || p2.contains(productName) || p3.contains(productName)) {

				addToCartButtons.get(i).click();

				s1.waitForSomeSecondsHardSleep(3000);

			}

		}

		return itemFiedNumber.getText();

	}

	public String addSingleProductToThecart(String p1) throws InterruptedException {

		s1 = new Sleep(ldriver);
		String text = null;
		for (int i = 0; i < listOfProductNames.size(); i++) {
			String productNameWithCompleteText = listOfProductNames.get(i).getText();
			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0].trim();
			s1.waitForSomeSecondsHardSleep(1000);
			// System.out.println("P1="+p1);
			if (p1.contains(productName)) {
				addToCartButtons.get(i).click();
				text = addToCartButtons.get(i).getText();
				s1.waitForSomeSecondsHardSleep(3000);
			}
		}
		return text;

	}

	public String getTextfteraddingCartToProduct(String p2) throws InterruptedException {
		s1 = new Sleep(ldriver);
		String text = null;
		for (int i = 0; i < listOfProductNames.size(); i++) {
			String productNameWithCompleteText = listOfProductNames.get(i).getText();
			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0].trim();
			s1.waitForSomeSecondsHardSleep(1000);
			// System.out.println("P1="+p1);
			if (p2.contains(productName)) {
				addToCartButtons.get(i).click();
				s1.waitForSomeSecondsHardSleep(4000);
				text = addToCartButtons.get(i).getText();
				System.out.println("TEXT=" + text);
			}
		}

		return text;
	}

	public int adduniqueProductsToThecartAndGetPrice(String p1, String p2, String p3) throws InterruptedException {

		s1 = new Sleep(ldriver);
		int price = 0;

		for (int i = 0; i < listOfProductNames.size(); i++) {

			String productNameWithCompleteText = listOfProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0].trim();

			s1.waitForSomeSecondsHardSleep(1000);
			// System.out.println("P1="+p1);

			if (p1.contains(productName) || p2.contains(productName) || p3.contains(productName)) {

				addToCartButtons.get(i).click();

				s1.waitForSomeSecondsHardSleep(3000);

				String sp = pricesOfProducts.get(i).getText();
				price = price + Integer.parseInt(sp);

			}

		}

		return price;

	}

	public void incrementTheQuantity(int index, int quant) {

		for (int i = 0; i < quant; i++) {

			increment.get(index).click();
		}

	}

	public void addMultipleProductsIncludingDuplicates(String p1, String p2, String p3, int quantity)
			throws InterruptedException {

		s1 = new Sleep(ldriver);

		for (int i = 0; i < listOfProductNames.size(); i++) {

			String productNameWithCompleteText = listOfProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0].trim();

			s1.waitForSomeSecondsHardSleep(1000);
			// System.out.println("P1="+p1);
			//
			if (p1.contains(productName)) {

				firstProductQuantity = "2";
				nameOfFirstProduct = productName;
				incrementTheQuantity(i, quantity);

				addToCartButtons.get(i).click();
				s1.waitForSomeSecondsHardSleep(3000);

				String sp = pricesOfProducts.get(i).getText();
				productPriceWithoutDuplicates = sp;
				priceOfFirstProductinInt = priceOfFirstProductinInt + Integer.parseInt(sp);
				if (quantity == 1) {

					priceOfFirstProductinInt = priceOfFirstProductinInt * 2;
					System.out.println(priceOfFirstProductinInt);

					priceOfFirstProductinString = Integer.toString(priceOfFirstProductinInt);

					System.out.println("Hello");

				}

			}

			else if (p2.contains(productName)) {
				secondProductQuantity = "1";
				nameOfSecondProduct = productName;
				addToCartButtons.get(i).click();
				s1.waitForSomeSecondsHardSleep(3000);

				priceOfSecondProduct = pricesOfProducts.get(i).getText();

			}

			else if (p3.contains(productName)) {
				thirdProductQuantity = "1";
				nameOfThirdProduct = productName;
				addToCartButtons.get(i).click();
				s1.waitForSomeSecondsHardSleep(3000);
				priceOfThirdProduct = pricesOfProducts.get(i).getText();

			}

		}

		System.out.println("priceOfFirstProductinString=" + priceOfFirstProductinString);
		System.out.println("nameOfFirstProduct=" + nameOfFirstProduct);
		System.out.println("priceOfSecondProduct=" + priceOfSecondProduct);
		System.out.println("nameOfSecondProduct=" + nameOfSecondProduct);
		System.out.println("priceOfThirdProduct=" + priceOfThirdProduct);
		System.out.println("nameOfThirdProduct=" + nameOfThirdProduct);
		System.out.println("productPriceWithoutDuplicates=" + productPriceWithoutDuplicates);
		System.out.println("firstProductQuantity=" + firstProductQuantity);
		System.out.println("secondProductQuantity=" + secondProductQuantity);
		System.out.println("thirdProductQuantity=" + thirdProductQuantity);

	}

}
