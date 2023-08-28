package com.inetBanking_V122.PageObjects;

import java.util.List;

import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver ldriver;
	SearchPage sp;

	public CartPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//img[@alt=\"Cart\"]")
	WebElement cartButton;

	@FindBy(xpath = "//div[@class=\"cart-preview active\"]/div/div/ul/li/div[1]/p[1]")
	List<WebElement> productNames;

	@FindBy(xpath = "//div[@class=\"cart-preview active\"]/div/div/ul/li/div[1]/p[2]")
	List<WebElement> prices;

	@FindBy(xpath = "//div[@class=\"cart-preview active\"]/div/div/ul/li/div[2]/p[1]")
	List<WebElement> quantities;

	@FindBy(xpath = "//div[@class=\"cart-preview active\"]/div/div/ul/li/div[2]/p[2]")
	List<WebElement> priceOfProductIncludeDuplicates;

	@FindBy(xpath = "//div[@class=\"cart-preview active\"]/div/div/ul/li/div[2]/following-sibling::a")
	List<WebElement> removeProductFromCart;
	
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']")
	List<WebElement> proceedToCheckoutButton;
	
	
	
	public void validateAddedProductDetailsInCart() throws InterruptedException {
		
		Thread.sleep(2000);
		cartButton.click();
		for(int i=0;i<productNames.size();i++) {
			
			String name=productNames.get(i).getText();
			if(name.contains(SearchPage.nameOfFirstProduct)) {
				
				Assert.assertTrue(true);
				
				if(prices.get(i).getText().contains(SearchPage.productPriceWithoutDuplicates)) {
					Assert.assertTrue(true);
					System.out.println("FP"+"SUCCESS");
					
					
				}
				
				if(quantities.get(i).getText().contains(SearchPage.firstProductQuantity)) {
				
					Assert.assertTrue(true);
					System.out.println("FP"+"SUCCESS");
				}
				
				if(priceOfProductIncludeDuplicates.get(i).getText().contains(SearchPage.priceOfFirstProductinString)) {
					
					Assert.assertTrue(true);
					System.out.println("FP"+"SUCCESS");
					
				}
			}
			
			if(name.contains(SearchPage.nameOfSecondProduct)) {
				
				Assert.assertTrue(true);
				
				if(prices.get(i).getText().contains(SearchPage.priceOfSecondProduct)) {
				
					Assert.assertTrue(true);
					System.out.println("SP"+"SUCCESS");
					
				}
				
				if(quantities.get(i).getText().contains(SearchPage.secondProductQuantity)) {
				
					Assert.assertTrue(true);
					System.out.println("SP"+"SUCCESS");
				}
				
				if(priceOfProductIncludeDuplicates.get(i).getText().contains(SearchPage.priceOfSecondProduct)) {
					
					Assert.assertTrue(true);
					System.out.println("SP"+"SUCCESS");
					
				}
			}

		if(name.contains(SearchPage.nameOfThirdProduct)) {
				
				Assert.assertTrue(true);
				
				if(prices.get(i).getText().contains(SearchPage.priceOfThirdProduct)) {
					Assert.assertTrue(true);
					System.out.println("TP"+"SUCCESS");
					
				}
				
				if(quantities.get(i).getText().contains(SearchPage.thirdProductQuantity)) {
				
					Assert.assertTrue(true);
					System.out.println("TP"+"SUCCESS");
				}
				
				if(priceOfProductIncludeDuplicates.get(i).getText().contains(SearchPage.priceOfThirdProduct)) {
					
					Assert.assertTrue(true);
					System.out.println("TP"+"SUCCESS");
					
				}
			}
		}
		
		
	}
	
}