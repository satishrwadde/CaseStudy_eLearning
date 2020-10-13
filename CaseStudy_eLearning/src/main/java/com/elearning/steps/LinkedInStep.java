package com.elearning.steps;

import org.openqa.selenium.WebDriver;

import com.elearning.pom.LinkedInPOM;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class LinkedInStep {
	
	private static WebDriver driver;
	
	public LinkedInStep() {

		//Lets keep compiler happy by creating default constructor :) 
	}
	
	public LinkedInStep(WebDriver driver) {
		this.driver = driver;
	}


	@When("^LinkedIn Username \"([^\"]*)\" entered$")
	public void linkedin_Username_entered(String arg1) throws Throwable {

		LinkedInPOM.linkedInMethod();
	}

	@When("^LinkedIn Password \"([^\"]*)\" entered$")
	public void linkedin_Password_entered(String arg1) throws Throwable {
		
		LinkedInPOM.linkedInMethod();
	}


	
	
}
