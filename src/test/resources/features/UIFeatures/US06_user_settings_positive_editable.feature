@Smoketest
Feature: user_settings_editable positive feature

  Scenario Outline:settings page should be editable
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the login button
    Then user clicks on the account menu
    Then clicks on the settings button
    Then verify the settings page

    Examples: credentials
      | username      | password |
      | doctoraccount | 12345    |


  Scenario:first name should be editable
    Given user sends new firstname as "Rocky"
    Then clicks on the save button
    Then verify the result

  Scenario: last name should be editable
    Given user sends new lastname as "Balboa"
    Then  clicks on the save button
    Then verify the result

  Scenario: email should be editable
    Given user sends new email as "rockybalboaa@gmail.com"
    Then clicks on the save button
    Then verify the result