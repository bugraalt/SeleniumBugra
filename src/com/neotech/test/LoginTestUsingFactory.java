package com.neotech.test;

import com.neotech.pages.DashBoardPageUsingFactory;
import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class LoginTestUsingFactory extends CommonMethods{

	public static void main(String[] args) {
		//https://hrm.neotechacademy.com/
		
		setUp();
		
		//At this point we are NOT locating the elements
		//We are just telling how the elements will be located
		
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		DashBoardPageUsingFactory dashboard = new DashBoardPageUsingFactory();
		
		
		//sending the username and password
		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		
		//click on login button
		login.loginBtn.click();
		
		wait(3);
		
		//Validate login using the logo
		
		if(dashboard.logo.isDisplayed()) {
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test failed!");
		}
		
		//Let's validate that "Jacqueline White" is displayed
		String expectedName = "Jacqueline White";
		
		if(dashboard.name.getText().equals(expectedName)) {
			System.out.println(expectedName + " is displayed!");
		}else {
			System.out.println(expectedName + " is NOT displayed");
		}
		
		
		tearDown();
		
	}
}
