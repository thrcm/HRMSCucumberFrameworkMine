package com.hrms.testBase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitiliazer extends BaseClass {

	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	protected static LoginPageElements login;
	protected static DashboardPageElements dashboard;
	
	public static void initiliazePages() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pdetails = new PersonalDetailsPageElements();
	}
}
