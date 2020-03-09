package com.hrms.steps;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		login.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		dashboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {
		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.saveBtn);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String firstName, String middleName, String lastName) {
		employeeNameDisplayed();
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		addEmp.empId.clear();
	}

	@Then("I see employee {string}, {string} and {string} without employee id is being added")
	public void i_see_employee_and_without_employee_id_is_being_added(String string, String string2, String string3) {
		empId = "";
		Assert.assertEquals("Employee ID is null", pdetails.empId.getText(), empId);
	}

	@When("I enter Employee Details")
	public void i_enter_Employee_Details(DataTable employeeDetails) {
		List<Map<String, String>> empDetailsList = employeeDetails.asMaps();
		for (Map<String, String> map : empDetailsList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
			sendText(addEmp.empId, map.get("EmployeeID"));
		}
	}

	@And("I click on Edit")
	public void i_click_on_Edit() {
		pdetails.click_Edit_Save.click();
	}
	

	@Then("I click on save")
	public void I_click_on_save() throws InterruptedException {
		click(pdetails.click_Edit_Save);
		Thread.sleep(3000);
	}
	

	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) throws InterruptedException {
		List<Map<String, String>> modifyList=modifyEmpDetail.asMaps();
		
		for(Map<String, String> map: modifyList) {
			//click on edit
			click(pdetails.click_Edit_Save);
			Thread.sleep(5000);
			
			//passing new details to the employee
			sendText(pdetails.licExpDate, map.get("ExpirationDate"));
			sendText(pdetails.licenNo, map.get("DriverLisence"));
			sendText(pdetails.SSN, map.get("SSN"));
			sendText(pdetails.SIN, map.get("SIN"));
			clickRadio(pdetails.genderLabels, map.get("Gender"));
			Thread.sleep(2000);
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			selectDdValue(pdetails.nationality, map.get("Nationality"));
			sendText(pdetails.DOB, map.get("DOB"));
			
			//click on save
			click(pdetails.click_Edit_Save);
		}
	}
}
