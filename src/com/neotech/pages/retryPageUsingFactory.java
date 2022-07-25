package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.util.BaseClass;

public class retryPageUsingFactory {
	
	@FindBy (xpath = "//div[@id=\"toast-container\"]/div/div")
	public WebElement invalidCredentials;
	
	public retryPageUsingFactory (){
		PageFactory.initElements(BaseClass.driver, this);
	}

}
