package com.inetBanking_V122.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking_V122.PageObjects.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {

		driver.get(baseURL);
		logger.info("URL IS OPENED");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("ENTERED USERNAME");
		lp.setPassword(password);
		logger.info("ENTERED PASSWORD");
		lp.clickOnLoginButton();
		logger.info("CLICKED ON LOGIN BUTTON");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {

			Assert.assertTrue(true);
			logger.info("TestCase is passed");
		}

		else {

			Assert.assertTrue(false);
			logger.info("TestCase is failed");
		}

	}


}
