@Smoketest
@ApiRegistrant
Feature: Registrant_api_test


  Scenario Outline: registrant Post test
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<username>" "<password>" and "<lan>"
    And  user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records


    Examples:
      |firstname|lastname|SSN|email|username|password|lan|
      |Melekber|  Ahmed | 388-11-4208|melekber@gmail.com  | M.Ahemd|Pass48. | en  |


  Scenario:  api get request for users
    Given user send the get request for users data
    And user deserialized data to Java
    And  user saves the users data to corespondent files
    Then user validates get request records

