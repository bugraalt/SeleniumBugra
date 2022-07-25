package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class DynamicTable extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		//use implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//navigate to employee list
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.linkText("Employee List")).click();
		
		Thread.sleep(2000);
		
		
		//we can get all rows and look for our aim
		String expected = "Linda";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
		
		for(int i = 0; i<rows.size(); i++) {
			String rowText = rows.get(i).getText(); // get the text of each row
			System.out.println(rowText);
			if(rowText.contains(expected)) // validating the expected value
			{
				//1st way
				//if we are within this if condition, it means we have found out row
				//now we need to find a clickable element on this row
				//so we get a list of all 2nd column elements
				//among the list we click on the current index
				//driver.findElements(By.xpath("//table[@id='employeeListTable']//td[2]")).get(i).click();
				
				
				//2nd way
				List<WebElement> firstColumns = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[1]"));
				firstColumns.get(i).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		tearDown();

	}

}
