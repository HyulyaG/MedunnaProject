@Smoketest
@US09_FullUI_Staff
Feature: Staff login
  @US09_TC005_StaffLogin
  Scenario Outline:TC005_Staff_Login
    Given user goes to the site
    And user clicks on the sign in button
    And user inserts the staff login credentials "<username>" and "<password>"
    And user clicks on the login button
    And user navigates to and clicks on the my pages tab
    And user clicks on the search patient button from teh dropdown to view all patients data
    When user clicks on the view button for second patient on the list
    Then user verifies patient information for the second patient on the list
    Then close the application


    Examples:
      |username|password|
      |MyStaffHyu|MyStaffHyu1990|
  @US09_TC006_StaffEdit
  Scenario:TC006_Staff_Edits
#        Continue from the above TC
    Given user clicks on the edit button for a patient
    And user updates all patient data
    And user saves the updated details
    When user click on the back button
    Then user verifies being on the all patients page
    Then close the application

  @US09_TC009_StaffSearchPatient
  Scenario: TC009_Staff_Searches_Patient
    Given user verifies the search box is visible
    And user inserts the patient SSN
    When user verifies the relevant patient is found
    Then close the application