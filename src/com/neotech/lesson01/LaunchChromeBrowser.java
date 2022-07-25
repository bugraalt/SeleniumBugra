package com.neotech.lesson01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		
		//Declaring a variable of type WebDriver
		//Calling the constructor of ChromeDriver
		//We are up-casting
		WebDriver driver = new ChromeDriver(); //The browser will open
		
		driver.get("https://www.google.com"); // I want to navigate to google.com
		
		String url = driver.getCurrentUrl();
		System.out.println("url -->" + url);
		
		String title = driver.getTitle();
		System.out.println("title -> " + title);
		
		Thread.sleep(5000);
		
		driver.close();
		 
		
		
		
		
	}

}
