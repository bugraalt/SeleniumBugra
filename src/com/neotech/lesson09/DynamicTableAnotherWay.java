package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class DynamicTableAnotherWay extends BaseClass{

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
		
		for(int i = 0; i<rows.size(); i++) { //looping through all elements (rows)
			
			String rowText = rows.get(i).getText();
			System.out.println(rowText);
			
			if(rowText.contains(expected)) // validating if the expected value is found in a row
			{
				int rowIndex = i+1;
				String path = "//table[@id='employeeListTable']/tbody/tr[" + rowIndex +"]/td[1]";
				System.out.println(path);
				driver.findElement(By.xpath(path)).click();
				
				break;
			}
		}
		
		Thread.sleep(1000);
		
		tearDown();
		
	}

}
