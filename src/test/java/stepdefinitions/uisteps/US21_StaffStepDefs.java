package stepdefinitions.uisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.US21_StaffPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class US21_StaffStepDefs {
    LoginPage loginPage = new LoginPage();
    US21_StaffPage us21_staffPage= new US21_StaffPage();

    @When("User navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }
    @When("user clicks sign in button at the home page and navigates to sign in page")
    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {
        Driver.waitAndClick(loginPage.loginDropdown);
        Driver.waitAndClick(loginPage.signInButton);

    }
    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String pass) throws InterruptedException {
        loginPage.username.sendKeys(username);
        Thread.sleep(5);
        loginPage.password.sendKeys(pass);

    }
    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        Driver.waitAndClick(loginPage.loginButton);

    }
    @When("user clicks my pages")
    public void user_clicks_my_pages() {
        Driver.waitAndClick(us21_staffPage.myPages);

    }
    @When("user clicks search patient")
    public void user_clicks_search_patient() {
        Driver.waitAndClick(us21_staffPage.searchPatient);

    }
    @When("user provides a valid ssn number into search box")
    public void user_provides_a_valid_ssn_number_into_search_box(io.cucumber.datatable.DataTable dataTable) {
        Driver.waitAndClick(us21_staffPage.patientSSNSearchBox);
        us21_staffPage.patientSSNSearchBox.sendKeys("252-93-3170");
    }
    @When("user click show appointments button")
    public void user_click_show_appointments_button() {
        Driver.waitAndClick(us21_staffPage.showAppointmentButton);

    }
    @When("user clicks edit button at the first appointment")
    public void user_clicks_edit_button_at_the_first_appointment() {
        Driver.waitAndClick((us21_staffPage.editButtonAppointments));

    }
    @Then("user verifies create and edit appointments page")
    public void user_verifies_create_and_edit_appointments_page() {
        assertTrue(us21_staffPage.createEditAppointmentText.isEnabled());

    }
    @Then("user makes necessary updates and sets the status {string}")
    public void user_makes_necessary_updates_and_sets_the_status(String status) {
        //Driver.waitAndClick(us21_staffPage.statusTextBox);
        Driver.waitAndSendText(us21_staffPage.statusTextBox,"0");


    }
    @Then("user click save button")
    public void user_click_save_button() {
        Driver.waitAndClick(us21_staffPage.saveButtonCreateEditAppointment);


    }

    @Then("user verifies appointments page header")
    public void user_verifies_appointments_page_header() {
        assertTrue(us21_staffPage.patientsText.isDisplayed());

    }
    @Then("user verifies that completed option is disabled")
    public void user_verifies_that_completed_option_is_disabled() {
        assertFalse(us21_staffPage.completedDisabled.isEnabled());

    }
    @Then("user clicks show tests for the given patient")
    public void user_clicks_show_tests_for_the_given_patient() {
        Driver.waitAndClick(us21_staffPage.showTestsButton);

    }
    @Then("user clicks view tests")
    public void user_clicks_view_tests() {
        Driver.waitAndClick(us21_staffPage.viewTestsButton);

    }
    @Then("user verifies that test results are visible")
    public void user_verifies_that_test_results_are_visible() {
        assertTrue(us21_staffPage.testResultsPage.isDisplayed());

    }
    @Then("user clicks sign out button")
    public void user_clicks_sign_out_button() {
        Driver.waitAndClick(us21_staffPage.signOutButton);
    }

}