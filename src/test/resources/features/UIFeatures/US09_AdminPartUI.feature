@Smoketest
@US09_FullUI_Admin
Feature: Admin login
  @US09_TC001_AdminLogin
  Scenario Outline: TC001_Admin_LogIn
    Given user goes to the site
    And user clicks on the sign in button
    And user inserts the admin login credentials "<username>" and "<password>"
    And user clicks on the login button
    And user navigates to and clicks on the item and title tab
    And user clicks on the patient button from teh dropdown to view all patients data
    When user clicks on the view button
    Then user verifies patient information
    Then close the application

    Examples: username and pass
      |username|password|
      |MyAdminHyu|MyAdminHyu1990|
  @US09_TC002_AdminEdit
  Scenario: TC002_Admin_Edits
#      Continue from the above TC
    Given user clicks on the edit button for a patient
    And user updates all patient data
    And user saves the updated details
    When user click on the back button
    Then user verifies being on the all patients page
    Then close the application

  @US09_TC010_AdminDelete
  Scenario: TC010_Admin_Deletes
#      Continue from the above TC
    Given user clicks on the delete button for a patient
    Then user deletes the user
    Then close the application
