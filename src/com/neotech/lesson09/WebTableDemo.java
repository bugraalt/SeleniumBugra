package com.neotech.lesson09;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class WebTableDemo extends BaseClass{

	public static void main(String[] args) {	
		//https://demo.seleniumeasy.com/table-search-filter-demo.html	
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("==== HEADER DATA ====");
		
		List<WebElement> headerData = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		
		Iterator<WebElement> it = headerData.iterator();
		while(it.hasNext()) {
			String headerText = it.next().getText();
			System.out.println(headerText + " | ");
		}
		
		System.out.println();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("The number of rows is " + rows.size());
		
		System.out.println("===== ROW DATA =====");
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td"));
		
		for(WebElement data : rowData) {
			System.out.println(data.getText());
			
		}
		
		tearDown();
	}

}
