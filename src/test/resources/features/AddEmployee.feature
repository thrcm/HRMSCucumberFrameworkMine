#Author: syntax team (asel@syntaxtechs.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @smoke
  Scenario: Add new Employee
  When I add "John", "S" and "Smith"
  And I click Save
  Then I see Employee has been succesfully added
  
  @regression
  Scenario Outline: Add new Employee
  When I add "<FirstName>", "<MiddleName>" and "<LastName>"
  And I click Save
  Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed
  
  Examples:
  | FirstName | MiddleName | LastName |
  | James     |            | Smith    |
  | Jane      | J          | Smith    |
  | Sasha     | J          | Smith    |
  | David     | J          | Smith    |
  
  @regression
  Scenario Outline: Add Employee without employee id
  When I add "<FirstName>", "<MiddleName>" and "<LastName>"
  And I delete employee id
  And I click Save
  Then I see employee "<FirstName>", "<MiddleName>" and "<LastName>" without employee id is being added
  
  Examples:
  | FirstName  | MiddleName | LastName |
  | Abdulkadir | Tahir      | CAM      |
  | Seha       |            | Ozdemir  |
  
  
  ##2.Way of Parameterezation: Datatable. Instead of running background test steps each time for each row of data,
  ##we can execute each step as many times as row in datatable (will not run background steps each time)
  @inProgress
  Scenario: Add and Modify Employee Details
    When I enter Employee Details
      | FirstName  | MiddleName | LastName | EmployeeID|
      | AbdulkadiR | Tahi23    | CAM      | 8353993227|
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | N78787886     | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Other         | Afghan      | 1980-10-10 |
      | Nuy89889800   | 2018-12-08     | yiy-45-6789 | uyiy    | Female | Married       | Burmese     | 1980-10-10 |
    Then I click on save
