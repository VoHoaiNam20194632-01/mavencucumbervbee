
Feature: feature  to test Register functionality

  @login
  Scenario Outline: Register test pass
    Given user is on register page
    # truy cập trang đăng nhập
    When click Register
    # click nút đăng ky bằng gg
    And user enters "<username>" username register
    # nhập tên đăng ky
    And user enter "<password>"  password register
    And user enter "<password>"  password confirm register
    # nhập mật khẩu
    And click  Register button
#     người dùng truy cập vào AI oice
    Examples:
      | username | password |
      | ntlena@gmail.com | 24081201Nam@ |