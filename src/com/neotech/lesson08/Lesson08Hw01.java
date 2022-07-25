package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.util.BaseClass;

public class Lesson08Hw01 extends BaseClass{

	public static void main(String[] args) {
//		Homework 1: Use WebDriverWait
//        Verify element is enabled
//        Open chrome browser
//        Go to "https://the-internet.herokuapp.com/"
//        Click on the "Dynamic Controls" link
//        Click on enable button
//        Enter "Hello" and verify text is entered successfully
//        Close the browser
		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='input-example']/p")));
		
		WebElement isDisplayed = driver.findElement(By.xpath("//form[@id='input-example']/p"));
		System.out.println(isDisplayed.isDisplayed());
		System.out.println(isDisplayed.getText());
		
		
		WebElement x = driver.findElement(By.xpath("//form[@id='input-example']/input"));
		x.clear();
		x.sendKeys("Hello");
		
		tearDown();

	}

}
