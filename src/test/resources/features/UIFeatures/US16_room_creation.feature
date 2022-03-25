@RoomForInpatient
Feature: Admin creates a room for inpatient
  Background:user goes to patient page
    Given user is on the homepage page
    And user clicks on login dropdown and selects the signIn button
    And user provides admin, password and clicks the submit button
    And user clicks on items_tittles dropdown and selects room

  @RoomCreationForPatient
  Scenario: Create_a_room_for_inpatient
    And user clicks on create a room button
    And user provides a room number
    And user selects a room type
    And user clicks the status checkbox
    And user provides the price
    And user writes a description
    And user provides the date for stay
    And user clicks the save button
    And user clicks on the signout button
    And user closes the page

  @RoomEditView
  Scenario: user_updates_the_patient_room_information
    Given user clicks on edit button for the selected patient
    And user updates all the information
    Given user clicks on the view button after edit
    #Then user validates that the room is created
    And user clicks on the signout button


  @NegativeTestWithPastDate
  Scenario: user_creates_a_room_past_date
    Given user clicks on create a room button
    And user creates a room with a past date

  @TestingInvalidMessageForRoomNumber
  Scenario: user_creates_a_room_with_nonnumerical_value
    Given user clicks on create a room button
    And user provides a nonnumerical room number
    Then user validates the invalid message