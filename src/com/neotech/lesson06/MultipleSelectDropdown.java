package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class MultipleSelectDropdown extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		setUp();
		
		WebElement multiSelect = driver.findElement(By.id("countriesMultiple"));
		
		Select sel = new Select(multiSelect);
		
		boolean isMult = sel.isMultiple();
		System.out.println("is it multiple ?" + isMult);
	
		List<WebElement> options = sel.getOptions();
		
		for(WebElement option : options) {
			String text = option.getText();
			sel.selectByVisibleText(text);
			Thread.sleep(1000);
		}
		
		sel.deselectByIndex(1);
		Thread.sleep(2000);
		
		sel.deselectAll();
		Thread.sleep(2000);
		
		sel.selectByIndex(2);		
		Thread.sleep(2000);
		//tearDown();
		
		

	}

}
