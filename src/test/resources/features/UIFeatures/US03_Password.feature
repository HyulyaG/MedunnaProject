@Smoketest
Feature: Test registration password strength
  @Password_strength_check
  Scenario Outline: test password strength
    Given user is on registration page
    And user provides the password "<password>"
    Then user validates the password strength "<strength>"
    Then close the application

    Examples: test data
      |password|strength|
      |asdfgkdjs |1     |
      |qwertyU   |2     |
      |123456a   |2     |
      |ASDFGHq   |2     |
      |asdfgh1   |2     |
      |zxcvbn?   |2     |
      |zxcvbn@   |2     |
      |asdhgsag?1|3     |
      |asdfA1?   |4     |
      |asdfA1@   |4     |