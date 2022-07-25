package com.neotech.lesson10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.util.BaseClass;

public class Lesson10Hw1 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {		
		setUp();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
		from.clear();
		from.sendKeys("JFK");
		WebElement to = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
		to.sendKeys("IST");
		//driver.findElement(By.id("aa-leavingOn")).click();
		driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[4]/div[1]/div/button")).click();
		
		String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
		
		while(!month.equals("December")) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
			month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
		}
		List<WebElement> cells = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		
		for(WebElement day : cells) {
			String dayNum = day.getText();
			if(dayNum.equals("14")) {
				day.click();
				break;
			}
		}	
		//RETURN
		driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[4]/div[2]/div/button")).click();
		
		String returnMonth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
		
		while(!returnMonth.equals("December")) {
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
			returnMonth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]")).getText();
		}	
		List<WebElement> returnCells = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		
		for(WebElement returnDay : returnCells) {
			String returnDayNum = returnDay.getText();
			if(returnDayNum.equals("22")) {
				returnDay.click();
				break;		
			}
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("flightSearchForm.button.reSubmit")).submit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='aa-pageTitle']")));
	
		boolean isDisplayed = driver.findElement(By.xpath("//h1[@id='aa-pageTitle']")).isDisplayed();
		System.out.println(isDisplayed);
		
		tearDown();

	}

}
