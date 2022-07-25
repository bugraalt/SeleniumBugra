package com.neotech.lesson06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class Hw1 extends BaseClass{

		public static void main(String[] args) throws InterruptedException {
			
			setUp();
			
			WebElement departments = driver.findElement(By.id("searchDropdownBox"));
			
			Select selDepartments = new Select(departments);
			
			System.out.println("How many departments available ? " + 
			selDepartments.getOptions().size());
			
			List<WebElement> options = selDepartments.getOptions();
			
			for(WebElement option : options) {
				String text = option.getText();
				System.out.println(text);
			}
			
			selDepartments.selectByVisibleText("Computers");
			
			Thread.sleep(2000);
			tearDown();
		}
}