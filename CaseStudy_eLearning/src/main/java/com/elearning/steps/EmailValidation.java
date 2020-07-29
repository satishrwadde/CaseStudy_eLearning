package com.elearning.steps;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.elearning.pom.EmailValidationPOM;
import com.elearning.utils.Driver;

import cucumber.api.java.en.When;

public class EmailValidation {

	private static WebDriver driver=null;
	
	public EmailValidation() {

		//Lets keep compiler happy by creating default constructor :) 
	}

	public EmailValidation(WebDriver driver) {

		this.driver = driver;
	}
	
	@When("^Enter username and pass \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_username_and_pass(String username, String pass) throws Throwable {
		
		EmailValidationPOM.sendUsernamePassword(username, pass);
		
	}

	@When("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {

		EmailValidationPOM.sendLogin();
	}

	@When("^Validate logged in user \"([^\"]*)\"$")
	public void validate_logged_in_user(String expectedEmail) throws Throwable {
		
		EmailValidationPOM.sendEmailValidation(expectedEmail);
	}

}
