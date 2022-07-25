package com.neotech.lesson08;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.util.BaseClass;

public class Lesson08Hw02 extends BaseClass {

	public static void main(String[] args) {
//		  Homework 2: Same as Homework1 -> Use FluentWait
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
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(15));
		fluentWait.pollingEvery(Duration.ofSeconds(1));
		fluentWait.ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='input-example']/p"))));
		
		WebElement isDisplayed = driver.findElement(By.xpath("//form[@id='input-example']/p"));
		System.out.println(isDisplayed.isDisplayed());
		System.out.println(isDisplayed.getText());
				
		WebElement x = driver.findElement(By.xpath("//form[@id='input-example']/input"));
		x.clear();
		x.sendKeys("Hello");
		
		tearDown();

	}

}
