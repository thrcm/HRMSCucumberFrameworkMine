package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.BaseClass;
import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	//FindBy is used in place of driver.findElement() method
	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(xpath = "//div[@id='divLogo']")
	public WebElement logo;
	
	@FindBy(id="logInPanelHeading")
	public WebElement loginLabel;
	
	@FindBy(css="input#txtPassword")
	public WebElement password;
	
	@FindBy(css="input[name='Submit']")
	public WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	public WebElement errorMsg;
	
	// constructor is used to initialize PageFactory class
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void login(String userID, String passCode) {
		sendText(userName, userID);
		sendText(password, passCode);
		click(loginBtn);
	}
}
