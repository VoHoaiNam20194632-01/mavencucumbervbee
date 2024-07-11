@SmokeFeature
Feature: Buy Package
#  PHAN TRAM
  Scenario Outline: User purchases theo Dac Biet package  NAM và chọn voucher %
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
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
    And Check the added character after purchasing the package"<kyTuGoiNamDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher             | giatrigoicuoc   | kyTuGoiNamDacBiet        |nam     | tengoi|
      |5%          | 7690000 | 12000000                            | 365            | Đặc biệt - Năm |

#    GIAM TIEN
  Scenario Outline: User purchases the Dac biet package NAM và chọn voucher GIAM TIEN
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
    And Check cancel order
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
    And Check the added character after purchasing the package"<kyTuGoiNamDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher             | giatrigoicuoc     | kyTuGoiNamDacBiet    | nam     | tengoi                         |
      | 5K                 |7690000 | 12000000                        | 365       | Đặc biệt - Năm |

#    TANG KY TU
  Scenario Outline: User purchases the Dac biet package NAM và chọn voucher TANG KY TU
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the special package
#  người dùng chọn gói cước đặc biệt
    And Check cancel order
    And ramdom bank
    #ramdom ngan hang
    And "<giatrigoicuoc>" select voucher "<voucher>" tang ky tu and pay
#  thực hiện chon khuyen mai theo % và thanh toán(check giá gói cước ....)
    And Switch to the payment history page
##chuyen sang trang lich su thanh toan
    And the system displays a successful purchase confirmation
## chuyển qua duyệt đơn hàng và hệ thống hiển thị xác nhận mua thành công
    And return to home page
    # Quay về trang chủ
    And Check the added character after purchasing the package"<kyTuGoiNamDacBiet>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                |giatrigoicuoc  | kyTuGoiNamDacBiet    | nam | tengoi                         |
      | X2                    |7690000|24000000                         | 365        | Đặc biệt - Năm |