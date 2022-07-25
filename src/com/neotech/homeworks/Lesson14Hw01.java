package com.neotech.homeworks;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class Lesson14Hw01 extends CommonMethods{

	public static void main(String[] args) {
//		TC 1: Orange HRM blank password validation
//		1. Go to https://hrm.neotechacademy.com/
//		2. Enter valid username and leave password field empty
//		3. Click on login button
//		4. Verify error message with text "Password cannot be empty" is displayed

		setUp();
		
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		
		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		
		CommonMethods.click(login.loginBtn);
		
		String expectedText = "Password cannot be empty";
		
		String actualText = login.passwordError.getText();
		System.out.println(actualText);
		
		if(actualText.equals(expectedText)) {
			System.out.println("Test Passed!");
		}else {
			System.out.println("Test Failed!");
		}
		
		wait(2);
		tearDown();
		
		
	}

}
