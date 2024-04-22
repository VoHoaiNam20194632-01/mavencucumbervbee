Feature: kiem tra goi dac biet

  Scenario Outline: kiem tra nguoi dung goi dacbiet dung voi yeu cau
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

  Scenario Outline: Kiem tra goi dac biet that bai do su dung qua dung luong
    Given user is navigated to the home page
    When click upload files "<files>" from computer
    And click on subtitle switch button
    Then hien thi banner nang cap

    Examples:
      | files |
