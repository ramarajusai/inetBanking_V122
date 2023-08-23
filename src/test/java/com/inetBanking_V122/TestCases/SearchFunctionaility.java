package com.inetBanking_V122.TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking_V122.Listeners.Sleep;
import com.inetBanking_V122.PageObjects.SearchPage;

public class SearchFunctionaility extends BaseClass {

	SearchPage sp;
	Sleep s;

	@Test(priority = 1)

	public void Validatethatsearchboxisdisplayedinthehomepage() {

		sp = new SearchPage(driver);
		Assert.assertEquals(sp.searchBoxIsDisplayed(), true);

	}

	@Test(priority = 2)

	public void ValidatethatsearchButttonisdisplayedinthehomepage() {
		sp = new SearchPage(driver);
		Assert.assertEquals(sp.searchButtonIsDisplayed(), true);

	}

	@Test(priority = 3)

	public void ValidatethatSearchforVegetablesAndFruitsPlaceholderisdispalyedinsearchboxfield() {
		sp = new SearchPage(driver);

		Assert.assertEquals(sp.getSearchTextBoxPlaceholder(), "Search for Vegetables and Fruits");
	}

	@Test(priority = 4)
	public void Validatethatmultipleproductsaredisplayedinthehomepage() {
		sp = new SearchPage(driver);
		Assert.assertEquals(sp.getNumberOfDefaultProduct(), 30);

	}

	@Test(priority = 5)
	public void Validatethatproductsaresortedaspertheuserinputs() throws InterruptedException {
		s = new Sleep(driver);
		sp = new SearchPage(driver);
		sp.enterDataIntoSearchTextBox("WalnutS");
		s.waitForSomeSecondsHardSleep(1000);
		logger.info("LOGGINFORMATON" + sp.getListOfDefaultProductNames().get(0));
		Assert.assertEquals(sp.getListOfDefaultProductNames().get(0), "Walnuts");

	}

	@Test(priority = 6)
	public void Validatethatproductsaresortedaspertheuserinputsthepartialproductname() throws InterruptedException {
		sp = new SearchPage(driver);
		sp.clearTextInSearchTextBox();
		s = new Sleep(driver);
		sp.enterDataIntoSearchTextBox("ot");
		s.waitForSomeSecondsHardSleep(1000);
		sp.checkifSortedProductNamesContainsInputData("ot");

	}

}
