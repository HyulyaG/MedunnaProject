@Smoketest
Feature: New customers (patients) should make appoinment to processed in hospital
  Background:
    Given user navigates to medunna login page
    And user clicks on make an appointment button
  @US_05_01
  Scenario Outline: Happy scenario
    And user provides the first name as "<firstName>" with valid credentials
    And user provides the last name as "<lastName>" with valid credentials
    And user provides the SSN as "<SSN>" with valid credentials
    And user provides the email as "<email>" with valid credentials
    And user provides the phone number as "<phoneNumber>" with valid credentials
    And user provides the date "<date>"
    Then user sends an appointment request.
    Then There should be Success message.
    And sign in the app with the provided "<username>" and "<password>"
    Then verify the appointment
    Examples: Test Data
      | firstName | lastName | SSN         | email             | phoneNumber  | date       | username   | password   |
      | Hasan     | Komur    | 523-89-8315 | hasan@kara.com    | 333-444-5555 | 21-06-2034 | hasankomur | 1211402301 |
      | Okkes     | Niyazi   | 158-13-2326 | okkes@abi.com     | 333-442-3334 | 01-04-2049 | okkesniyaz | 1211402301 |
      | Mustafa   | Aga      | 523-22-3234 | Mustafa@gmail.com | 343-232-2222 | 01-04-2023 | Fatihbey   | fatih123   |
  @US_05_02
  Scenario Outline: Negative scenario
    And user provides invalid first name as "<firstName>"
    Then user verifies fail message of first name
    And user provides invalid last name as "<lastName>"
    Then user verifies fail message of last name
    And user provides invalid SSN name as "<SSN>"
    Then user verifies fail message of SSN
    And user provides invalid email as "<email>"
    Then user verifies fail message of email
    And user provides invalid phone number as "<phoneNumber>"
    Then user verifies fail message of phone number
    Then user data will be created
    Examples: Test Data
      | firstName | lastName | SSN             | email         | phoneNumber   |
      |           |          | 12-31*-023-2311 | Ferhat@asdcom | 211412        |
      |           |          | 123445          | alican.com    | 211-333-41234 |
      |           |          | 5-55-55-555     | laz@ziyacom   | 7181-123-44   |