Feature:  Add reading voice for text
#  Background:
#    Given user is on login page
#    When user enters vonam0561@gmail.com and 24081201Nam@
#    And confirm capcha
#    And click on login button
#    And click on studio button
#    And click No
#    Then user is navigated to the home page


  Scenario: Add reading voice
    When  click reading voice button
    And click select gender male button
    And click select language Viet Nam button
    And click select voice type standard button
    And click select voice user button
    Then has been completed add reading voice