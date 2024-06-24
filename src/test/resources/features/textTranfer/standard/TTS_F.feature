Feature: Text-to-speech with the standard package
  Scenario Outline: Text-to-speech conversion successful
    Given user is navigated to the home page
    And Enter a title "<title>"
    #nhap tieu de
    And Enter the text to convert
    #nhap noi dung van ban
    And Choose your reading voice
    #chon giọng đọc
    And Choose a foreign accent "<giongnuocngoai>"
    #chon giong doc nước ngoài
    And Show the upgrade banner now

    Examples:
      | title       | giongnuocngoai|
      | test           |Antony voice   |