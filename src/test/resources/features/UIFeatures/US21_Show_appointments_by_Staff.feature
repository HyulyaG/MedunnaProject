@staff_edit_appointment
Feature: Staff can edit patient appointment

  @appointment_edit
  Scenario Outline:TC001_Edit appointment by Staff
    When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    When user clicks my pages
    And user clicks search patient
    When user provides a valid ssn number into search box
      |ssn        |
      |252-93-3170|
    And user click show appointments button
    And user clicks edit button at the first appointment
    Then user verifies create and edit appointments page
    And user makes necessary updates and sets the status "<status>"
    And user click save button
    Then user clicks sign out button
    Then close the application


    Examples: Appointment data

      |firstName|lastName|ssn         | email        | phone    |date       |username|password|status|
      |Rickey     |Robel   |252-93-3179 |bryon.littel@gmail.com|1234567889| 17-01-2022|MyStaffHyu   |MyStaffHyu1990  |0|



#  @appointment_edit_completed
#  Scenario Outline:TC01_Edit appointment Staff
#
#    When User navigates to the home page
#    And user enters username "<username>" and password "<password>"
#    When user clicks my pages
#    And user clicks search patient
#    And user provides a valid ssn number into search box
#      |ssn        |
#      |252-93-3170|
#    And user click show appointments button
#    Then user verifies appointments page header
#    And user clicks edit button at the first appointment
#    Then user verifies create and edit appointments page
#    Then user verifies that completed option is disabled
#
#    Examples: Appointment data
#
#      |firstName|lastName|ssn         | email        | phone    |date       |username|password|
#      |Rickey     |Robel   |252-93-3179 |bryon.littel@gmail.com|1234567889| 17-01-2022|MyStaffHyu   |MyStaffHyu1990   |

  @staff_view_test_results
  Scenario Outline:TC03_Staff can view test results

    When User navigates to the home page
    And user enters username "<username>" and password "<password>"
    When user clicks my pages
    And user clicks search patient
    And user provides a valid ssn number into search box
      |ssn        |
      |252-93-3170|
    And user click show appointments button
    Then user verifies appointments page header
    And user clicks show tests for the given patient
    And user clicks view tests
    Then user verifies that test results are visible
    Then close the application

    Examples: Appointment data

      |username|password|
      |MyStaffHyu  |MyStaffHyu1990   |