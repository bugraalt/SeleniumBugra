package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class DropDownDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
	setUp();
	
	driver.findElement(By.cssSelector("input#tUsername")).sendKeys(ConfigsReader.getProperty("username"));
	driver.findElement(By.cssSelector("input#tPassword")).sendKeys(ConfigsReader.getProperty("password"));
	
	Thread.sleep(2000);
	
	
	WebElement dd = driver.findElement(By.id("dAcademicYear_list"));
	
	Select selDD = new Select(dd); // now we can select items from the dropdown element
	
	//1ST WAY
	
	selDD.selectByIndex(0);
	Thread.sleep(1000);
	
	//2ND WAY
	selDD.selectByValue("13");
	Thread.sleep(2000);
	
	//3RD WAY
	selDD.selectByVisibleText("2015-2016");
	Thread.sleep(2000);
	
	
	
	List<WebElement> options = selDD.getOptions();
	
	System.out.println("The size of the list is -> " + options.size());
	
	for(int i =0; i<options.size(); i++) {
		selDD.selectByIndex(i);
		Thread.sleep(2000);
	}
	//System.out.println(dd.getText());
	
	driver.findElement(By.id("bLogin")).click();
	tearDown();
	
	
	
	

	
	}

}
