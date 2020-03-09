
package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods{

	LoginPageElements login;
	
	@Given("I open browser and navigate to HRMS.com")
	public void i_open_browser_and_navigate_to_HRMS_com() {
		setUp();
	}

	@When("I put in valid username and valid password")
	public void i_put_in_valid_username_and_valid_password() {
		login = new LoginPageElements();
		sendText(login.userName, "Admin");
		sendText(login.password, "Syntax@123");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully log in")
	public void i_successfully_log_in() {
		System.out.println("logged in successfully");
	}

	@When("I put in valid username and invalid password")
	public void i_put_in_valid_username_and_invalid_password() {
		login = new LoginPageElements();
		sendText(login.userName, "Admin");
		sendText(login.password, "123456");
	}

	@Then("I get error message")
	public void i_get_error_message() {
		Boolean error = login.errorMsg.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}
	
	@Then("I close the window")
	public void i_close_the_window() {
		tearDown();
	}

	
}

