Feature: Lely FE website scenarios

  Scenario Outline: Search button and functionality control
    Given User go to homepage
    And User click acceptCookiesButton
    And User click topPageSearchButton
    And User check searchArea is opened
    And User enter <key> into searchBoxField
    And User click searchButton
    Then User check resultSearchArea have <key>

    Examples:
    |key  |
    |happy|
    |cow  |

    Scenario: Technical page and documents control
      Given User go to homepage
      And User click acceptCookiesButton
      And User go to link techdocs
      And User click findDocDropDownButton
      And User select drop down from dropDownList - LUNA EUR
      And User scroll to catalogs
      And User check catalog have LUNA EUR
      And User click first_viewThisDocument
      And User switch the tab
      And User check the new tab is file opened
      And User switch the tab
      And User click second_DocDownloadBut
      Then User check the file is downloaded
