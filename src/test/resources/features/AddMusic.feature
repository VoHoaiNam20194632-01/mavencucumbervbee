Feature:  Add background music to the text
#  Background:
#    Given user is on login page
#    When user enters vonam0561@gmail.com and 24081201Nam@
#    And confirm capcha
#    And click on login button
#    And click on studio button
#    And click No
#    Then user is navigated to the home page

  Scenario: Add background music
      When click on music button
      And select music
      And click on accept music button
      Then has been completed background music