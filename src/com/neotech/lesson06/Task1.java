package com.neotech.lesson06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class Task1 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		WebElement monthDd = driver.findElement(By.id("month"));
		WebElement yearDd = driver.findElement(By.id("year"));
		WebElement dayDd = driver.findElement(By.id("day"));
		
		Select selMonth = new Select(monthDd);
		Select selDay = new Select(dayDd);
		Select selYear = new Select(yearDd);
		 
		System.out.println("Te number of options for month is " + selMonth.getOptions().size());
		System.out.println("Te number of options for day is " + selDay.getOptions().size());
		System.out.println("Te number of options for year is " + selYear.getOptions().size());

		
		//Select your birthday
		
		selMonth.selectByVisibleText("Jul");
		selDay.selectByVisibleText("5");
		selYear.selectByVisibleText("1992");
		
		Thread.sleep(2000);
		tearDown();
		
	}

}
