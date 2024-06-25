
  Feature: feature  to test login function
  @login
  Scenario Outline: Login test fail user name error
    Given user is on login page
    # truy cập trang đăng nhập
    When click Login GG button
    # click login bằng GG
    And user enters "<usernameerror>" username
    # nhập tên đăng nhập và mật khẩu
    Then Error message
    # hiện thị thông báo lỗi
    Examples:
      | usernameerror |
      | namvhvbee.ai |
    Scenario Outline: Login test fail password error
      Given user is on login page
     # truy cập trang đăng nhập
      When click Login GG button
     # click Login bằng gg
      And user enters "<username>" username
     # nhập email
      And user enter "<passworderror>"  password
     # nhập  mật khẩu
      Then Error message
      # hiện thị thông báo lỗi
      Examples:
        | username | passworderror |
        | namvh@vbee.ai | 24081201 |
