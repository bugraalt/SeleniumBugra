package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllEbayLinks {
	
	public final static String url = "https://www.ebay.com/";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//driver.findElements(By.xpath("//link"));
		
		
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	//DIFFERENCE BETWEEN FINDELEMENT AND FINDELEMENTS IS IMPORTANT - INTERVIEW QUESTION
		//one of the differences is we get multiple elements by findelements. we use findelements with list
		
		
		
		int count = 0;
		
		for(WebElement link : allLinks) {
			if(!link.getText().isEmpty()) {
				System.out.println(link.getText());
				count++;
			}
		}
		
		System.out.println("The number of link that have text are: " + count);
		System.out.println("The total number of link is " + allLinks.size());

		driver.quit();
	}

}
