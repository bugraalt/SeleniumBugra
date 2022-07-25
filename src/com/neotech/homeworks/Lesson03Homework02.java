package com.neotech.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson03Homework02 {

	public static void main(String[] args) throws InterruptedException {
		final String url = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By.cssSelector("a[href='register.php']")).click();
		
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("John");		
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Smith");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("05443339922");
		driver.findElement(By.cssSelector("#userName")).sendKeys("johnsmith@gmail.com");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("31 vv avenue");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Keywest");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("FL");
		driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("22334");
		driver.findElement(By.cssSelector("#email")).sendKeys("JohnSmith12");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("JS123311");
		driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("JS123311");
		
		driver.findElement(By.cssSelector("input[name='submit']")).click();
		
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
