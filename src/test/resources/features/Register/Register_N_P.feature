
Feature: feature  to test Register New functionality

  @login
  Scenario Outline: Register new test pass
    Given user is on home page
    # truy cập trang đăng nhập
    When click Login
    And click  register new
    # click nút đăng nhập bằng gg
    And user enters "<username>" username
    And user enter "<password>"  password
    And click  Register new button

    Examples:
      | username | password |
      | ntlena@gmail.com | 24081201Nam@ |