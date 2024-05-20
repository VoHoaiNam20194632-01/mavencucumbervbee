
@SmokeFeature
Feature: feature  to test login functionality

  @login
  Scenario Outline: Login test pass
    Given user is on login page
    # truy cập trang đăng nhập
    And user enters <username> and <password>
    # nhập tên đăng nhập và mật khẩu
    And confirm captcha
#    #xác nhận captcha
    And click on login button
#    # click nút đăng nhập
    And click No
#    # bỏ qua hướng dẫn
    Then user is navigated to the home page
#     người dùng truy cập vào AIVoice
    Examples:
      | username | password |
      | namvh@vbee.ai | 24081201Nam@ |