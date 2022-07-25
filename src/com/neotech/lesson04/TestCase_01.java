package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_01 {
	
	public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

	public static String username = "Tester";
	public static String password = "test";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
		
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		WebElement logo = driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		
		System.out.println(logo.getText());
	
		if(logo.isDisplayed()) {
			System.out.println("The logo with text " + logo.getText() + " is displayed");
		}
		else {
			System.out.println("The logo is not displayed");
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
