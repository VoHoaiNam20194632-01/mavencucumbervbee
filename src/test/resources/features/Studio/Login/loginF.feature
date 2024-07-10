
Feature: feature  to test login function
  @login
  Scenario Outline: Login test fail user name error
    Given user is on home page
    When click Login
    And user enters "<usernameerror>" username
    And click Login button
    Then Error message
    Examples:
      | usernameerror |
      | namvhvbee.ai |
  Scenario Outline: Login test fail password error
    Given user is on home page
    When click Login
    And user enters "<username>" username
    And user enter "<passworderror>"  password
    And click Login button
    Then Error message
    Examples:
      | username | passworderror |
      | namvh@vbee.ai | 24081201 |
