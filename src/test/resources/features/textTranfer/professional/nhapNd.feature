Feature: Chuyển văn bản thành giọng nói với gói chuyên nghiệp
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Nhap tieu de "<tieude>"
    And Nhap van ban can chuyen doi dung thiet ke
    And chon giong doc
    And Chọn giong doc nuoc ngoai "<giongnuocngoai>"
    And toc do doc "<tocdo>", dinh dang audio"<audio>", nhac nen "<nhacnen>"
    And Click button chuyen van ban
    And Check ky tu tai khoan sau khi chuyen doi van ban
    Then Tai xuong audio voi vua chuyen van ban thanh cong

    Examples:
      | tieude       | giongnuocngoai               | audio | tocdo | nhacnen |
      | test           |     Antony voice     | mp3 | 1.5x       | bai1.mp3 |