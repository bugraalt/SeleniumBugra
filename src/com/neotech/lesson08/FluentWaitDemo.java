package com.neotech.lesson08;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.neotech.util.BaseClass;

public class FluentWaitDemo extends BaseClass{

	public static void main(String[] args) {
		//http://uitestpractice.com/Students/Contact
	
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		FluentWait<WebDriver> wait = new FluentWait(driver);
		
		wait.withTimeout(Duration.ofSeconds(15));
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContactUs")));
		
		System.out.println(driver.findElement(By.className("ContactUs")).isDisplayed());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='Result']/div/p[contains(text(),'Selenium')]")).isDisplayed());

		
		tearDown();
	}

}
