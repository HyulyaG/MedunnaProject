#Admin can choose/search an existing registered person by SSN id
#Their info should be populated firstname, lastname birth date etc..
#Admin should provide a specialty for the Doctor
#Admin can provide a profile picture of the doctor
#Admin should choose the doctor among existing users
#Admin should provide the Exam fee of the doctor (earning amount)
#Admin can view all Physicians' info populated on view portal
#Admin can edit existing Physicians' info using new data
#Admin can delete existing Physicians

@Smoketest
@edit_physicians
Feature: Admin can search an existing registered person by SSN id

  Background:
    Given user is on landing page
    When user logs in as admin
    And clicks on items and titles dropdown
    And selects on Physician

  @navigate_to_physician_view_portal
  Scenario:TC01_search_existing_registered_physician
    Then verify user is on Physician view portal
    Then close the application

  @create_or_edit_physician
  Scenario: TC02_admin_can_edit_physician_data

    When user clicks on create new physician
    Then verify Create or edit a Physician title is visible
    And click on use search checkbox
    And enter SSN in the SSN textbox and click on search user button
    And edit firstname, lastname, birthdate
#    And provide specialty for the doctor
    And provide a phone number
    And choose a doctor among existing users
    And provide description
    And provide a profile picture for the physician
    And provide the exam fee
    And clicks on save button
    Then verify toast container
    Then close the application

  @all_physician_info
  Scenario: TC03_admin_can_view_all_Physicians_info_populated_on_view_portal

    Then verify user is on Physician view portal
    Then verify that ID,SSN, First Name, Last Name, Birth Date etc. is visible on view portal
    Then close the application






