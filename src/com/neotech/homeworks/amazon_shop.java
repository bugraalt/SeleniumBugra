package com.neotech.homeworks;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;
import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class amazon_shop extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		
		driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input"
				+ "input")).sendKeys("brikenstock");
		
		driver.findElement(By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[2]")).click();
				
		
		Thread.sleep(5000);
		tearDown();
		

	}

}


