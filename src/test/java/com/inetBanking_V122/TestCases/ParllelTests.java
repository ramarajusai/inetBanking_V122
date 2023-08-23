package com.inetBanking_V122.TestCases;

import org.testng.annotations.Test;

public class ParllelTests extends BaseClass{

	// IF YOU ARE USING PARLLEL TESTING USE @BEFOREMETHOD AND AFTERMETHOD
		@Test
		public void test1() {

			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			System.out.println(driver.getCurrentUrl());
		}

		@Test
		public void test2() {

			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			System.out.println(driver.getTitle());
		}

		@Test
		public void test3() {

			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

			System.out.println(driver.getTitle());
		}
}
