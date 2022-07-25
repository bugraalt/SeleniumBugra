package com.neotech.lesson10;

import java.time.Duration;

import org.openqa.selenium.By;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class Task1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
//		TC 1: Disciplinary Cases Search Validation
//		1. Open chrome browser
//		2. Go to https://hrm.neotechacademy.com/
//		3. Login into the application
//		4. Select Discipline
//		5. Select Disciplinary Cases
//		6. Click on Filter (Up-Right next to Help)
//		7. Select from June 6, 2022 to July 15, 2022
//		8. Click on Search
//		9. Validate that there are no rows in result table
//		10. Quit the browser
		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		//Navigate to Disciplinary Cases
		
		driver.findElement(By.id("menu_discipline_defaultDisciplinaryView")).click();
		driver.findElement(By.linkText("Disciplinary Cases")).click();
		
	
		//Let's switch to the frame
		driver.switchTo().frame(0);
		
		//Click on Filter
		driver.findElement(By.id("searchModal")).click();
		
		//Click to show the calendar
		driver.findElement(By.id("DisciplinaryCaseSearch_createdDateFrom")).click();
		
		// We cannot use Select
		// Select from date
		// Shows the calendar
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateFrom_root']//input[1]")).click();
		// Click on June
		driver.findElement(By.xpath("//div[@id='DisciplinaryCaseSearch_createdDateFrom_root']//ul/li/span[text()='June']")).click();
// No need to select the year because it's already 2022
		
	//	List<WebElement> dates = driver.findElements(By.xpath(null))
		//tearDown();
				
				//TO BE COMPLETED

	}

}
