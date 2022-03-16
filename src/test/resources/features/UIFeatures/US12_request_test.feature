#Doctor may request a test
#"Test should have following items as checkmark options; Glucose, Urea, Creatinine, Sodium
#Potassium, Total protein, Albumin, Hemoglobin"
@Smoketest
Feature: Doctor may request a test

  @request_test
  Scenario: TC01 request test

    Given user is on landing page
    And user logs in as a doctor
    And user navigates to my appointments page
    Then user verifies being on appointments page
    And user clicks on edit button
    Then user verifies being on Create or Edit an Appointment page page
    And user clicks on request a test button
    Then user verifies being on Test Items page

  @selection_test
  Scenario: TC02 user makes selections
    Given user is on landing page
    And user logs in as a doctor
    And user navigates to my appointments page
    Then user verifies being on appointments page
    And user clicks on edit button
    Then user verifies being on Create or Edit an Appointment page page
    And user clicks on request a test button
    And user selects the  Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin options
    And user clicks in save button
    Then user verifies the success message