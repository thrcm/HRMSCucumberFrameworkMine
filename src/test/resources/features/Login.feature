#Author: Syntax Team (tahir.cam@bofa.com)
@sprint4,login
Feature: Login

  #shows common steps in each one of the Scenarios of the above Feature
  Background: 
    Given I open browser and navigate to HRMS.com

  @smoke
  Scenario: Valid Login
    When I put in valid username and valid password
    And I click on login button
    Then I successfully log in
    And I close the window

  @regression
  Scenario: Invalid Login
    When I put in valid username and invalid password
    And I click on login button
    Then I get error message
    And I close the window
