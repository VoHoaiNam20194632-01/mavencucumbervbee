Feature: Add text And click on converted into voice button

#  Background:
#    Given user is on login page
#    When user enters vonam0561@gmail.com and 24081201Nam@
#    And confirm captcha
#    And click on login button
#    And click on studio button
#    And click No
#    Then user is navigated to the home page
@Add
  Scenario Outline: Add text
    When click on add text button and add <text>
    And click change format video button and click mpba button
    And click on converted into voice button
    And remove cancel

    Examples:
      |text|
      |vo hoai nam|
      |vo hoai nam codsa|
