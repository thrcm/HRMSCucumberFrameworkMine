Feature: Validating Syntax HRMS APIs

Background:
Given user generates token

@APITEST
Scenario: This test will check to see if an employee is created
Given user calls createEmployee API
When user retrieves response
Then status code is 200
Then user validates employee has been created
