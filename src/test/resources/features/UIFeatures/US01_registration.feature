#1.There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
#2.SSN cannot be left blank
#3.There should be a valid name that contains any chars and cannot be blank
#4.There should be a valid lastname that contains any chars and it is a required field
#5.Get all registrant information using swagger and validate them
#6.Create registrants using api and validate
#7.Validate registrant SSN ids with DB
@Smoketest
@US01_UIRegistration
Feature: Registration feature

  @AC1_positive_scenario
  Scenario Outline:TC01_user_should_be_give_valid_ssn
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate ssn is valid
    Then user creates the records to a correspondent file
    Then close the application


    Examples: User information
      |SSN|firstName|lastName|username|email|firstPassword|secondPassword|
      #|123-34-3455|Melek|Ahmed|MA |melekahmed@gmail.com|pass2343|pass2343|
        #|123-34-3458|Mel|Sam|MS |melsam@gmail.com|3452756|3452756|
        #|123-38-3455|Melike|Ahmed|MA |melikeahmed@gmail.com|pass2343|pass2343|
      |123-48-3455|Sam|Bob|SB |sambob@gmail.com|pass3848|pass3848|


  @AC1_negative_scenarios
  Scenario Outline:TC02_user_should_be_give_valid_ssn
    Given user is on the registration page
    And user enters invalid ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and see the error message as "<errorMessage>"
    Then user creates the records to a correspondent file
    Then close the application

    Examples: User information
      |SSN|firstName|lastName|username|email|firstPassword|secondPassword|
      |123343455|Melek|Ahmed|MA |melekahmed@gmail.com|pass2343|pass2343|
      |123_23_2346|Melek|Ahmed|MA |melekahmed@gmail.com|pass2343|pass2343|
      |123-53-765|Melek|Ahmed|MA |melekahmed@gmail.com|pass2343|pass2343|




  @AC2_blank_ssn
  Scenario Outline:TC01_ssn_can_not_be_blank
    Given user is on the registration page
    And user left empty ssn text box as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate error message "<errorMessage>"
    Then user creates the records to a correspondent file
    Then close the application

    Examples: User information
      |SSN|firstName|lastName|username|email|firstPassword|secondPassword|
      ||Melek|Ahmed|MA |melekahmed@gmail.com|pass2343|pass2343|

  @AC3_valid_first_name
  Scenario Outline: TC01 test valid firstname
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate
    Then user creates the records to a correspondent file
    Then close the application
    Examples:
      |SSN|firstName|lastName|username|email|password|
      |123-48-3455|Sam|Bob|SB |sambob@gmail.com|pass3848|

  @AC03_first_name_can't_blank
  Scenario Outline: TC02 test valid firstname
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters blank firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate error message
    Then user creates the records to a correspondent file
    Then close the application
    Examples:
      |SSN|firstName|lastName|username|email|password|
      |123-48-3455||Bob|SB |sambob@gmail.com|pass3848|



  @AC3_last_name_can't_blank
  Scenario Outline: TC01 test valid lastname
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate
    Then user creates the records to a correspondent file
    Then close the application
    Examples:
      |SSN|firstName|lastName|username|email|password|
      |123-48-3455|Sam|Bob|SB |sambob@gmail.com|pass3848|


  @AC3_valid_last_name
  Scenario Outline: TC01 test valid lastname
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and blank lastname as "<lastName>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the password as "<password>"
    And user clicks on the register button and validate error message
    Then user creates the records to a correspondent file
    Then close the application
    Examples:
      |SSN|firstName|lastName|username|email|password|
      |123-48-3455|Sam||SB |sambob@gmail.com|pass3848|