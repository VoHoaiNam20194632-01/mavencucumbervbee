
Feature: feature  to test login functionality

  @login
  Scenario Outline: Login test pass
    Given user is on login page
    # truy cập trang đăng nhập
    When click Login GG button
    # click nút đăng nhập bằng gg
    And user enters "<username>" username
    # nhập tên đăng nhập
    And user enter "<password>"  password
    # nhập mật khẩu
    And click skip banner
#    # bỏ qua các banner quảng cáo
    Then user is navigated to the home page
#     người dùng truy cập vào AIVoice
    Examples:
      | username | password |
      | namvh@vbee.ai | 24081201Nam@ |