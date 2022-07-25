package com.neotech.test;

import org.openqa.selenium.By;

import com.neotech.util.CommonMethods;

public class ExplicitWaitTest extends CommonMethods {

	public static void main(String[] args) {
		// http://uitestpractice.com/Students/Contact
		
		setUp();
		
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		//we implemented an explicit wait
		CommonMethods.waitForVisibility(driver.findElement(By.className("ContactUs")));
		
		boolean isDisplayed = driver.findElement(By.className("ContactUs")).isDisplayed();
		
		System.out.println(isDisplayed);
		
		tearDown();

	}

}
