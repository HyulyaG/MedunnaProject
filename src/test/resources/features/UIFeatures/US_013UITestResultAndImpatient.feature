@Smoketest
@US_0013UITestResultAndImpatient
Feature: Test_Results_and_Inpatient_Feature
  Background: user is on the homepage
    Given Doctor is on home page
    And Doctor navigate to login page
    And capture the screenshot
  @US_0013TC_0001
  Scenario Outline: Doctor_Should_Able_To_See_Test_Results
    Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And Doctor clicks on Edit for patient button
    And Doctor clicks on Show Test Result button
    And Doctor clicks on View Result button
    Then Doctor should see and verify all test information
    Then Doctor clicks on Sign out button
    And capture the screenshot
    Then Doctor clicks on Sign out button
    Then close the application
    Examples: Doctor see test results
      |username   |password|
      |doctorrecep|123Recep|
  @US_0013TC_0002
  Scenario Outline: Doctor_Should_Able_To_Request_Inpatient
    Given Doctor provide valid "<username>" and "<password>"
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My Appointments
    And Doctor clicks on Edit for patient button
    And Doctor clicks on Request Impatient button
#    Then Doctor Verifies message "InPatient request already done for this appointment"
    And capture the screenshot
    Then Doctor clicks on Sign out button
    Then close the application
    Examples: Doctor see test results
      |username   |password|
      |doctorrecep|123Recep|