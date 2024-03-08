Feature: kiem tra goi chuyen nghiep

  Scenario Outline: kiem tra nguoi dung goi chuyen nghiep dung voi yeu cau
    Given user is navigated to the home page
    When click upload files "<files>" from computer
    And click reading voice button
    And select "<gender>" gender
    And click select voice "<type>" type button
    And click select voice "<user>" user button
    And click on subtitle switch button
    Then khong hien thi banner ngang cap
    Examples:
      | files | gender | type | user |
      | pass.srt | male | STANDARD | HN - Anh Khôi voice |

  Scenario Outline: Kiem tra goi chuyen nghiep that bai do su dung qua dung luong
    Given user is navigated to the home page
    When click upload files "<files>" from computer
    And click on subtitle switch button
    Then hien thi banner nang cap

    Examples:
      | files |
    | test120.srt |