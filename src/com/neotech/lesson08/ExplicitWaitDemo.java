package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.util.BaseClass;

public class ExplicitWaitDemo extends BaseClass{

	public static void main(String[] args) {
		//http://uitestpractice.com/Students/Contact
		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//We create an object of WebDriverWait and we define the driver and the amount of time to wait
		
		//Then we define the condition to wait for and which element this is applied to
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContactUs")));
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ContactUs"))));  //same thing with above
		
		boolean isDisplayed = driver.findElement(By.className("ContactUs")).isDisplayed();
		System.out.println(isDisplayed);
		
		tearDown();
		
	}

}
