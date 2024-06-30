Feature: Chuyển văn bản thành giọng nói với gói chuyên nghiệp
  Scenario Outline: Chuyển văn bản thành giọng nói thành công
    Given user is navigated to the home page
    And Enter a title "<title>"
    #nhap tieu de
    And Enter the file "<file>" to convert
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
      | title     | file | giongnuocngoai               | audio | tocdo | nhacnen |
      | test          | chuyennghiep |     Antony voice     | mp3 | 1.5x       | bai1.mp3|