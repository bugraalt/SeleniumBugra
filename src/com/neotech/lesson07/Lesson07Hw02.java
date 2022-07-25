package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class Lesson07Hw02 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the browser and open the site "https://chercher.tech/practice/frames-example-selenium-webdriver"
//	2) Verify on the page header "Not a Friendly Topic" displayed
//	3) Click on the Inner Frame Check box
//	4) Choose baby Cat from Animals dropdown
//	5) Quit the browser
		
		setUp();
		
		String expectedText = "Not a Friendly Topic";
		String actualText = driver.findElement(By.xpath("//span[text()=\"Not a Friendly Topic\"]")).getText();
		
		if(expectedText.equals(actualText)) {
			System.out.println("Page header -> " + expectedText + " is displayed!");
		}
		
		driver.switchTo().frame("frame1");
		driver.switchTo().frame("frame3");
		
		driver.findElement(By.xpath("//input[@id='a']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
		sel.selectByVisibleText("Baby Cat");
		
		Thread.sleep(3000);
		
		tearDown();

	}

}
