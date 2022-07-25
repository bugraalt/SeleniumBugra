package com.neotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.util.CommonMethods;

public class DashBoardPage extends CommonMethods{

	
	public WebElement logo = driver.findElement(By.id("ohrm-small-logo"));
	
	public WebElement name = driver.findElement(By.id("account-name"));
	
}
