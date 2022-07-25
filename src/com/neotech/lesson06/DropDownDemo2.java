package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class DropDownDemo2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement dd = driver.findElement(By.id("oldSelectMenu"));
		
		Select selDD = new Select(dd);
		
		selDD.selectByIndex(1);
		Thread.sleep(2000);
		
		WebElement otherMenu = driver.findElement(By.id("withOptGroup"));  // some dropdowns don't have select option. learn how to handle them
		otherMenu.click();
		
		Thread.sleep(2000);
		
		tearDown();
		
		
		
		

	}

}
