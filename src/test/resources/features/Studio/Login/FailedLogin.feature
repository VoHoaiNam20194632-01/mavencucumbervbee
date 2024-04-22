
Feature: User Login

  Scenario Outline: User enters invalid username
    Given user is on login page
    When the user enters an invalid "<username>" username
#  người dùng nhập tên đăng nhập không hợp lệ
    And enters a valid "<password>" password
#  nhập mật khẩu hợp lệ
    And confirm captcha
    And click on login button
    Then an error message should be displayed
#  thông báo lỗi sẽ được hiển thị
    And the user should not be logged in
#  người dùng sẽ không được đăng nhập

    Examples:
      | username | password |
      | nam@vbee.ai | 24081201Nam@ |

  Scenario Outline: User enters invalid password
    Given user is on login page
    When the user enters a valid username "<username>"
#  Khi người dùng nhập tên đăng nhập hợp lệ
    And enters an invalid password "<password>"
#  Và nhập mật khẩu không hợp lệ
    And confirm captcha
    And click on login button
    Then an error message should be displayed
    And the user should not be logged in

    Examples:
      | username | password |
      | namvh@vbee.ai | 24081201Nam |


  Scenario Outline: User leaves username and password fields empty
    Given user is on login page
    When the user leaves the username "<username>" field and password "<password>"field empty
#  người dùng để trống cả Tên đăng nhập và Mật khẩu
    And confirm captcha
    And click on login button
    Then an error message should be displayed
    And the user should not be logged in

    Examples:
      | username | password |
      |  |  |