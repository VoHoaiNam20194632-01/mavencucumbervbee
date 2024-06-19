@SmokeFeature
  Feature:  Check momo payment information

    Scenario Outline: Buy the standard payment plan with momo
      Given user is navigated to the home page
      When  the user is accessing the package purchase page
      And selects month
      And the user selects the standard package
      And selects bank momo
      And "<giatrigoicuoc>" select voucher "<voucher>" giam tien

      Examples:
        |voucher              | giatrigoicuoc  |
        | 5k                  |199000|