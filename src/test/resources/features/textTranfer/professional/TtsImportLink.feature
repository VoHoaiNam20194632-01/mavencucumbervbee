Feature: Chuyển văn bản thành giọng nói với gói chuyên nghiệp
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Enter a title "<title>"
    #nhap tieu de
    And Enter the link "<link>" to convert
    #nhap link cần chuyển đổi
    And Choose your reading voice
    #chon giọng đọc
    And Choose a foreign accent "<giongnuocngoai>"
    #chon giong doc nước ngoài
    And reading speed "<tocdo>", Format audio"<audio>", soundtrack "<nhacnen>"
    # chọn tốc độ đọc, định dạng audio, nhạc nền
    And Click button text transfer
    #click chuyển văn bản
    And Check the number of remaining characters
    # kiểm tra số ký  tự sau khi chuyển văn bản
    Then Download audio to your computer


    Examples:
      | title     |link  | giongnuocngoai             | audio | tocdo | nhacnen |
      | test          |https://vietnamnet.vn/xu-phat-14-nguoi-phu-nu-tap-yoga-giua-duong-o-thai-binh-2282359.html |      Antony voice      | mp3 | 1.5x       | bai1.mp3 |