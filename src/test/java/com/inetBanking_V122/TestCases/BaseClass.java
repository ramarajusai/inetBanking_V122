package com.inetBanking_V122.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBanking_V122.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc=new ReadConfig();
	
	public String baseURL=rc.getApplicationUrl() ;
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equals("firefox")) {
			
			  System.setProperty("webdriver.gecko.driver",
			  System.getProperty("user.dir")+"//Drivers//geckodriver.exe"); driver =new
			  FirefoxDriver();
			 
			
		}
		
		else if(br.equals("IE")){
			
			System.out.println("EXECUTE IE BROWSER");
		}
		
		else {
			
			System.out.println("EXECUTE chrome BROWSER");
		}
		
driver.get(baseURL);
		driver.manage().window().maximize();
		
		 logger =Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
		
	}
}
