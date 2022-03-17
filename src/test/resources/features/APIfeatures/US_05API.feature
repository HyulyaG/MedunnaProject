Feature: Appointment API test

  @US05Api_Appo_Post_Request
    Scenario Outline: appointment post request
    Given user sets the necessary path params for appointment creation
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<phone>"  and "<date>"
    And user sends the POST request and gets the response for appointment creation
    When user saves the appointment records to correspondent files
    Then user validates appointment records

    Examples: api test data
      | firstname | lastname | SSN         | email         | phone        | date       |
      | HB        | Kara     | 252-34-5565 | hbk@gmail.com | 123-444-4545 | 2022-11-12 |




  @US05Api_Appo_Get_Request
  Scenario: appointment get request

    Given user sends get request for appointment registration data
    And user deserializes data to Java
    And user validates records
