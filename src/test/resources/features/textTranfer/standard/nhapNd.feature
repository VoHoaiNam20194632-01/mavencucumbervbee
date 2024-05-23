Feature: Chuyển văn bản thành giọng nói với gói tiêu chuẩn
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Nhap tieu de "<tieude>"
    And Nhap van ban can chuyen doi dung thiet ke
    And chon giong doc
    And Chọn giong doc tieu chuan "<giongtieuchuan>"
    And toc do doc "<tocdo>", dinh dang audio"<audio>", nhac nen "<nhacnen>"
    And Click button chuyen van ban
    And Check ky tu tai khoan sau khi chuyen doi van ban
    Then Tai xuong audio voi vua chuyen van ban thanh cong

    Examples:
    | tieude       | giongtieuchuan                 | audio | tocdo | nhacnen |
    | test           |     HN - Anh Khôi voice     | mp3 | 1.5x       | bai1.mp3 |