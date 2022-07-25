package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class FrameDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		// http://uitestpractice.com/Students/Switchto
		
		setUp();
		
		//There are 3 ways to switch to the frame
		
		//1st way, Switch to the frame by index
		
		driver.switchTo().frame(0); //passing the index of the frame
		
		WebElement nameText = driver.findElement(By.id("name"));
		nameText.sendKeys("Murat");
		Thread.sleep(1000);
		
		//If I am switched inside the frame, I cannot find anything outside the frame
		//driver.findElement(By.id("alert"));
		
		//This will switch the focus to the main page
		driver.switchTo().defaultContent();
		
		//2nd way, Switch to the frame by name or ID
		driver.switchTo().frame("iframe_a"); // Passing the name of the frame
		nameText.clear();
		nameText.sendKeys("Emre");
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		//3rd way, Switch to the frame by WebElement
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		
		//Switch the focus inside the frame
		
		driver.switchTo().frame(frameElement);
		nameText.clear();
		nameText.sendKeys("Yusuf");
		
		//Switch the focus outside the frame
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		tearDown();
		

	}

}
