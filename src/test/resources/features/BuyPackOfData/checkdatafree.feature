
  Feature: check goi cuoc mien phi dung vơi yeu cau:  chon giong tieu chuan thanh cong, tai file len be hon 10 phut, chuyen duoc phu de

    Scenario Outline: check data free thanh cong
      Given user is navigated to the home page
      And click upload files "<files>" from computer
      And click reading voice button
      And select "<gender>" gender
      And click select voice "<type>" type button
      And click select voice "<user>" user button
      And click on subtitle switch button
      Then khong hien thi banner ngang cap

      Examples:
      | files |  gender| type | user|
      | pass.srt | male     | STANDARD | HN - Anh Khôi voice  |

      Scenario Outline: check data free that bai chon giong doc cao cap
        Given user is navigated to the home page
        And click reading voice button
        And select "<gender>" gender
        And click select voice "<type>" type button
        And click select voice "<user>" user button
        Then hien thi banner nang cap
        Examples:
           |gender| type | user|
          | male     | PREMIUM | SG - Chí Đạt voice |

        Scenario Outline: check data free that bai do qua thoi luong su dung
          Given  user is navigated to the home page
          And click upload files "<files>" from computer
          And click on subtitle switch button
          Then hien thi banner nang cap
          Examples:
          | files |
          | test120.srt |
