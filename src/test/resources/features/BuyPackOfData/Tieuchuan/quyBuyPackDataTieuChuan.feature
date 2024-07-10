@SmokeFeature
Feature: Buy Package
#  PHAN TRAM
  Scenario Outline: User purchases the standard package QUY và chọn voucher %
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    And "<giatrigoicuoc>" select voucher "<voucher>" phan tram and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
##  hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiQuyTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"

    Examples:
      | voucher            | giatrigoicuoc | kyTuGoiQuyTieuChuan | quy         | tengoi                    |
      | 5%       |520000| 900000                              | 90          |  Tiêu chuẩn - Quý |

#GIAM TIEN
  Scenario Outline: User purchases the standard package QUY và chọn voucher giam tien
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    And "<giatrigoicuoc>" select voucher "<voucher>" giam tien and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
##  hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiQuyTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"

    Examples:
      | voucher           | giatrigoicuoc | kyTuGoiQuyTieuChuan | quy         | tengoi                    |
      | 5k                | 520000 | 900000                              | 90          |  Tiêu chuẩn - Quý |

#TANG KY TU
  Scenario Outline: User purchases the standard package QUY và chọn voucher tang ky tu
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói tháng
    And the user selects the standard package
#  người dùng chọn gói cước tiêu chuẩn
    And ramdom bank
    And "<giatrigoicuoc>" select voucher "<voucher>" tang ky tu and pay
#  thực hiện chon khuyen mai và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
##  hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiQuyTieuChuan>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"

    Examples:
      | voucher            |giatrigoicuoc | kyTuGoiQuyTieuChuan | quy         | tengoi                    |
      | X2                 |520000 | 1800000                              | 90          | Tiêu chuẩn - Quý |