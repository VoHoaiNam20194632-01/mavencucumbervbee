Feature: Buy Package Failse
#  PHAN TRAM
  Scenario Outline: Buy Package Failse voucher error
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects month
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    #ramdom ngan hang
    And "<giatrigoicuoc>" select voucher "<voucher>" giam tien
#  thực hiện chon khuyen mai theo % và thanh toán(check giá gói cước ....)
    Then Shows an invalid code error message
    Examples:
      |voucher              | giatrigoicuoc  |
      |20K     |199000 |