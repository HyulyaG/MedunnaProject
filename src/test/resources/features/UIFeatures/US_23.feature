@Smoketest
Feature: test payment invoice
  @US_23Invoice
  Scenario Outline: Payment invoice process done by staff
    Given user navigates to medunna home page
    Given user signs in with staff credentials
    And user clicks my pages dropdown
    And user clicks search patient button
    Then user searchs patient with SSN "<ssn>" in the search box
    Then user clicks show appointment button
    Then user verifies patient's status completed or cancelled
    Then user clicks payment invoice process
    And user sees the following fields in the invoice page
    And user clicks create invoice button
    And user clicks save button
    And user verifies success message
    And user search patient with SSN "<ssn>" in the search box again
    Then user clicks show appointment
    Then user clicks again for payment invoice
    And user clicks show invoice button
    And user verifies the invoice page
    Examples: patient SSN id
      | ssn         |
      | 194-19-1949 |