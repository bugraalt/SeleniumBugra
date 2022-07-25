package com.neotech.lesson05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class Selenium05HW02 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUp();

		String username = ConfigsReader.getProperty("username");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		WebElement errMsg = driver.findElement(By.cssSelector("span#txtPassword-error"));
		System.out.println(errMsg.getText());
		
		if(errMsg.isDisplayed()) {
			System.out.println(errMsg.getText() + " is displayed. Test passed!");
		}else {
			System.out.println("Test failed!");
		}
		Thread.sleep(2000);
		tearDown();

	}

}
