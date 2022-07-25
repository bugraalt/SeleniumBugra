package com.neotech.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class deneme extends CommonMethods{
	
	public static void main(String[] args) {
		
		
		setUp();
		CommonMethods.sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		CommonMethods.sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		CommonMethods.click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		CommonMethods.click(driver.findElement(By.xpath("//span[text()='PIM']")));
		CommonMethods.click(driver.findElement(By.xpath("//span[text()='Add Employee']")));
		
		wait(5);
		
		WebElement efm = driver.findElement(By.xpath("//label[text()='Employee Full Name']"));
		boolean x = efm.isDisplayed();
		System.out.println(x);
		
		tearDown();
	}

}
