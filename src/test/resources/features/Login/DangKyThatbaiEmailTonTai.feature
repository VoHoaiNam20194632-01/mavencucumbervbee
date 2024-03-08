Feature Outline: Đăng ký người dùng

  Scenario Outline: Đăng ký thất bại do email đã tồn tại
    Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" ton tai
    And confirm captcha
    And click Dang ky
    Then Hien thi thong bao Email da ton tai

    Examples:
    | email | password |



