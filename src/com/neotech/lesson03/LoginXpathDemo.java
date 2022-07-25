package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginXpathDemo {
	
	public final static String url = "http://sis.neotechacademy.com:9000/Test/";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@id='tUsername']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//*[@id='tPassword']")).sendKeys("Neotech$123");
		
		driver.findElement(By.xpath("//input[@id='bLogin']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Students')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linkMid']")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

}
