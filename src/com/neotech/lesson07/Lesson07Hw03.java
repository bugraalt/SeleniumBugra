package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class Lesson07Hw03 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
//	1) Launch the browser and open the site "https://www.tutorialspoint.com/selenium/selenium_automation_practice"
//	2) Fill in the all text boxes, Choose your preferred radio button, check box and drop down option 
//	EXCEPT Profile Picture (Dissmiss this Section)
//	3) Click on the Button and you will see an Alert pops up then click Ok
//	4) When user clicks on Ok new Window will open then get All window handles and get the size and Quit all of them

		setUp();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sebastian");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Vettel");
		
		WebElement genderMale = driver.findElement(By.xpath("//input[@name='sex'][@value='Male']"));
		genderMale.click();
		
		WebElement yearsExp = driver.findElement(By.xpath("//input[@value='5']"));
		yearsExp.click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/form/table/tbody/tr[5]/td["
				+ "2]/input")).sendKeys("05/07/2022");
		
		WebElement auTester = driver.findElement(By.xpath("//input[@value='Automation Tester']"));
		auTester.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span/input[@value='Selenium Webdriver']")).click();
		Thread.sleep(1000);
		
		WebElement ddContinents = driver.findElement(By.name("continents"));
		
		Select selDD = new Select(ddContinents);
		
		selDD.selectByVisibleText("Europe");
		Thread.sleep(1000);
		
		WebElement multSelect = driver.findElement(By.name("selenium_commands"));
		
		Select multSel = new Select(multSelect);
		
		multSel.selectByVisibleText("Browser Commands");
		multSel.selectByVisibleText("Wait Commands");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		Thread.sleep(2000);
		
		Alert xAlert = driver.switchTo().alert();
		xAlert.accept();
		
		Thread.sleep(1000);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println("The size of all opened windows ->" + windows.size());
		
		for(String window: windows) {
			System.out.println(window);
		}
		
		Thread.sleep(2000);
		driver.close();
		tearDown();
		
		
	}

}
