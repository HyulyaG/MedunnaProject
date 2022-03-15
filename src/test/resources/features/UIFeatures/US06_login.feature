@Smoketest
Feature:admin should be login

  Scenario Outline:login_with_employee_credentials
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the login button
    Then verify the my page

    Examples: Credential
      | username     | password |
      | adminaccount | 12345    |


  @user_settings
  Scenario Outline: user_settings should be editable
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the login button
    Then user clicks on the account menu
    Then clicks on the settings button
    Then verify the settings page
    Then verify the same credentials
    And close the application


    Examples: credentials
      | username      | password |
      | doctoraccount | 12345    |