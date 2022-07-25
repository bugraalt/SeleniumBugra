package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.util.BaseClass;

public class AlertDemo  extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		//http://uitestpractice.com/Students/Switchto
		
		setUp();
		
		driver.findElement(By.id("alert")).click();
		//in case we try to do something without handling the alert, We get UnhandledAlertException
		Thread.sleep(1000);
		
		Alert simpleAlert = driver.switchTo().alert();
		String simpleText = simpleAlert.getText();
		Thread.sleep(2000);
		System.out.println("The simple alert says: " + simpleText);
		simpleAlert.accept();
		
		//handling confirmation alert
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		
		//we are trying to get text without switching to alert!! -- cannot do,you HAVE TO SWITCH TO THE ACTIVE ALERT
		Alert confirmationAlert = driver.switchTo().alert();
		String confirmationText = confirmationAlert.getText();
		System.out.println("Confirmation Alert text: " + confirmationText);
		// if we want to accept
		confirmationAlert.accept();
		//if we want to dismiss
		confirmationAlert.dismiss();
		Thread.sleep(2000);
		
		
		//HANDLING PROMPT ALERT
		driver.findElement(By.id("promp")).click();
		Thread.sleep(1000);
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Prompt alert is saying: " + promptAlert.getText() );
		promptAlert.sendKeys("Sabah");
		Thread.sleep(2000);
		//We can accept
		promptAlert.accept();
		//we can also dismiss
		promptAlert.dismiss();
		Thread.sleep(2000);
		
		tearDown();
		
		
	}

}
