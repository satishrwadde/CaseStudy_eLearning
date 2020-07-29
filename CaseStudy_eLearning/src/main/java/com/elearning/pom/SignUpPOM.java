package com.elearning.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elearning.utils.Sleep;

public class SignUpPOM {

	private static WebDriver driver;
	private static String fname_signup=null;
	private static String lname_signup=null;
	private static String email_signup=null;


	public SignUpPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void sendPurpose(String purpose){
		
		WebElement signup=driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]"));
		System.out.println("****** In click_SignUp_for_registration_in_order_to  *******"+signup);
		System.out.println(signup.isDisplayed());
		signup.click();
		Sleep.sleepSeconds(5);
		if (purpose.equalsIgnoreCase("Follow courses")) {
			//Follow courses option
			driver.findElement(By.xpath("//input[@value='5' and @class='register-profile']")).click();
			System.out.println(purpose);
			
		}else if (purpose.equalsIgnoreCase("Teach courses")) {
			//Teach courses option
			driver.findElement(By.xpath("//input[@value='1' and @class='register-profile']")).click();
			System.out.println(purpose);
			
		}

	}
	
	public static void sendName(String fname,String lname) {
		
	System.out.println("****** In enter_user_fname_lname_as  *******");
		
		driver.findElement(By.xpath("//input[@id='registration_firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='registration_lastname']")).sendKeys(lname);
		fname_signup=fname;
		lname_signup=lname;
	}
	
	public static void sendEmail(String email) {
		
		System.out.println("****** In enter_user_emailId_as  *******");

		driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys(email);
		email_signup=email;

	}
	
	public static void sendUsernamePassword(String uname,String pwd) {
		
		System.out.println("****** In enter_username_password_details  *******");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys(pwd);
	
	}
	
	public static void sendValidatePassword(){
		
		System.out.println("****** In validate_strength_of_password  *******");
		
//		driver.findElement(By.xpath("//div[@class='progress-bar progress-bar-danger']"));
		///html/body/main/section/div/div[2]/div/form/fieldset/div[6]/div[1]/div/div

	}
	
	public static void sendPhone(String phone) {
		
		System.out.println("****** In enter_user_phone  *******");
		driver.findElement(By.xpath("//input[@id='registration_phone']")).sendKeys(phone);
	}
	
	public static void sendLanguage(String arg1) {
		
		System.out.println("****** In verify_language_dropdown_has  *******");
		
		String lang=driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).getText();
		// Here I am comparing language selected from sign up page
		assertEquals(lang.equalsIgnoreCase(arg1), true);

	}
	
	public static void sendSkypeLinkedIn(String code, String skypeid, String linkedin) {
		

		System.out.println("****** In enter_code_Skype_and_linkedin_details  *******");
		
		driver.findElement(By.xpath("//input[@id='registration_official_code']")).sendKeys(code);
		driver.findElement(By.xpath("//input[@id='extra_skype']")).sendKeys(skypeid);
		driver.findElement(By.xpath("//input[@id='extra_linkedin_url']")).sendKeys(linkedin);

	}
	public static void sendRegister() {
		
		System.out.println("****** In click_on_register  *******");
		driver.findElement(By.xpath("//*[@id='registration_submit']")).click();

	}
	
	public static void sendSuccessMessage() {
		
		System.out.println("****** In verify_success_page_message  *******");
		String dearString=driver.findElement(By.xpath("/html/body/main/section/div/div[2]/div/p[1]")).getText();
		String a[]=dearString.split(" ");
		String b[]=a[2].split(",");
		System.out.println("First Name & Last Name respectively are : "+a[1]+" & "+b[0]);
		//fname_signup="Satish";
		assertEquals(a[1], fname_signup);
		assertEquals(b[0], lname_signup);

	}
	
	public static  void sendEmailValidation() {
		
		driver.findElement(By.xpath("//img[contains(@src,'unknown.png')]")).click();
		String actualEmail=driver.findElement(By.xpath("/html/body/main/header/nav/div/div[2]/ul[2]/li[2]/ul/li[1]/div/p")).getText();
		System.out.println("actualEmail"+actualEmail);
		System.out.println("email_signup"+email_signup);
		assertEquals(actualEmail, email_signup);	

	}
}

