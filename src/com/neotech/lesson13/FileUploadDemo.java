package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.CommonMethods;

public class FileUploadDemo extends CommonMethods{

	public static void main(String[] args) {
		// https://the-internet.herokuapp.com/

		setUp();
		
		driver.findElement(By.linkText("File Upload")).click();
		
		String filePath = System.getProperty("user.dir") + "/screenshots/HRM/Homework2.png";
		System.out.println(filePath);
		
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		wait(2);
		
		driver.findElement(By.id("file-submit")).click();
		
		WebElement finalText = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
		CommonMethods.waitForVisibility(finalText);

		tearDown();
		
		
	}

}
