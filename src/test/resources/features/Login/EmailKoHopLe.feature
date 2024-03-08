Feature: Đăng ký người dùng

  Scenario Outline: Đăng ký thất bại do email không hợp lệ
    Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" khong hop le
    And confirm captcha
    And click Dang ky
    Then Hien thi thong bao Email khong hop le

    Examples:
