Kịch bản 4: Kiểm thử validate trường Email và Mật khẩu

Feature: Kiểm thử validate trường Email và Mật khẩu

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