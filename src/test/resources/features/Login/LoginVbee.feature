#Author
#Date
#Description
@SmokeFeature
Feature: feature  to test login functionality

  @login
  Scenario Outline: Login test pass
    Given user is on login page
    When user enters <username> and <password>
    And confirm captcha
    And click on login button
#    And click on studio button
    And click No
    Then user is navigated to the home page

    Examples:
      | username | password |
      | namvh@vbee.ai | 24081201Nam@ |