
  Feature: feature  to test login function
  @login
  Scenario Outline: Login test fail user name error GG
    Given user is on login page gg
    # truy cập trang đăng nhập
    When click Login GG button
    And user enters "<usernameerror>" username gg
    # nhập tên đăng nhập và mật khẩu
    Then Error message gg
    # hiện thị thông báo lỗi
    Examples:
      | usernameerror |
      | namvhvbee.ai |
    Scenario Outline: Login test fail password error GG
      Given user is on login page gg
     # truy cập trang đăng nhập
      When click Login GG button
     # click Login bằng gg
      And user enters "<username>" username gg
     # nhập email
      And user enter "<passworderror>"  password gg
     # nhập  mật khẩu
      Then Error message gg
      # hiện thị thông báo lỗi
      Examples:
        | username | passworderror |
        | namvh@vbee.ai | 24081201 |
