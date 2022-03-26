@Smoketest

Feature: Login feature


  @user_login
  Scenario: positive_login
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |MyUserHyu        |MyUserHyu1990    |
    And user clicks on the login button
    Then verify the login is successful
    Then close the application

  @invalid_username
  Scenario: negative_login
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |Azize        |MyUserHyu1990     |
    And user clicks on the login button
    Then close the application

  @invalid_password
  Scenario: negative_login2
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |MyUserHyu        |azize     |
    And user clicks on the login button
    Then close the application

  @cancel_login
  Scenario: cancel_login
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |MyUserHyu        |MyUserHyu1990     |
    And user clicks on the cancel button
    Then close the application

  @remember_me
  Scenario: remember_me
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |MyUserHyu        |MyUserHyu1990     |
    And user clicks on remember me box
    And user clicks on the login button
    Then verify the login is successful
    Then close the application

  @update_password
  Scenario: update_password
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    Then user clicks on the forget password button
    Then close the application

  @register_click
  Scenario: register_click
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on register button
    Then close the application
