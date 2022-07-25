package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class NestedFrames extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// https://demoqa.com/nestedframes/
		
		setUp();
		
		//Switch to the frame using ID
		driver.switchTo().frame("frame1");
		
		//let us locate the child frame
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		
		//let us switch to childframe
		driver.switchTo().frame(childFrame);
		
		//Now we are searching inside the child frame
		WebElement p = driver.findElement(By.xpath("//body/p[text()='Child Iframe']"));
		System.out.println("The text inside the child frame -> " + p.getText());
		
		
		Thread.sleep(3000);
		//At this point the focus is inside the child frame
		//If we try to find anything in the main page we will get an error
		
		//Will switch the focus to the main page
		driver.switchTo().defaultContent();
		
		tearDown();
		
		

	}

}
