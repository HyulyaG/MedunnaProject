Feature: Registrant api test


  @ApiRegistrant
  Scenario Outline: registrant test
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" and "<lan>"
    And user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records

    Examples: api test data
      |firstname|lastname|SSN|email|username|password|lan|
      |Azize    |Cholak  |293-38-3534|azize@gmail.com|Acholak|Recep123.|en|

    Scenario: api get request
      Given users get the patients list
