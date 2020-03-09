package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITest {

	//@Test
	public void getAllJobTitles() {
		// Kinda Background step. Setting up given() and when() identifiers ---
		// !.when().get() because it is a GET request
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI2NDM1MDMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4Mjc1ODcwMywidXNlcklkIjoiMzc0In0.xm2u-a9W8PjBy7ZPtWIDFMZ9bQus5DJ8BUL0rHz0sIQ")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");

		// Printing out the response
		response.prettyPrint();

		// Status Code
		int actualStatusCode = response.getStatusCode();
		System.out.println("actualStatusCode: " + actualStatusCode);
	}

	//@Test
	public void getOneEmployee() {
		
		// !.when().get() because it is a GET request - Has a PARAM()
		Response response = RestAssured.given().param("employee_id", "3685").contentType("application/json").header(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI2NDM1MDMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4Mjc1ODcwMywidXNlcklkIjoiMzc0In0.xm2u-a9W8PjBy7ZPtWIDFMZ9bQus5DJ8BUL0rHz0sIQ")
				.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");

		response.prettyPrint();

		int actualStatusCode = response.getStatusCode();
		System.out.println("Status Code: " + actualStatusCode);
	}
	
	//@Test
	public void getAllEmployeeStatus() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI2NDM1MDMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4Mjc1ODcwMywidXNlcklkIjoiMzc0In0.xm2u-a9W8PjBy7ZPtWIDFMZ9bQus5DJ8BUL0rHz0sIQ")
				.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
		
		response.prettyPrint();
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: "+statusCode);

	}
	
	@Test
	public void createEmployee() {
		//POST request
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI2NDM1MDMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4Mjc1ODcwMywidXNlcklkIjoiMzc0In0.xm2u-a9W8PjBy7ZPtWIDFMZ9bQus5DJ8BUL0rHz0sIQ")
		.param("emp_firstname", "Tahir")
		.param("emp_lastname", "CAM")
		.param("emp_middle_name", "")
		.param("emp_gender", "1")
		.param("emp_birthday", "1995-08-21")
		.param("emp_status", "Employee")
		.param("emp_job_title", "Production Manager")
		.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(200, actualStatusCode);
	}
	

}
