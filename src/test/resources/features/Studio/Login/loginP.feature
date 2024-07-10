
Feature: feature  to test login functionality
#  @login
  Scenario Outline: Login test pass
    Given user is on home page
    When click Login
    And user enters "<username>" username
    And user enter "<password>"  password
    And click Login button
    And click skip banner
    Then user is navigated to the home page
    Examples:
      | username | password |
      | namvh@vbee.ai | 24081201Na@ |