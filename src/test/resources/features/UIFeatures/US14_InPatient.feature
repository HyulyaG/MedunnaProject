@Smoketest
@US_0014UITestResultAndInpatient
Feature: Test_Results_and_Inpatient_Feature

  Background: user is on the homepage

  Scenario Outline: Doctor should be able to be at inPatientPage
    Given Doctor is on home page
    And Doctor navigate to login page
    And Doctor clicks on My Pages dropdown
    Given Doctor provide valid "<username>" and "<password>"
   #And capture the screenshot
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown

    Examples: Doctor login inPatient page
      | username | password |
      | senoler  | senol123 |

  @US_0014TC_0001
  Scenario: Doctor should be able to see all inPatient information
    Given Doctor clicks on My InpatientButton
    And Doctor changes the start and end days to see InPatient information
    Then Doctor should see and verify all InPatient information
    #Then Doctor clicks on Sign out button
    #And capture the screenshot

  @US_0014TC_0002
  Scenario: Doctor should be able to update all inPatient information such as ID,
  start and end dates, description, created date, appointment id, status, room and patient
    Given Doctor clicks on Edit button for InPatients
    Then Doctor can update all InPatient information
    #Then Doctor clicks on Sign out button
    #And capture the screenshot

  @US_0014TC_0003
  Scenario: Doctor should be able to update Status to UNAPPROVED,DISCHARGED, STAYING or CANCELLED
    Given Doctor clicks on Edit button for InPatients
    And Doctor can especially update status of InPatient
    Then Doctor closes the driver