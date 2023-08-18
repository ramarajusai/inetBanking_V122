package com.inetBanking_V122.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	// THIS CLASS WILL READ THE PROPERTIES IN CONFIG.PROP file and send to base class
	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}

		catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseURL");
		return url;

	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;

	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;

	}

	public String getChromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;

	}
	
	public String getIEpath() {
		String iepath = pro.getProperty("iepath");
		return iepath;

	}
	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;

	}
	public String getFFpath() {
		String ffpath = pro.getProperty("firefoxpath");
		return ffpath;

	

}
}