package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {

	
	public static String url = "https://demoqa.com/automation-practice-form";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		WebElement maleRB = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		maleRB.click();
		Thread.sleep(2000);
		
		WebElement femaleRB = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		femaleRB.click();
		Thread.sleep(2000);
		
		WebElement otherRB = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
		otherRB.click();
		Thread.sleep(2000);
		
		WebElement sportsRB = driver.findElement(By.xpath("	//label[@for='hobbies-checkbox-1']"));
		sportsRB.click();
		Thread.sleep(2000);
		
		
		//2nd WAY
		List<WebElement> elements = driver.findElements(By.xpath("//label[@class='custom-control-label']"));
		
		for(WebElement el : elements) {
			String text = el.getText();
			if(text.equals("Female")) {
				el.click();
				Thread.sleep(2000);
			}
			else if(text.equals("Reading")) {
				el.click();
				Thread.sleep(2000);
			}
		}
		
		driver.quit();
		
		
	}

}
