package com.neotech.lesson05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neotech.util.ConfigsReader;
import com.neotech.util.Constants;

public class OpenOrangeHRM2 {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		}
		
		String website = ConfigsReader.getProperty("url");
		driver.get(website);
		
		String title = driver.getTitle();
		System.out.println("title -> " + title);
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		

	}

}
