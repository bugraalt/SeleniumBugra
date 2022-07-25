package com.neotech.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson03Homework01 {

	public static void main(String[] args) throws InterruptedException {
		final String url = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Smith");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("05443339944");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("johnsmith@gmail.com");
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("31 panama ave.");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Seacaucus");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("NJ");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("12355");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("JohnSmith");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("JSM12355");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("JSM12355");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		String expectedURL = "https://demo.guru99.com/test/newtours/register_sucess.php";
		String actualURL = driver.getCurrentUrl();
		
		if(actualURL.equalsIgnoreCase(expectedURL)) {
			System.out.println("User successfully registered!");
		}else {
			System.out.println("Please try again.");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
