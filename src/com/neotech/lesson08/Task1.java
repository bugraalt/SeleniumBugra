package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.util.BaseClass;

public class Task1 extends BaseClass{

	public static void main(String[] args) {
		
//		TC 1: Verify element is present
//		1. Open chrome browser
//		2. Go to ?https://the-internet.herokuapp.com/?
//		3. Click on ?Click on the ?Dynamic Loading? link
//		4. Click on ?Example 1...? and click on ?Start?
//		5. Verify element with text ?Hello World!? is displayed
//		6. Close the browser
		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		
		System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText());
		
		System.out.println(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());
		
		
		tearDown();

	}

}


