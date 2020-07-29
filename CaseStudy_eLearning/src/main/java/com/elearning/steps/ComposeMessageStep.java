package com.elearning.steps;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.elearning.pom.ComposeMessagePOM;
import com.elearning.utils.Sleep;
import com.elearning.utils.Utils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class ComposeMessageStep {

	
	private static WebDriver driver=null;

	
	public ComposeMessageStep() {

		//Lets keep compiler happy by creating default constructor :) 
	}

	
	public ComposeMessageStep(WebDriver driver) {
		this.driver = driver;
	}
	
	@When("^Choose Compose option to send message$")
	public void choose_Compose_option_to_send_message() throws Throwable {
		ComposeMessagePOM.sendComposeButton();
	}

	@When("^Enter receiver details \"([^\"]*)\"$")
	public void enter_receiver_details(String arg1) throws Throwable {
		ComposeMessagePOM.sendReceiverDetails(arg1);
	}

	@When("^Enter subject \"([^\"]*)\"$")
	public void enter_subject(String subject) throws Throwable {
		ComposeMessagePOM.sendSubject(subject);
	}


	@When("^Type message to sent$")
	public void type_message_to_sent() throws Throwable {
		ComposeMessagePOM.sendMessage();        
	}
	
	@When("^Upload file \"([^\"]*)\" as attachment$")
	public void upload_file_as_attachment(String filePath) throws Throwable {
		ComposeMessagePOM.sendAttachment(filePath);
	}

	@When("^Send message$")
	public void send_message() throws Throwable {
		
		ComposeMessagePOM.sendMessageButton();
	}

	@Then("^Message is sent successfully and acknowledgement shown$")
	public void message_is_sent_successfully_and_acknowledgement_shown() throws Throwable {
		ComposeMessagePOM.sendAck();
	}
}
