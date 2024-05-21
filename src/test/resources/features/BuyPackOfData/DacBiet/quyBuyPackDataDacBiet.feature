@SmokeFeature
Feature: Purchase Package
#  PHAN TRAM
  Scenario Outline: User purchases the d package  month và chọn voucher %
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói quý
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
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
    And Check the added character after purchasing the package"<kyTuGoiQuyDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                |giatrigoicuoc | kyTuGoiQuyDacBiet        |quy       | tengoi|
      |5%                     |2049000 | 3000000                            | 90            | Đặc biệt - Quý |

#    GIAM TIEN
  Scenario Outline: User purchases the standard package month và chọn voucher GIAM TIEN
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói quý
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
    And ramdom bank
    #ramdom ngan hang
    And select voucher "<voucher>" giam tien and pay
#  thực hiện chon khuyen mai theo % và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua duyệt đơn hàng và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiQuyDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                  | kyTuGoiQuyDacBiet    | quy     | tengoi                         |
      | 5K  | 3000000                        | 90       | Đặc biệt - Quý |

#    TANG KY TU
  Scenario Outline: User purchases the standard package month và chọn voucher TANG KY TU
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects quy
#    chọn gói quý
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
    And ramdom bank
    #ramdom ngan hang
    And select voucher "<voucher>" tang ky tu and pay
#  thực hiện chon khuyen mai theo % và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua duyệt đơn hàng và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiQuyDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <quy>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                  | kyTuGoiQuyDacBiet    | quy | tengoi                         |
      | X2  |6000000                         | 90       | Đặc biệt - Quý |