Feature: add reading and add text and music
  Scenario Outline: Add reading voice and add text, music
    Given user is navigated to the home page
    When click on music button
    And click select "<music>" music
    And click on accept music button
    When  click reading voice button
    And select "<gender>" gender
    And click select "<language>" language button
    And click select voice "<type>" type button
    And click select voice "<user>" user button
    When click on add text button and add <text>
    And click change "<format>" format video button
    And click on converted into voice button
    And remove cancel

    Examples:
      | gender | text | language | type | user | format | music|
      | male    | vo hoai nam| vi-VN| BASIC | SG - Trung Kiên voice | mp3 |Bad Ideas Distressed - Kevin MacLeod |
      | female | vo hoai nam nghệ an| vi-VN | BASIC | HN - Mai Phương voice | wav | Hat the Jazz - Twin Musicom |
      | female | vo hoai nam đô lương nghệ an| vi-VN | BASIC | Huế - Hương Giang voice | wav | Almost-Anxious |