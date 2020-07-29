package com.elearning.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmailValidationPOM {
	
	private static WebDriver driver;
	
	public EmailValidationPOM(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void sendUsernamePassword(String uname,String pass) {
	
		System.out.println("************** In enter_username_and_pass **********************");
		driver.findElement(By.id("login")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);

	}
	
	public static void sendLogin() {

		System.out.println("************** In click_on_Login_button **********************");
		driver.findElement(By.id("form-login_submitAuth")).click();

	}
	
	public static void sendEmailValidation(String expectedEmail) {
	
		System.out.println("************** In validate_logged_in_user **********************");
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a/img")).click();
		WebElement element=driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[1]/div/p"));
		String actualEmailOnScreen=element.getText();
		System.out.println("Actual Email On Screen:"+actualEmailOnScreen +" && Expected Email : "+expectedEmail);
		assertEquals(actualEmailOnScreen, expectedEmail);
		
	}
}
