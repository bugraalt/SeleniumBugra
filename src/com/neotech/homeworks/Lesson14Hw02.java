package com.neotech.homeworks;

import com.neotech.pages.LoginPageUsingFactory;
import com.neotech.pages.retryPageUsingFactory;
import com.neotech.util.CommonMethods;
import com.neotech.util.ConfigsReader;

public class Lesson14Hw02 extends CommonMethods {

	public static void main(String[] args) {
//		TC 2: Orange HRM wrong password validation
//		1. Go to https://hrm.neotechacademy.com/
//		2. Enter valid username and wrong password
//		3. Click on login button
//		4. Verify error message with text "Invalid credentials" is displayed

		setUp();

		LoginPageUsingFactory login = new LoginPageUsingFactory();

		CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, "wrongPass");
		CommonMethods.click(login.loginBtn);
		
		retryPageUsingFactory retryPage = new retryPageUsingFactory();

		String expectedText = "Invalid Credentials";
		String actualText = retryPage.invalidCredentials.getText();
		System.out.println(actualText);

		if (actualText.equals(expectedText)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}

		wait(2);
		tearDown();

	}

}
