@Smoketest
Feature: admin can delete physician

  @delete_physician
  Scenario: TC01_delete_physician
    Given user is on landing page
    When user logs in as admin
    And clicks on administration dropdown
    And clicks on user management
    Then verify user is on user management page
    And user clicks on the delete button
    And user confirms delete operation
    Then verify physician is deleted message