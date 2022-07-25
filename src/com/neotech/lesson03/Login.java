package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
	
	public final static String url = "http://sis.neotechacademy.com:9000/Test/";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.id("tUsername")).sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.id("tPassword"));
		pass.sendKeys("Neotech$123");
		Thread.sleep(2000);
		
		WebElement dd = driver.findElement(By.id("dAcademicYear_list"));
		
		Select selDD = new Select(dd);
		selDD.selectByIndex(12);
		
		driver.findElement(By.id("bLogin")).click();
		
		driver.findElement(By.linkText("Students"));
		
		driver.findElement(By.className("linkMid")).clear();
		
		Thread.sleep(2000);
		driver.close();

	}

}
