package com.neotech.lesson09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class Lesson09Hw02 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		int count = 0;
		
		List<WebElement> xx = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		for(int i =0; i<xx.size(); i++) {
			String xxText = xx.get(i).getText();
			int ind = i+1;
			
			if(xxText.contains("FamilyAlbum")) {
				//String path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+ ind +"]/td[3]";
				String path2 ="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+ ind +"]/td[1]";
				driver.findElement(By.xpath(path2)).click();
				Thread.sleep(2000);
				count++;
			}
			
		}
		
		driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete")).click();
		Thread.sleep(2000);
		
		System.out.println(count + " rows deleted. We initially had " + xx.size() + " rows." );
		
		
		tearDown();
	}

}
