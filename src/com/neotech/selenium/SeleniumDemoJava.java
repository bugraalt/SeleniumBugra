package com.neotech.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDemoJava {
	
	public static String url = "http://uitestpractice.com/Students/Select";

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement multi = driver.findElement(By.id("countriesMultiple"));
		
		Select selMult = new Select(multi);
		
		boolean isMultiple = selMult.isMultiple();
		System.out.println("is this multiple ? -> " + isMultiple);
		
		if(isMultiple) {
			List<WebElement> options = selMult.getOptions();
			
			for(WebElement we : options) {
				String text = we.getText();
				selMult.selectByVisibleText(text);
				Thread.sleep(2000);
			}
		}
		selMult.deselectByIndex(1);
		Thread.sleep(1000);
		
		selMult.deselectAll();
		
		
		
		
		}

}
