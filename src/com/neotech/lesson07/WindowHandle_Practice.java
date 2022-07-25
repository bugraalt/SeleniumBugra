package com.neotech.lesson07;

import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.util.BaseClass;

public class WindowHandle_Practice extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// Launch the link https://demoqa.com/browser-windows
		//Get the title of the main page
		//Click on the tabButton, windowButton and messageWindowButton
		//Switch the control of the webdriver to the opened windows
		//Print the window handle opened and close right after that
		//Quit the browser
		
		setUp();
		
		System.out.println("The title of the main page is -> " + driver.getTitle());
		String mainPageId = driver.getWindowHandle();
		System.out.println("The main page ID is -> " + mainPageId);

		Thread.sleep(1000);
		
		//Click on the tabButton
		driver.findElement(By.id("tabButton")).click(); //2nd page
		Thread.sleep(1000);
		
		//Click on the windowButton
		driver.findElement(By.id("windowButton")).click(); //3rd page
		Thread.sleep(1000);
		
		//Click on the messageWindowButton
		driver.findElement(By.id("messageWindowButton")).click(); //4th page
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("The size of all opened windows ->" + allWindowHandles.size());
		
		for(String handle : allWindowHandles) {
			if(!handle.equals(mainPageId)) {
				//Switch to the page
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				
				//Close the page
				driver.close();
			}
		}
		
		Thread.sleep(3000);
		tearDown();
		
		
	}

}
