Feature: Buy an invoice package
  Scenario Outline: User buy the standard package month và chọn voucher % and invoice
    Given user is navigated to the home page
    When the user is accessing the package purchase page
    And Get the initial number of characters the account has
    And selects month
    And the user selects the standard package
    And ramdom bank
    And "<giatrigoicuoc>" select voucher "<voucher>" giam tien
#    And  Click the invoice button
