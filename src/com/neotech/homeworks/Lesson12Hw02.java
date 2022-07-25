package com.neotech.homeworks;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class Lesson12Hw02 extends CommonMethods{

	public static void main(String[] args) {
		
		setUp();	
		CommonMethods.sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		CommonMethods.sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		CommonMethods.click(driver.findElement(By.xpath("//button[@type='submit']")));

		click(driver.findElement(By.xpath("//span[text()='PIM']")));
		click(driver.findElement(By.xpath("//span[text()='Employee List']")));
		click(driver.findElement(By.xpath("//a[@id='addEmployeeButton']")));
		
		wait(3);
		
		driver.findElement(By.xpath("//input[@id=\"first-name-box\"]")).sendKeys("Aadqe");
		driver.findElement(By.xpath("//input[@id=\"last-name-box\"]")).sendKeys("zmr");
	
		String empID = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("empID -> " + empID);
			
		WebElement dd = driver.findElement(By.id("location"));
		Select sel = new Select(dd);
		sel.selectByVisibleText("Canadian Regional HQ");
		
		wait(1);
		click(driver.findElement(By.id("modal-save-button")));	
		wait(4);
		click(driver.findElement(By.linkText("Employee List")));
		
		boolean found = false;
		while (!found) {
			wait(2); 
			
			List<WebElement> idList = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[2]"));
			for (WebElement el : idList) { 
				String currentID = el.getText();
				System.out.println("currentID -> " + currentID);
				if (currentID.equals(empID)) { 
					found = true;
					el.click();
					break;
				}
			}
			if (!found) {
				System.out.println("I will click on Next");
				driver.findElement(By.xpath("//i[text()='chevron_right']")).click();
			}
		}
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HRM/Homework2.png"));
			System.out.println("Screenshot was taken!");
		} catch (IOException e) {
			System.out.println("Screenshot was NOT taken!");
		}
		wait(2);
		tearDown();	
	}

}
