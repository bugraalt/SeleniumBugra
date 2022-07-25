package com.neotech.lesson12;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class ScreenShotDemo extends CommonMethods{

	public static void main(String[] args) {
		//https://hrm.neotechacademy.com/
		
		setUp();
		
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		
		
		wait(5);
		
		//create an object of TakesScreenshot (in fact we are downcasting)
		
		TakesScreenshot ts = (TakesScreenshot) driver; // get the camera (or open the camera app on your phone)
		
		//take the screenshot
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		//save the file somewhere
		
		try {
			FileUtils.copyFile(sourceFile, new File("screenshots/HRM/screenshot01.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot was NOT taken!");
		}
		
		//to upload FileUtils 1-) go to https://mvnrepository.com
		//2-) Search for commons io and download
		//3-)download bin. right click on project -> build path -> configure build path-> add external jar files
		
		tearDown();
		
		
	}

}
