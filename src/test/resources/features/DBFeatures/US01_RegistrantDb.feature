@Smoketest
@US01_DBRegistration
Feature: database features

  @db_ssn_verification
  Scenario: TC01_read_customer_information_ssn
    Given user connects to the database
    And user gets the "*" from "jhi_user" table
    And  verify "jhi_user" table "ssn" column contains "123-56-9424" data
    Then close the database connection