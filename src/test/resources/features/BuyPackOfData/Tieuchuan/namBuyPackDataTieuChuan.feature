@SmokeFeature
Feature: Purchase Packagez

#  PHAN TRAM
  Scenario Outline: User purchases the standard package NAM và chọn voucher %
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    # chon tech hoặc vietcombank
    And "<giatrigoicuoc>" select voucher "<voucher>" phan tram and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua trang duyệt đơn và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoinamTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      | voucher |giatrigoicuoc| kyTuGoinamTieuChuan | nam | tengoi                     |
      | 5%     | 1539000| 3600000                          | 365  | Tiêu chuẩn - Năm |

#  GIAM TIEN
  Scenario Outline: User purchases the standard package NAM và chọn voucher GIAM TIEN
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    # chon tech hoặc vietcombank
    And "<giatrigoicuoc>" select voucher "<voucher>" giam tien and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua trang duyệt đơn và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoinamTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      | voucher |giatrigoicuoc| kyTuGoinamTieuChuan | nam | tengoi                     |
      | 5k      | 1539000 | 3600000                          | 365  | Tiêu chuẩn - Năm |

    #  TANG KY TU
  Scenario Outline: User purchases the standard package NAM và chọn voucher TANG KY TU
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    # chon tech hoặc vietcombank
    And "<giatrigoicuoc>" select voucher "<voucher>" tang ky tu and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua trang duyệt đơn và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoinamTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      | voucher| giatrigoicuoc| kyTuGoinamTieuChuan | nam | tengoi                     |
      | X2     | 1539000| 7200000                          | 365  | Tiêu chuẩn - Năm |