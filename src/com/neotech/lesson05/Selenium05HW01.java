package com.neotech.lesson05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class Selenium05HW01 extends BaseClass {
	public static void main(String[] args) throws InterruptedException {

		setUp();

		String username = ConfigsReader.getProperty("username");
		String password = ConfigsReader.getProperty("password");

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		String actual = driver.findElement(By.xpath("//span[@id='account-name']")).getText();
		String expected = "Jacqueline White";

		if (expected.equals(actual)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}

		Thread.sleep(2000);
		tearDown();
	}

}
