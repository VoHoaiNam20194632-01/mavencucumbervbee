
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
    And Check cancel order
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
    |5%     |199000 | 300000                                | 30            | Tiêu chuẩn - Tháng |

#    GIAM TIEN
  Scenario Outline: User purchases the standard package month và chọn voucher GIAM TIEN
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
    And "<giatrigoicuoc>" select voucher "<voucher>" giam tien and pay
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
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher              | giatrigoicuoc  | kyTuGoiThangTieuChuan | thang | tengoi |
      | 5k                  |199000| 300000                                | 30       | Tiêu chuẩn - Tháng |

#    TANG KY TU
  Scenario Outline: User purchases the standard package month và chọn voucher TANG KY TU
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
    And "<giatrigoicuoc>" select voucher "<voucher>" tang ky tu and pay
#  thực hiện chon khuyen mai tang ky tu và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
#chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
# chuyển qua duyệt đơn hàng và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiThangTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <thang>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher             | giatrigoicuoc   | kyTuGoiThangTieuChuan | thang | tengoi |
      | X2                 | 199000  | 600000                                | 30       | Tiêu chuẩn - Tháng |