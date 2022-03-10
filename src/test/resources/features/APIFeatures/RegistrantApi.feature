Feature: Registrant api test

  @ApiRegistrant
  Scenario Outline: registrant test
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" and "<lan>"
    And user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records

    Examples: API test data
    |firstname|lastname|SSN|email|username|password|lan|
    |Hyulya    |Gyuler  |299-38-2938|hyulya@gmail.com|hyulyagyuler|Hyulya123.|en|



