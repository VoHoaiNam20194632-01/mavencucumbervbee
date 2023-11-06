#Author
#Date
#Description
@SmokeFeature
Feature: feature  to test login functionality

  @login
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And confirm capcha
    And click on login button
    And click on studio button
    And click x
    And click No
    Then user is navigated to the home page

    Examples:
      | username | password |
      | vonam0561@gmail.com | 24081201Nam@ |