package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class JSExecutorDemo extends CommonMethods {

	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/

		setUp();

		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));

		username.sendKeys(ConfigsReader.getProperty("username"));
		password.sendKeys(ConfigsReader.getProperty("password"));
		wait(1);

		// Create an object of JS Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// arguments[0] means the first WebElement after the javascript code
		// arguments[1] means the second WebELement after the javascript code

		js.executeScript("arguments[0].style.backgroundColor='blue';arguments[1].style.backgroundColor='yellow';",
				username, password);
		wait(2);

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));

		// Navigate to PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		// Click on Employee List
		click(driver.findElement(By.xpath("//span[text()='Employee List']")));

		wait(5);

		// Scrolling down by 1000 pixels
		js.executeScript("window.scrollBy(0,1000)");

		wait(3);

		// Scrolling up by 300 pixels
		js.executeScript("window.scrollBy(0,-300)");
		wait(3);

		js.executeScript("window.scrollBy(0,500)");

		wait(3);

		// Scrolling until we see the home WebElement
		WebElement home = driver.findElement(By.id("homeIndicator"));
		js.executeScript("arguments[0].scrollIntoView(true)", home);

		wait(3);

		tearDown();

	}

}
