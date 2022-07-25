package com.neotech.lesson09;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.BaseClass;

public class Lesson09Hw01 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//		TC: Update Customer Informatio
//		1) Open chrome browser
//		2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
//		3) Login to the application
//		4) Verify customer "Susan McLaren" is present in the table
//		5) Click on customer details
//		6) Update customers last name and credit card info
//		7) Verify updated customers name and credit card number is displayed in table
//		8) Close browser
		
		setUp();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String initialName = "Susan McLaren";
		String path ="";
		String updatedName = "Susan Vettel";
		String updatedCard = "12345678";
		int indexRow = 0;
		
		List<WebElement> infoRow = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		for(int i =0; i <infoRow.size(); i++) {
			String rowText = infoRow.get(i).getText();
			indexRow =i+1;
			
			if(rowText.contains(initialName)) {
				System.out.println(initialName +" is present in the table. Row number -> " + (i+1));
				path = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" +indexRow+ "]/td[13]"	;
				driver.findElement(By.xpath(path)).click();
				break;		
			}
		}
		
		WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
		WebElement cardNo = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
		
		customerName.clear();
		Thread.sleep(1000);
		customerName.sendKeys(updatedName);
		Thread.sleep(1000);
		cardNo.clear();
		Thread.sleep(1000);
		cardNo.sendKeys(updatedCard);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
	
		WebElement rows = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+ indexRow +"]"));
		
			if(rows.getText().contains(updatedName) && rows.getText().contains(updatedCard)) {
				System.out.println("Information updated and shows in table");
			}else {
				System.out.println("NOT UPDATED");
			}
		Thread.sleep(4000);
		tearDown();

	}

}
