package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxes {

	public final static String url = "https://demoqa.com/automation-practice-form";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);

		// 1st way
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Serhat");
		driver.findElement(By.xpath("//input[@id='firstName']")).clear();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Serhat");

		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Ucal");

		// 2nd - code redundancy and reusability

		WebElement fname = driver.findElement(By.xpath("//input[@id='firstName']"));
		fname.clear();
		fname.sendKeys("Sherzod");

		String idAttribute = fname.getAttribute("id");
		System.out.println("The value of the id attribute is " + idAttribute);

		WebElement lname = driver.findElement(By.cssSelector("#lastName"));
		lname.clear();
		lname.sendKeys("Tokhtakhunov");

		WebElement header = driver.findElement(By.xpath("//div[text()='Practice Form']"));

		String headerText = header.getText();
		System.out.println("Header is: " + headerText);
		System.out.println("Value of the class attribute is: " + header.getAttribute("class"));

		Thread.sleep(2000);
		driver.quit();
	}

}
