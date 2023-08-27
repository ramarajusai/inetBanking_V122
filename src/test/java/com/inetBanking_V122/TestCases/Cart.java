package com.inetBanking_V122.TestCases;

import org.testng.annotations.Test;

import com.inetBanking_V122.Listeners.Sleep;
import com.inetBanking_V122.PageObjects.CartPage;
import com.inetBanking_V122.PageObjects.SearchPage;

public class Cart extends BaseClass {

	
	SearchPage sp;
	Sleep s;
	CartPage c;
	
	@Test(priority=14)
	public void Validatethatwhenproductareaddedtothecartsameproductdetailsaredisplayedinthecart() throws InterruptedException {
		sp = new SearchPage(driver);
		c = new CartPage(driver);
		s = new Sleep(driver);
		s.refreshPage();
		s.waitForSomeSecondsHardSleep(2000);
		sp.addMultipleProductsIncludingDuplicates("Brocolli", "Cauliflower","Cucumber", 1);
		c.validateAddedProductDetailsInCart();
	}
	
}
