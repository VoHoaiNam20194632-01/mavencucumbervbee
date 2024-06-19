
Feature: feature  to test register function
  @login
  Scenario Outline: Register test fail user name error
    Given user is on register page
    # truy cập trang đăng nhập
    When click Register
    # click login bằng GG
    And user enters "<usernameerror>" username register
    # nhập tên đăng nhập và mật khẩu
    And click  Register button
    And Error message register
    # hiện thị thông báo lỗi
    Examples:
      | usernameerror |
      | nam@gmail.com |
  Scenario Outline: Register test fail password error
    Given user is on register page
     # truy cập trang đăng nhập
    When click Register
     # click Login bằng gg
    And user enters "<username>" username register
     # nhập email
    And user enter "<passworderror>"  password register
     # nhập  mật khẩu
    And user enter "<passworderror>"  password confirm register
    And click  Register button
    And Error message register
      # hiện thị thông báo lỗi
    Examples:
      | username | passworderror |
      | nam@ | 24081201 |
