package com.elearning.steps;

import com.elearning.pom.SignUpPOM;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpStep {
	
	public SignUpStep() {
		System.out.println("");
		
	}
	
	@Given("^Launch webbrowser and eLearning website$")
	public void launch_webbrowser_and_eLearning_website()  {
		
		System.out.println("****** In launch_webbrowser_and_eLearning_website  *******");
	}

	@When("^Select language as \"([^\"]*)\"$")
	public void select_language_as(String arg1)  {
		
		System.out.println("****** In select_language_as  *******");
	}

	@When("^Click SignUp for registration in order to \"([^\"]*)\"$")
	public void click_SignUp_for_registration_in_order_to(String purpose)  {
		
		SignUpPOM.sendPurpose(purpose);
	}

	@When("^Enter user fname & lname as \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_user_fname_lname_as(String fname, String lname)  {
		
		SignUpPOM.sendName(fname, lname);
	}

	@When("^Enter user emailId as \"([^\"]*)\"$")
	public void enter_user_emailId_as(String email)  {	
	
		SignUpPOM.sendEmail(email);		
	}

	@When("^Enter username & password details \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_username_password_details(String uname, String pwd)  {
		
		SignUpPOM.sendUsernamePassword(uname, pwd);	
	}

	@When("^Validate strength of password$")
	public void validate_strength_of_password()  {
		
		SignUpPOM.sendValidatePassword();
	}

	@When("^Enter user phone \"([^\"]*)\"$")
	public void enter_user_phone(String phone)  {
		SignUpPOM.sendPhone(phone);
	}

	@When("^Verify language dropdown has \"([^\"]*)\"$")
	public void verify_language_dropdown_has(String arg1)  {
		SignUpPOM.sendLanguage(arg1);
	}

	@When("^Enter code Skype and linkedin details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_code_Skype_and_linkedin_details(String code, String skypeid, String linkedin)  {
		SignUpPOM.sendSkypeLinkedIn(code, skypeid, linkedin);
	}

	@When("^Click on register$")
	public void click_on_register()  {
		
		SignUpPOM.sendRegister();
	}

	@Then("^User user redirected to success page$")
	public void user_user_redirected_to_success_page()  {

		System.out.println("****** In user_user_redirected_to_success_page  *******");
	}
	
	@Then("^Verify success page message$")
	public void verify_success_page_message()  {
		
		SignUpPOM.sendSuccessMessage();
	}

	@Then("^Validate email on success page$")
	public void validate_email_on_success_page() {
		
		SignUpPOM.sendEmailValidation();
	}	
}
