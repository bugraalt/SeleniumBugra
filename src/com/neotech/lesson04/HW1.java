package com.neotech.lesson04;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
	
	public final static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
	public final static String username = "Tester";
	public final static String password = "test";

	public static void main(String[] args) throws InterruptedException {	

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement uName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
		uName.sendKeys(username);
		uName.clear();
		uName.sendKeys(username);
		
		WebElement pWord = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
		
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
		
		WebElement errMessage = driver.findElement(By.xpath("//span[@id='ctl00_MainContent_status']"));
		
		if(errMessage.isDisplayed()) {
			System.out.println("Error message -> " + errMessage.getText() + " is displayed. Test passed!");
		}
		else 
		{
			System.out.println("Error message was not displayed.Test failed.");
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
