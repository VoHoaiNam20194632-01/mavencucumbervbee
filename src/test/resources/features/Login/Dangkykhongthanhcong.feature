Feature:  Dang ky khong thanh cong

Scenario Outline: Đăng ký thất bại do email không hợp lệ
Given The user opens the browser and visits the registration page
When Nhap thong tin email "<email>" va password "<password>" khong hop le
And confirm captcha
And click Dang ky
Then Hien thi thong bao Email khong hop le

Examples:

  Scenario Outline: Đăng ký thất bại do email đã tồn tại
    Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" ton tai
    And confirm captcha
    And click Dang ky
    Then Hien thi thong bao Email da ton tai

    Examples:
      | email | password |

  Scenario Outline: Kiểm thử trường Email
    Given  The user opens the browser and visits the registration page
    When Nhap thong tin voi truong Email <"email"> trong
    And Di chuyen sang truong khac
    Then Hien thi thong bao Email khong duoc de trong

    Examples:
      | email |


  Scenario Outline: Kiểm thử trường Mật khẩu
    Given The user opens the browser and visits the registration page
    When Nhap password "<password>" chua dung
    And Di chuyen sang truong khac
    Then Hien thi thong bao "It nhat 8 ky tu toi da 100 ky tu bao gom chu hoa chu thuong so"

    Examples:
      | password |

  Scenario Outline: Kiểm thử Captcha chưa được xác nhận
    Given The user opens the browser and visits the registration page
    When Nhap thong tin email "<email>" va password "<password>" hop le
    And Captcha chưa được xác nhận
    And click Dang ky
    Then Hien thi thong bao Ban can xac nhan Captcha

    Examples: