package com.inetBanking_V122.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	@FindBy(xpath="//*[contains(text(),'Log out')]")
	WebElement btnlogout;
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}

	public void clickOnLoginButton() {

		btnLogin.click();
	}

	public void clickSubmit() {
		// TODO Auto-generated method stub
		
	}
	public void clickLogOut() {
		btnlogout.click();

	}

}
