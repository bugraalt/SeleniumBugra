package com.neotech.lesson06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class Hw2 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
		driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div/div/div/div[3]/div/ul/li[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
			
		Alert alert1 = driver.switchTo().alert();
		String alert1Text = alert1.getText();
		Thread.sleep(2000);
		System.out.println(alert1Text + " --> text is present!");
		alert1.accept();
		
		driver.findElement(By.cssSelector("#confirmButton")).click();
		
		Alert alert2 = driver.switchTo().alert();
		String alert2Text = alert2.getText();
		Thread.sleep(2000);
		System.out.println(alert2Text + " -> text is present!");
		alert2.accept();
		
		driver.findElement(By.cssSelector("button#promtButton")).click();
		
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert3.sendKeys("Bugra");
		Thread.sleep(2000);
		alert3.accept();
		
		Thread.sleep(2000);
		tearDown();
		

	}

}
