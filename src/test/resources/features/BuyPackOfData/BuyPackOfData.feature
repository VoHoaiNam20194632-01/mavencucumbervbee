Feature:  buy pack of data
  Background: Background:
    Given user is on login page
    When user enters vonam0561@gmail.com and 24081201Nam@
    And confirm capcha
    And click on login button
    And click on studio button
    And click x
    And click No
    Then user is navigated to the home page

#    Scenario: Check to see if there is an order
#      Given user is navigated to the home page
#      When click buy pack of data button
#      And click pack of data three months button
#      And click buy now button
@buy-data-pack
  Scenario: buy pack of data
      Given user is navigated to the home page
      When click buy pack of data button
      And click pack of data three months button
      And click buy now button
      And bo qua
      And Select payment bank
      And click change phone number button
      And Enter phone number and complete
      And click agree to pay button
      And click agree transfer button
#    Scenario: Cancel Data pack
#      Given user is navigated to the home page