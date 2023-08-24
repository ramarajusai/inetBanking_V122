package com.inetBanking_V122.Listeners;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sleep {
	WebDriver ldriver;

	public Sleep(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	public void impicitWait() {
		ldriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	public void waitForSomeSecondsHardSleep(int min) throws InterruptedException {
		Thread.sleep(min);

	}
	


}
