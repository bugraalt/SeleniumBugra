package com.neotech.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.util.CommonMethods;

public class Lesson12HW01 extends CommonMethods {

	public static void main(String[] args) {
//		Homework 1:
//		Go to https://demo.seleniumeasy.com/
//		Click on "Others"
//		Click on "Drag and Drop"
//		Drag items 2, 4 and 1 from "Item to Drag" and drop them under "Drop Here"
//		Close the browser
		
		setUp();
		
		
		wait(3);
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		wait(2);
		
		CommonMethods.click(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[4]/a")));
		CommonMethods.click(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[4]/ul/li[1]/a")));
			
		WebElement draggable2 = driver.findElement(By.xpath("//span[text()=\"Draggable 2\"]"));
		WebElement draggable4 = driver.findElement(By.xpath("//span[text()=\"Draggable 4\"]"));
		WebElement draggable1 = driver.findElement(By.xpath("//span[text()=\"Draggable 1\"]"));
		
		WebElement droppable = driver.findElement(By.id("mydropzone"));
		
		Actions action = new Actions(driver);
		
		wait(2);
		action.dragAndDrop(draggable2, droppable).perform();
		wait(2);
		action.dragAndDrop(draggable4, droppable).perform();
		wait(2);
		action.dragAndDrop(draggable1, droppable).perform();
		wait(2);
		
		tearDown();
		
		
	}

}
