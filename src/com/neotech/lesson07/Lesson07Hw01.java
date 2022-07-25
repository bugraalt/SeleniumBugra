package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.util.BaseClass;

public class Lesson07Hw01 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the browser and open the site "http://demo.guru99.com/popup.php"
//	2) Click on link "Click Here". When the user clicks on the "Click Here" link, new child window opens.
//	3) On the Child Window, Enter your email ID and submit.
//	4) Then Access Credentials will be Displayed on submitted page. You will see the child window is open in new tab.
//	5) Close the Child window on which credentials are displayed.Switch to the parent window.
//	6) Quit all browsers
		
		setUp();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		Iterator<String> iter = allWindowHandles.iterator();
		
		String parentWindow = iter.next();
		String childWindow = iter.next();
		
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		
		driver.findElement(By.name("emailid")).sendKeys("deneme@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	
		System.out.println("Username is ->" + driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText());
		System.out.println("Password is -> "+ driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText());
		
		driver.close();
		
		Thread.sleep(2000);
		
		tearDown();
		
	}

}
