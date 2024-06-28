Feature: Buy Package
#  PHAN TRAM
  Scenario Outline: User buy the standard package month và chọn voucher %
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
    And "<giatrigoicuoc>" select voucher "<voucher>" phan tram and pay
#  thực hiện chon khuyen mai theo % và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua duyệt đơn hàng và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiThangTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <thang>
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher              | giatrigoicuoc  | kyTuGoiThangTieuChuan |thang       | tengoi|
      |10%     |199000 | 300000                                | 30            | Tiêu chuẩn - Tháng |