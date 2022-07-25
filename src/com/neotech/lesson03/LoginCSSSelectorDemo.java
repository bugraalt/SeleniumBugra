package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCSSSelectorDemo {
	
	public final static String url = "http://sis.neotechacademy.com:9000/Test/";

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get(url);
		
		//xpath -> //*[@id='tUsername']
		//css -> #tUsername
		
		//xpath -> //input[@id='tUsername']
		//css -> input#tUsername
		
		driver.findElement(By.cssSelector("input#tUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#tPassword")).sendKeys("Neotech$123");

		driver.findElement(By.cssSelector("input.buttonBig")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("a[href$='Personal.aspx']")).click();		
		//The a tag, that has a href attribute ending with Personal.aspx
		
		//driver.findElement(By.cssSelector("a[class='linkMid']")).click();
		//second way
		
		driver.findElement(By.cssSelector("a.linkMid")).click();

	}

}
