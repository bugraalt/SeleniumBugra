package com.neotech.lesson07;

import org.openqa.selenium.By;

import com.neotech.util.BaseClass;

public class Task1 extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		//TC 1: Frame verification
		//https://demoqa.com/frames
		//verify the headers in both frames
		//quit browser
		
		setUp();
		
		Thread.sleep(1000);
		//Be careful! There may be a lot of iFrames - searching the frame by index be careful!
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame("frame1");
		String frame1Text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("The text in the first frame ->" + frame1Text);
		
		//This is crucial
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		//Locating an element inside the second frame
		String frame2Text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("The text in the second frame ->"+ frame2Text );
		
		tearDown();
		
		
		
		
		
		
		
	}
	

}
