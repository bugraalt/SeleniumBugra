package com.neotech.lesson08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.util.BaseClass;
import com.neotech.util.ConfigsReader;

public class Lesson08Hw03 extends BaseClass{

	public static void main(String[] args) {
//		 	Add Employee
//	        Go to "https://hrm.neotechacademy.com/"
//	        Login into the application
//	        Click on PIM > Add Employee 
//	        Add Employee
//	        Log out 
//	        Quit the browser
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.xpath("//div//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='modal-title'][text()='Add Employee']")));
		
		driver.findElement(By.id("first-name-box")).sendKeys("Sebastian");
		driver.findElement(By.id("last-name-box")).sendKeys("Vettel");
		
		WebElement dd = driver.findElement(By.id("location"));
		Select selDD = new Select(dd);
		selDD.selectByValue("string:18");
		
		driver.findElement(By.id("modal-save-button")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Personal Details']")));
		
		driver.findElement(By.xpath("//*[@id=\"account-job\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
		
		tearDown();
		

	}

}
