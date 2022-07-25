package com.neotech.lesson02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		String actualTitle = driver.getTitle();
		
		System.out.println("expected -> " + expectedTitle);
		System.out.println("actual -> " + actualTitle);

		if(expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("Test passed!");
			
		}else {
			System.out.println("Test failed!");
		}
		
		try {
			Thread.sleep(2000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		
		
	}

}
