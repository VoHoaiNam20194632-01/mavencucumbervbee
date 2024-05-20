Feature: Chuyển văn bản thành giọng nói với gói chuyên nghiệp
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Nhap tieu de "<tieude>"
    And Nhap file "<file>"can chuyen doi
    And chon giong doc
    And Chọn giong doc nuoc ngoai "<giongnuocngoai>"
    And toc do doc "<tocdo>", dinh dang audio"<audio>", nhac nen "<nhacnen>"
    And Click button chuyen van ban
    Then Tai xuong audio voi vua chuyen van ban thanh cong

    Examples:
      | tieude      | file | giongnuocngoai               | audio | tocdo | nhacnen |
      | test          | chuyennghiep |     Antony voice     | mp3 | 1.5x       | Wanting-And-Becoming-A-Director |