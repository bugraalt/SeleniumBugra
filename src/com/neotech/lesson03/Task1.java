package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	
	public final static String url = "https://www.facebook.com/";

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("user");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("pass");

		driver.findElement(By.xpath("//button[contains(@id,'u_0')]")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
