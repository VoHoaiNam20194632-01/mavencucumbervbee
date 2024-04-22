Feature: Kiểm thử Captcha

  Scenario Outline: Kiểm thử Captcha chưa được xác nhận
    Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" hop le
    And Captcha chưa được xác nhận
    And click Dang ky
    Then Hien thi thong bao Ban can xac nhan Captcha

    Examples: