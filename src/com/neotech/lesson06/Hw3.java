package com.neotech.lesson06;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.neotech.util.BaseClass;

public class Hw3 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
//		Go to "https://semantic-ui.com/modules/dropdown.html"
//        Scroll down to "Multiple Selection"
//        Click on drop down and select "CSS" and "HTML"
//        Verify value has been selected
//        Deselect 1 of the options from the dropdown
//        Quit browser
	
		
		setUp();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[1]/div/div/div[1]/div/a[4]")).click();
		//driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div[1]/div[1]")).click();
		
		
		
		
		WebElement multiselect = driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/select/option[1]"));
		
		Select sel = new Select(multiselect);
		
		List<WebElement> options = sel.getOptions();
		
		for(WebElement option : options) {
			String text = option.getText();
			System.out.println(text);	
		}
		
		
		
	}

}
