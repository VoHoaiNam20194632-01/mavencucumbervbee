Feature: Dang ky nguoi dung

  Scenario Outline: Dang ky thanh cong
     Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" hop le
    And confirm captcha
    And click Dang ky
    Then Hien thi thong bao Check email de xac nhan dang ky

    Examples:
    | email | password |
