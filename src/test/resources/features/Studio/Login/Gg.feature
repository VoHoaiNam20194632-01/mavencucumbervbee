@SmokeFeature
Feature: feature  to test login functionality

  @login
  Scenario: Login test pass
    Given user is on login page
    And  dang nhap bang gg
    And click No
    Then user is navigated to the home page
