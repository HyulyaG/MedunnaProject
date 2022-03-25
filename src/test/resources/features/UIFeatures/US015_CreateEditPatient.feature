Feature: Create or Edit Patient

  @US015_CreateEditPatient
  Scenario Outline: Create or Edit Patient
    When user launches the browser
    And user navigates to home page
    And user clicks account_menu
    And user clicks sign_in_menu
    And user enter username as "<userName>"
    And user enter password as "<password>"
    And user clicks sign_in_button
    And user clicks ItemsTitles menu
    And user clicks Patient menu
    And user verifies create_a_new_patient button
    And user clicks view information of first patient
    And user verifies all patient information title
    And user verifies id item added for edit patient
    And user enter patient values with Pojo "<firstName>", "<lastName>", "<phone>", "<email>", "<userId>"
#    And user create a new patient with POST and API and Pojo
#    And user validate patient info with DB
#    And user validate patient info with API
#    And admin can delete any patient

    Examples:
      | userName   | password | firstName | lastName  | phone       | email               | userId |
      | adminrecep | 123Recep | RecepPojo | PojoRecep | 555-44-8888 | pojorecep@gmail.com | 11034  |