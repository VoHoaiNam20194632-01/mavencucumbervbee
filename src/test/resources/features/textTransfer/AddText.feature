@SmokeFeature
Feature: feature  to test dubbing  functionality

  @dubbing
  Scenario Outline: Dubbing test
    Given user is navigated to the home page
    When click upload files "<files>" from computer
    And click on subtitle switch button

    Examples:
      | files |
      | testdubbing.srt |
      | testdubbing.srt |

