package com.neotech.lesson10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class CalendarDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//https://www.delta.com/
		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Click to show the calendar
		driver.findElement(By.xpath("//span[@id='calDepartLabelCont']/span[2]")).click();
		
		String month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
	
		
		//Loop until we see July
		
		while(!month.equals("September")) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}
		
		//Get all the cells from the calendar ( including empty cells)
		
		List<WebElement> cells = driver.findElements(By.xpath("//table/tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		
		//Iterate until we find the day that we want (25th)
		for( WebElement day: cells) {
			String dayNum = day.getText();
			
			if(dayNum.equals("25")) {
				day.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		//Use the same logic to find the return month (December)
		String returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		
		//Loop until we see December
		while(!returnMonth.equals("December")) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}
		
		//Get all tthe cellsfor the month of December
		
		List<WebElement> returnCells = driver.findElements(By.xpath("//table/tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		//Iterate until we find the day that we want (5th)
		
		for(WebElement day : returnCells) {
			String dayNum = day.getText();
			if(!dayNum.equals("5")) {
				day.click();
				break;
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@value='done']")).click();
		
		Thread.sleep(3000);
		
		tearDown();

	}

}
