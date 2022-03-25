@US_08_user_password_segment
Feature: employee login password update

  Background: login_with_user_credentials

  Scenario: user is on the password page
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id "gokhandogan" and admin_password "12345"
    And user clicks on the login button
    And verify the login is successful
    And user clicks on account menu on the account page
    Then user clicks on Password button


  @US08_TC_0001_for_stronger_password_one_LOWERCASE
  Scenario Outline: for stronger password adding one LOWERCASE character
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is one
    And user add character " <add character>" to new password part
    And user verifies the password strength bar is two


    Examples:
      | new password | add character |
      | 1234567      | a             |

  @US08_TC_0002_for_stronger_password_one_UPPERCASE
  Scenario Outline: for stronger password adding one UPPERCASE character
    And user cleans the new password part
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is two
    And user add character " <add character>" to new password part
    And user verifies the password strength bar is four


    Examples:
      | new password | add character |
      | 123456a      | C             |

  @US08_TC_0003_for_stronger_password_one_DIGIT
  Scenario Outline: for stronger password adding one DIGIT character
    And user cleans the new password part
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is four
    And user add character " <add character>" to new password part
    And user verifies the password strength bar is five

    Examples:
      | new password | add character |
      | qazwsX!      | 5             |

  @US08_TC_0004_for_stronger_password_one_SPECIAL_character
  Scenario Outline: for stronger password adding one SPECIAL character
    And user cleans the new password part
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is two
    And user add character " <add character>" to new password part
    And user verifies the password strength bar is four

    Examples:
      | new password | add character |
      | 12345xy      | !             |

  @US08_TC_0005-0006-0007_negative_test_for_stronger_password_sending_7_character
  Scenario Outline:(Negative Scenario) sending 4 or 5 or 6 characters to verify that is not enough for a stronger password(There should be at least 7 characters)
    And user cleans the new password part
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is one


    Examples:
      | new password |
      | qA1!         |
      | qA1!5        |
      | qA1!5*       |

  @US08_TC_0008_positive_test_for_stronger_password_sending_7_character
  Scenario Outline:(Positive Scenario) sending 6 then add 1 chars to see the password is getting stronger(There should be at least 7 characters)
    And user cleans the new password part
    And user sends new password "<new password>" to new password part
    And user verifies the password strength bar is one
    And user add character " <add character>" to new password part
    And user verifies the password strength bar is four

    Examples:
      | new password | add character |
      | 12345x       | !             |

  @US08_TC_0009_0010_the_new_password_should_be_confirmed
  Scenario Outline: The new password should be confirmed
    When user cleans the current password part
    And user cleans the new password part
    And user cleans the confirmation password part
    And user sends current password "<current Password>" to current password part
    And user sends new password "<new Password>" to new password part
    And user sends new password "<confirmation Password>" again to new password confirmation part
    And user clicks on save button
    And user verifies the success message on the toast container box


    Examples:
      | current Password | new Password | confirmation Password |
      | 12345            | 123456        | 123456                 |
      | 123456           | 12345        | 12345                 |

  @US08_TC_0011_old_password_should_not_be_used
  Scenario Outline: old password should not be used
    When user cleans the current password part
    And user cleans the new password part
    And user cleans the confirmation password part
    And user sends current password "<current Password>" to current password part
    And user sends current password "<new Password>" to new password part
    And user sends current password "<confirmation Password>" to confirmation password part
    And user clicks on save button
    Then user sees the success message on the toast container box as a BUG
    Then user close the driver

    Examples:
      | current Password | new Password | confirmation Password |
      | 12345            | 12345        | 12345                 |