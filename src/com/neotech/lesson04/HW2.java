package com.neotech.lesson04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
	
	public final static String url = "https://demoqa.com/radio-button";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		List<WebElement> radioButtons = driver.findElements(By.xpath("//label[starts-with(@class, 'custom-control-label')]"));
		
		for(WebElement rb : radioButtons) {
			if(rb.isDisplayed()) {
				System.out.println("Button is displayed");
			}else {
				System.out.println("Not displayed");
			}
		}
		List<WebElement> radioList = driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement radio : radioList) {
			if(radio.isEnabled()) {
				System.out.println("Radio Enabled");
				
			}else {
				System.out.println("Radio not enabled");
			}
		}	
		WebElement yesB = driver.findElement(By.xpath("//label[@for='yesRadio']"));
		yesB.click();	
		WebElement yesR = driver.findElement(By.id("yesRadio"));
		
		if(yesR.isSelected()) {
			System.out.println("Yes is selected");
		}else {
			System.out.println("Yes is not selected");
		}		
		WebElement impressiveB = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
		impressiveB.click();
		WebElement impR = driver.findElement(By.id("impressiveRadio"));
		
		if(impR.isSelected()) {
			System.out.println("Impressive is selected");
		}else {
			System.out.println("Impressive is not selected");
		}
		WebElement noB = driver.findElement(By.xpath("//label[@for='noRadio']"));
		noB.click();
		WebElement noR = driver.findElement(By.id("noRadio"));
		
		if(noR.isSelected()) {
			System.out.println("NO is selected");
		}else {
			System.out.println("NO is not selected");
		}
		Thread.sleep(2000);
		driver.quit();
		
		
	
		
	}

}
