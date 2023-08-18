package com.inetBanking_V122.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking_V122.PageObjects.LoginPage;
import com.inetBanking_V122.Utilities.XLUtilis;


public class TC_lOGIN_DDT extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickOnLoginButton();

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() { // user defined method created to check if alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData") // CREATING A METHOD FOR DATA DRIVEN TESTING
	String[][] getData() throws IOException {
		String path = "C:\\Users\\DELL\\eclipse-workspace\\inetBanking_V122\\src\\test\\java\\com\\inetBanking_V122\\TestData\\LoginData.xlsx";
		int rownum = XLUtilis.getRowCount(path, "Sheet1");
		int cocount = XLUtilis.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rownum][cocount]; // CONVERTING EXCEL DATA INTO TWO DIMENSIONAL STRING ARRAY
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cocount; j++) {
				loginData[i - 1][j] = XLUtilis.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return loginData;
	}
}