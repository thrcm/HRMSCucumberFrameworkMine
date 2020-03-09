package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.BaseClass;

public class PersonalDetailsPageElements {
	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement DriverLicense;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="btnSave")
	public WebElement click_Edit_Save;
	
	@FindBy(id = "personal_txtSINNo")
	public WebElement SIN;

	@FindBy(id = "personal_cmbMarital")
	public WebElement maritalStatus;

	@FindBy(id = "personal_cmbNation")
	public WebElement nationality;

	@FindBy(id = "personal_DOB")
	public WebElement DOB;
	
	@FindBy(xpath="//label[contains(@for, 'personal_optGender')]")
	public List<WebElement> genderLabels;
	
	@FindBy(id = "personal_txtLicExpDate")
	public WebElement licExpDate;
	
	@FindBy(xpath = "//input[@name='personal[optGender]']")
	public List<WebElement> gender;
	
	@FindBy(id = "personal_txtLicenNo")
	public WebElement licenNo;
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}