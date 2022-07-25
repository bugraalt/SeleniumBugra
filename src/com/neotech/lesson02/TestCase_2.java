package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver  = new ChromeDriver();
		
		
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

	//	driver.findElement(By.linkText("REGISTER")).click();
	
		//Doing it in 2 steps
		WebElement element = driver.findElement(By.linkText("REGISTER"));
		element.click();
		
		driver.findElement(By.name("firstName")).sendKeys("Serhat");
		driver.findElement(By.name("lastName")).sendKeys("Ucal");
		driver.findElement(By.name("phone")).sendKeys("123-455-1234");
		driver.findElement(By.id("userName")).sendKeys("srt@neotech.com");
		Thread.sleep(2000);
		
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}
