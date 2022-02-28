
Feature: password feature
  Scenario: password_should_be_secure

    Given user is on the main page
    And user clicks on sign in/register dropdown
    And user clicks on register button
    And user provides newPassword as "<newPassword>"
    And user confirms the newPassword as "<passwordConfirmation>"
