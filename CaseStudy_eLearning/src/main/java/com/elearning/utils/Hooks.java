package com.elearning.utils;

import com.elearning.pom.ComposeMessagePOM;
import com.elearning.pom.EmailValidationPOM;
import com.elearning.pom.SignUpPOM;
import com.elearning.steps.ComposeMessageStep;
import com.elearning.steps.EmailValidation;
import com.elearning.steps.SignUpStep;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;

public class Hooks {

	private WebDriver driver=null;
	private String url="http://elearningm1.upskills.in/";
	private EmailValidationPOM emailValidationPom=null;
	private ComposeMessagePOM composemsgPom=null;
	private SignUpPOM signUpPOM=null;
	public Hooks() {
		
	}
		
  @Before
   public void setUp() {
	 
	  driver=DriverFactory.getMyDriver(DriverNames.CHROME);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  System.out.println("Driver : "+driver);
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  signUpPOM=new SignUpPOM(driver);
	  emailValidationPom=new EmailValidationPOM(driver);
	  composemsgPom=new ComposeMessagePOM(driver);
  }

  
  @After
  public void tearDown() {
	  
	  System.out.println("Before quitting browser : ");
	  Sleep.sleepSeconds(1);
	  driver.quit();
  }

}
