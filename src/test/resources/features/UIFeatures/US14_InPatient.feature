@Smoketest
@US_0014_UI_InpatientResults
Feature: Test_Results_and_Inpatient_Feature
  @US_0014TC_0000
  Scenario: user is on the homepage
    Given Doctor is on home page
    And Doctor navigate to login page
    And Doctor clicks on My Pages dropdown
    And Doctor provide valid "senoler" and "senol123"
    And Doctor clicks on the sign in button
    And Doctor clicks on My Pages dropdown
    And Doctor clicks on My InpatientButton
    And Doctor changes the start and end days to see InPatient information
    Then Doctor should see and verify all InPatient information
    And Doctor clicks on Edit button for InPatients
    And Doctor can update all InPatient information
   And Doctor clicks on Edit button for InPatients
    And Doctor can especially update status of InPatient
    Then Doctor closes the driver