Feature: Appointment DB validation
  @US05DB_validation
  Scenario Outline: Data Base appointment validation with id
    Given connecting to database
    And user selects all "id" column data
    And user saves the DB records to correspondent files
    Then user verifies "<id>" with the database
    Then close database connection
    Examples: test data od ids
      | id   |
      | 2301 |
      | 4673 |
      | 6557 |
  @US05DB_ssn_validation
  Scenario Outline: Data Base appointment validation with ssn
    Given user connecting to database
    And user sends the query to DB and gets the column data "<query>" and "<columnName>"
    And user verifies "<ssn>" number with the database
    And user saves the DB records to the correspondent files
    Then user validates DB datas
    Then user closes database connection
    Examples: test data of ssns
      | query                  | columnName | ssn         |
      | Select * from jhi_user | ssn        | 856-45-6789 |
      | Select * from jhi_user | ssn        | 856-45-6776 |
      | Select * from jhi_user | ssn        | 128-65-1234 |
