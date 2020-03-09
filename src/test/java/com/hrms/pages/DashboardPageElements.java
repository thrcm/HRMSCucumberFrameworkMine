package com.hrms.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testBase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	//making it public because element should be found by classes in other packages
	@FindBy(id="menu_dashboard_index")
	public WebElement dashboard;
	
	@FindBy(id="menu_time_viewTimeModule")
	public WebElement timeButton;
	
	@FindBy(linkText="Attendance")
	public WebElement attendance;
	
	@FindBy(linkText="Employee Records")
	public WebElement employeeRecords;
	
	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText = "PIM")
	public WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	@FindBy(id = "welcome")
	public WebElement welcomeLnk;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void getEmployeeRecord() {
		click(timeButton);
		click(attendance);
		click(employeeRecords);
	}
	
	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}

	public void navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}

}
