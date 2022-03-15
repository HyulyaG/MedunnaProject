#1. Choose a username that can contain any chars, but it cannot be blank
#2. username should be validated using api
#3. email id cannot be created without "@" sign and ".com" extension
#4. email cannot be left blank
#5. email should be validated with API and DB
@Smoke_test
@UIRegistration
@user_registration
Feature: registration feature

    @positive_username
  Scenario Outline: TC001 positive registration scenario with correct username
    Given user provides ssn id "<SSN>"
    And  user provides firstname and lastname "<firstname>" and "<lastname>"
    And user creates username "<username>"
    And user provides also email "<email>"
    And user generates the password "<password>"
    And user clicks on register
    And user validates
    Then user creates the records to a correspondent file
    Then close the application
    Examples: user credentials
      | SSN         | firstname | lastname | username   | email                    | password |
      | 844-11-1214 | John      | Nelson   | Joshua1990 | johwnyswt014@gmail.com | 12345!   |

  @blank_username
  Scenario: TC002 negative registration scenario with blank username
    Given user does not provide username
    And user clicks on register
    Then verify username is required  message

  @positive_email_scenario
  Scenario Outline: TC003 positive registration scenario with correct email format
    Given user provides ssn id "<SSN>"
    And  user provides firstname and lastname "<firstname>" and "<lastname>"
    And user creates username "<username>"
    And user provides also email "<email>"
    And user generates the password "<password>"
    And user clicks on register
    And user validates
    Then user creates the records to a correspondent file
    Then close the application
    Examples: user credentials
      |SSN       |firstname|lastname|username      |email                   |password|
      |840-11-7855|John     |Nelson  | Joshua1990   |johndyse014@gmail.com    | 12345!|
  @negative_email_scenario_1
  Scenario Outline: TC004 negative registration scenario with incorrect email format
    Given user provides wrong email "<email>"
    And user clicks on register
    Then verify error message
    Then close the application
    Examples: user credentials
      |email               |
      |johnyse014gmail.com |
  @blank_email
  Scenario: TC05 blank email
    Given user does not provide email
    And user clicks on register
    Then verify Your email is required. message is displayed
    Then close the application