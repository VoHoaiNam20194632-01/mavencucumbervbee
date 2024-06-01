@SmokeFeature
Feature: Purchase Package
#  PHAN TRAM
  Scenario Outline: User purchases CHUYEN NGHIEP package  NAM và chọn voucher %
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the professional package
#  người dùng chọn gói cước chuyên nghiệp
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
    And Check the added character after purchasing the package"<kyTuGoiNamChuyenNghiep>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                | giatrigoicuoc | kyTuGoiNamChuyenNghiep       |nam     | tengoi|
      |5%                     | 3799000  | 6000000                            | 365           | Chuyên nghiệp - Năm|

#    GIAM TIEN
  Scenario Outline: User purchases CHUYEN NGHIEP package NAM và chọn voucher GIAM TIEN
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the professional package
#  người dùng chọn gói cước chuyên nghiệpk
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
    And Check the added character after purchasing the package"<kyTuGoiNamChuyenNghiep>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                |giatrigoicuoc  | kyTuGoiNamChuyenNghiep    | nam     | tengoi                         |
      | 5K                    |3799000 | 6000000                        | 365       | Chuyên nghiệp - Năm |

#    TANG KY TU
  Scenario Outline: User purchases CHUYEN NGHIEP package NAM và chọn voucher TANG KY TU
    Given user is navigated to the home page
    When the user is accessing the package purchase page
#  người dùng đang truy cập trang mua gói cước
    And Get the initial number of characters the account has
    #Lấy số ký tự ban đầu tài khoản có
    And selects nam
#    chọn gói năm
    And the user selects the professional package
#  người dùng chọn gói cước chuyên nghiep
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
    And Check the added character after purchasing the package"<kyTuGoiNamChuyenNghiep>"
    # kiểm tra ký tự cộng vào sau khi mua gói
    And check han su dung <nam>
#    And check ten goi cuoc
    And check ten goi cuoc sau khi mua "<tengoi>"
    Examples:
      |voucher                |giatrigoicuoc  | kyTuGoiNamChuyenNghiep   | nam | tengoi                         |
      | X2                    |3799000  |12000000                         | 365        | Chuyên nghiệp - Năm |