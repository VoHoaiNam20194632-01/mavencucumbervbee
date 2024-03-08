Feature:  Add reading voice for text



  Scenario Outline: Add reading voice
    When user is navigated to the home page
    And  click reading voice button
    And select "<gender>" gender
    And click select voice "<type>" type button
    And click select voice "<user>" user button
    Then user is navigated to the home page

    Examples:
      | gender  | type | user |
      | male     | STANDARD | HN - Anh Khôi voice  |
      | female  | STANDARD | HN - Mạnh Dũng voice |
      | female | STANDARD | SG - Minh Hoàng voice |