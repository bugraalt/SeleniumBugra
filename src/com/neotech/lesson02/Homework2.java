package com.neotech.lesson02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		
		//open firefox browser
		
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.redfin.com/";
		
		//Navigate to https://www.redfin.com/
		
		driver.get(url);
		
		//Gives us the url of the page that we are currently on
		String actualURL = driver.getCurrentUrl();
		
		if(actualURL.equals(url)) {
			System.out.println("Url is as expected ->" + actualURL);
		}
		else
		{
			System.out.println(actualURL + " <- is NOT as expected -> " + actualURL);
		}
		
		Thread.sleep(500);
		driver.quit();

	}

}
