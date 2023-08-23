package com.inetBanking_V122.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver ldriver;

	public SearchPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(className = "search-keyword")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//div/div/h4")
	List<WebElement> listOfProductNames;

	@FindBy(xpath = "//div/div/h4")
	List<WebElement> listOfSortedProductNames;

	public void listOfProductNamesLocator() {

		ldriver.findElement(By.xpath("//div/div/h4"));
	}

	public List<String> getListOfDefaultProductNames() {

		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < listOfProductNames.size(); i++) {

			String productNameWithCompleteText = listOfProductNames.get(i).getText();

			String[] s = productNameWithCompleteText.split(" -");
			String productName = s[0];
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
}
