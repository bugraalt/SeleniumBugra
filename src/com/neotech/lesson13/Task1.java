package com.neotech.lesson13;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.neotech.util.CommonMethods;

public class Task1 extends CommonMethods {

	public static void main(String[] args) {
//		TC 1: Upload file and Take Screenshot
//		Navigate to "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload"
//		Upload file
//		Verify file got successfully uploaded and take screenshot

		setUp();
		String filePath = System.getProperty("user.dir") + "/screenshots/Lesson13/Homework2.png";
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys(filePath);
		wait(2);
		driver.findElement(By.xpath("//button[@class='gwt-Button']")).click();
		wait(2);
		String expectedText = "File uploaded!";
		String actualText = getAlertText();
		if (expectedText.equals(actualText)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
		// A method in our CommonMethods
		acceptAlert();
		// Take the Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("screenshots/Lesson13/FileUpload.png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The screenshot cannot be saved!");
		}
		tearDown();
	}

}
