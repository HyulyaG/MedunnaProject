@user_settings_negative_editable
Feature: user_settings_editable negative feature

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


  Scenario:first name should not be editable for invalid credentials
    Given user sends new firstname as ""
    Then clicks on the save button
    Then verify the negative result for firstname

  Scenario: last name should not be editable
    Given user sends new lastname as ""
    Then  clicks on the save button
    Then verify the negative result for lastname

  Scenario: email should not be editable
    Given user sends new email as ""
    Then clicks on the save button
    Then verify the negative result for email

  Scenario: first name should not be editable for invalid credentials
    Given user sends new firstname as "1234"
    Then clicks on the save button
    Then verify the negative result for firstname

  Scenario: email should not be editable
    Given user sends new email as a String "alican.com"
    Then clicks on the save button
    Then verify the negative result for email as an invalid

  Scenario: email should not be editable
    Given user sends new email as a String "alican@.com"
    Then verify the negative result for email as an invalid

  Scenario: last name should not be editable
    Given user sends new lastname as "123456"
    Then  clicks on the save button
    Then verify the negative result for lastname

  Scenario: email should not be editable
    Given user sends new email as a String "alican@gmal.com"
    Then clicks on the save button
    Then verify the negative result for email as an invalid

  Scenario: email should not be editable
    Given user sends new email as a String "alican@deneme.com"
    Then clicks on the save button
    Then verify the negative result for email as an invalid


