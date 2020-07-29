package com.elearning.testRunners;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/com/elearning/features/"},
		glue = {"com.elearning.steps","com.elearning.utils"},
		monochrome = true,
		plugin= {"pretty",
				"html:target/cucumber-html-report" , 
				"json:target/cucumber-json-report",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extendedReport.html"}
//		,tags = {"@signinEmailVal"}
	)

public class E_learning_TestRunner extends AbstractTestNGCucumberTests {

	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }
// Without me you can not run the project so you need to create me and extend AbstractTestNGCucumberTests :)

}
