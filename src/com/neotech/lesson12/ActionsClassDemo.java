package com.neotech.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.util.CommonMethods;

public class ActionsClassDemo extends CommonMethods {

	public static void main(String[] args) {
		// https://www.amazon.com/

		setUp();

		Actions action = new Actions(driver);

		// DO NOT FORGET TO ADD PERFORM();

		action.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).perform();

		wait(3);

		WebElement el = driver.findElement(By.id("nav-flyout-ya-newCust"));

		if (el.getText().contains("Start")) {
			System.out.println("Menu is displayed!");
		} else {
			System.out.println("Menu is NOT displayed");
		}

		// HOW DO WE RIGHT CLICK ? - DO NOT FORGET .PERFORM();

		action.contextClick(el).perform(); // right click

		wait(3);
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		action.moveToElement(searchBox).click().sendKeys("books").doubleClick().perform();
		
		wait(3);
		
		tearDown();

	}

}
