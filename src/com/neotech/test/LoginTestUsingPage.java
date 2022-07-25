package com.neotech.test;

import com.neotech.pages.DashBoardPage;
import com.neotech.pages.LoginPage;
import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class LoginTestUsingPage extends CommonMethods {

	//in my test class I am not locating any elements.
	public static void main(String[] args) {
		// https://hrm.neotechacademy.com/
		
		setUp();
		
		//At this point we are locating the elements
		LoginPage login = new LoginPage();
		//sending the username
		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		//sending the password
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		
		//click on login buton 
		login.loginBtn.click();
		
		//same thing using the click() method in CommonMethods
		//click(login.loginBtn);
		
		//Validate login using the logo
		
		DashBoardPage dashboard = new DashBoardPage();
		
		if(dashboard.logo.isDisplayed()) {
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test Failed!");
		}
		
		//Let's validate that "Jacqueline White" is displayed
		
		String expectedName = "Jacqueline White";
		
		if(dashboard.name.getText().equals(expectedName)) {
			System.out.println(expectedName + " is displayed!");
		}else {
			System.out.println(expectedName + " is NOT displayed!");
		}
		
		tearDown();
		

	}

}
