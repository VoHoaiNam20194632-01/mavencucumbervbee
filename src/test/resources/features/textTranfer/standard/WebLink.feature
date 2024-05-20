Feature: Chuyển văn bản thành giọng nói với gói tiêu chuẩn
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Nhap tieu de "<tieude>"
    And Nhap link "<link>" can chuyen doi
    And chon giong doc
    And Chọn giong doc tieu chuan "<giongtieuchuan>"
    And toc do doc "<tocdo>", dinh dang audio"<audio>", nhac nen "<nhacnen>"
    And Click button chuyen van ban
    And Check ky tu tai khoan sau khi chuyen doi van ban
    Then Tai xuong audio voi vua chuyen van ban thanh cong

    Examples:
      | tieude     |link  | giongtieuchuan                 | audio | tocdo | nhacnen |
      | test          |https://vietnamnet.vn/xu-phat-14-nguoi-phu-nu-tap-yoga-giua-duong-o-thai-binh-2282359.html |     HN - Anh Khôi voice     | mp3 | 1.5x       | Wanting-And-Becoming-A-Director |