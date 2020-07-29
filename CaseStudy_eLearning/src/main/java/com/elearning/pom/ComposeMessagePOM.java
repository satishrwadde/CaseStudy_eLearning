package com.elearning.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.elearning.utils.Sleep;
import com.elearning.utils.Utils;

public class ComposeMessagePOM {
	
	private static WebDriver driver=null;
	private static String receiver,sendToString=null;
	
	public ComposeMessagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void sendComposeButton() {
		
		System.out.println("*************  In choose_Compose_option_to_send_message  ***********");
		driver.findElement(By.xpath("//*[contains(@href,'new_message.php')]")).click();

	}
	
	public static void sendReceiverDetails(String arg1) {
		
		String str,str1=null;
		receiver=Utils.FirstLetterCaps(arg1);
		
		System.out.println("*************  In enter_receiver_details  ***********");
		int len=arg1.length();
		System.out.println("Find length of receiver id >>>"+len);
		if (len<3) {
			System.out.println(" ****************  Receiver id length must be minimum 3 chars!");
		}
		else {
			System.out.println(" >>>>>>>>  Need to pass only 1st 3 chars so take out 3 chars!");
		
			String first_three=arg1.substring(0, 3);
			System.out.println("First 3 chars >>>>"+first_three);
			
			driver.findElement(By.xpath("//*[@id=\"compose_message\"]/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input")).sendKeys(first_three);
			Sleep.sleepSeconds(2);
			str=driver.findElement(By.xpath("//*[@id=\"select2-compose_message_users-results\"]/li")).getText();
						
			if (str.equalsIgnoreCase("No results found")) {
				
				System.out.println(">>>>>>>>  No receiver data found !");
				
			}else if (!str.equalsIgnoreCase("No results found")) {
				for (int i = 1; i < 3; i++) {

					str1=driver.findElement(By.xpath("//*[@id=\"select2-compose_message_users-results\"]/li["+i+"]")).getText();
					System.out.println(str1);
					
				}
				driver.findElement(By.xpath("//*[@id=\"select2-compose_message_users-results\"]/li[2]")).click();
				Sleep.sleepSeconds(1);
				sendToString=driver.findElement(By.xpath("//*[@id=\"compose_message\"]/fieldset/div[1]/div[1]/span/span[1]/span/ul/li[1]")).getText();
				
				//To remove x which is added in sendTo field
				sendToString=sendToString.substring(1);
				System.out.println("sendToString >>>> "+sendToString);
			}
		}
	}
	
	public static void sendSubject(String subject) {
		
		System.out.println("*************  In enter_subject  ***********");
		driver.findElement(By.id("compose_message_title")).sendKeys(subject);

	}
	
	public static void sendMessage() {
		
		System.out.println("*************  In type_message_to_sent  ***********");
		Sleep.sleepSeconds(5);
        driver.switchTo().frame(0);
        System.out.println("***** Inside frame!");
        Sleep.sleepSeconds(10); 
        driver.findElement(By.xpath("/html/body")).sendKeys("Hello "+receiver+ " \n" + "    This is for TestMail \n" + "\n" + "Thanks & Regards,"+ "\n"+ "Satish Wadde");
        Sleep.sleepSeconds(5);
        driver.switchTo().defaultContent();
        Sleep.sleepSeconds(5);

	}
	
	public static void sendAttachment(String filePath) {
		
		System.out.println("******* In upload_file_as_attachment()  ****** ");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);

	}
	
	public static void sendMessageButton() {
		
		Sleep.sleepSeconds(5);
		System.out.println("*************  In send_message  ***********");
		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
		Sleep.sleepSeconds(5);
	}
	
	public static void sendAck() {
		
		System.out.println("*************  In message_is_sent_successfully_and_acknowledgement_shown  ***********");
	 	String successAlert=driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[1]/b")).getText();
		System.out.println(successAlert);
		
		System.out.println(sendToString +" & "+successAlert);
		assertEquals(successAlert, sendToString);
		
	}
	
}
