Feature:  Add reading voice for text
#  Background:
#    Given user is on login page
#    When user enters vonam0561@gmail.com and 24081201Nam@
#    And confirm captcha
#    And click on login button
#    And click on studio button
#    And click No
#    Then user is navigated to the home page


  Scenario Outline: Add reading voice
    When  click reading voice button
    And select "<gender>" gender
    And click select "<language>" language button
    And click select voice "<type>" type button
    And click select voice "<user>" user button
    Then user is navigated to the home page

    Examples:
      | gender | language | type | user |
      | male    | vi-VN| BASIC | SG - Trung Kiên voice |
      | female |vi-VN| BASIC | HN - Mai Phương voice |
      |female |vi-VN| BASIC | HN - Mai Phương voice |