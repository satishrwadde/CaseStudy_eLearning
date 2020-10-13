package com.elearning.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedInPOM {

	private static WebDriver driver;

	public LinkedInPOM(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	public static void linkedInMethod() {
		
		String str=driver.findElement(By.xpath("//main[@class='app__content ']/div[2]/div[2]/h1")).getText();
		System.out.println(str);
		
	}
	
}
