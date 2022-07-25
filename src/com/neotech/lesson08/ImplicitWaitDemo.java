package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;

import com.neotech.util.BaseClass;

public class ImplicitWaitDemo extends BaseClass{

	public static void main(String[] args) {
		
		//http://uitestpractice.com/Students/Contact
		setUp();
		//Defining an implicit wait of 20 seconds
		//this is valid for the lifetime of the driver.
		//if the element is not found, it waits up to the time given
		//only then it will throw an exception
		//if the element is found before that, then the execution continues
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//you can test for different amount of time
		
		driver.findElement(By.linkText("This is a Ajax link")).click();
		
		String text = driver.findElement(By.className("ContactUs")).getText();
		System.out.println(text);
		
		tearDown();
		

	}

}
