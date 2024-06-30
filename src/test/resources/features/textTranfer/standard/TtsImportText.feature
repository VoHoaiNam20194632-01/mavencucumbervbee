Feature: Text-to-speech with the standard package
  Scenario Outline: Text-to-speech conversion successful
    Given user is navigated to the home page
    And Enter a title "<title>"
    #nhap tieu de
    And Enter the text to convert
    #nhap noi dung van ban
    And Choose your reading voice
    #chon giọng đọc
    And Choose a standard reading voice "<standard reading>"
    #chon giong doc tieu chuan
    And reading speed "<tocdo>", Format audio"<audio>", soundtrack "<nhacnen>"
    # chọn tốc độ đọc, định dạng audio, nhạc nền
    And Click button text transfer
    #click chuyển văn bản
    And Check the number of remaining characters
    # kiểm tra số ký  tự sau khi chuyển văn bản
    Then Download audio to your computer
    # tải audio xuống

    Examples:
    | title       | standard reading             | audio | tocdo | nhacnen |
    | test           |     HN - Anh Khôi voice     | mp3 | 1.5x       | SauConMua.mp3 |