package com.neotech.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.util.CommonMethods;

public class DragAndDropDemo extends CommonMethods{

	public static void main(String[] args) {
		// https://jqueryui.com/droppable/

		setUp();
		
		//we can use selenium's switchTo
		//driver.switchTo().frame(0);  // or
		
		//we can use our own method
		switchToFrame(0);
		wait(3);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions action  = new Actions(driver);
		
		action.dragAndDrop(drag, drop).perform();
		
		wait(3);
		
		
		//we can also do this in a longer way	
//		action.clickAndHold(drag).moveToElement(drop).release().perform();
//		wait(3);
		tearDown();
		
		
	}

}
