Feature:  buy pack of data
#Background:
#Given user is on login page
#When user enters vonam0561@gmail.com and 24081201Nam@
#And confirm captcha
#And click on login button
#And click on studio button
#And click No
#Then user is navigated to the home page

@buy-data-pack
  Scenario Outline: buy pack of data
      When click buy pack of data button
      And click pack of data "<months>" months button
      And click buy now button
      And bo qua
      And Select payment bank
      And click change phone number button
      And Enter phone number and complete
      And click agree to pay button
      And click agree transfer button
    Examples:
    | months|
    | Gói 1 tháng |
    | Gói 3 tháng |
    | Gói năm     |



#    Scenario: Cancel Data pack
#      Given user is navigated to the home page