package stepdefinitions.uisteps;

import Pages.AppointmentPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.Appointment;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.WriteToTxt.saveAppointData;
import static utilities.WriteToTxt.saveNegativeData;

public class US05StepDefs {


    AppointmentPage appointmentPage = new AppointmentPage();
    Appointment appointment = new Appointment();


    @Given("user navigates to medunna login page")
    public void user_navigates_to_medunna_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }


    @Given("user clicks on make an appointment button")
    public void user_clicks_on_make_an_appointment_button() {
        appointmentPage.appointmentButton.click();
        Driver.wait(2);
    }

    @Given("user provides the first name as {string} with valid credentials")
    public void user_provides_the_first_name_as_with_valid_credentials(String firstName) {
        appointment.setFirstname(firstName);
        appointmentPage.firstNameBox.sendKeys(firstName);
        Driver.wait(2);

    }

    @Given("user provides the last name as {string} with valid credentials")
    public void user_provides_the_last_name_as_with_valid_credentials(String lastName) {
        appointment.setLastname(lastName);
        appointmentPage.lastNameTextBox.sendKeys(lastName);
        Driver.wait(2);

    }

    @Given("user provides the SSN as {string} with valid credentials")
    public void user_provides_the_ssn_as_with_valid_credentials(String SSN) {

        appointment.setSsn(SSN);
        appointmentPage.ssnBox.sendKeys(SSN);
        Driver.wait(2);

    }

    @Given("user provides the email as {string} with valid credentials")
    public void user_provides_the_email_as_with_valid_credentials(String email) {

        appointment.setEmail(email);
        appointmentPage.emailTextBox.sendKeys(email);
        Driver.wait(2);

    }

    @Given("user provides the phone number as {string} with valid credentials")
    public void user_provides_the_phone_number_as_with_valid_credentials(String phoneNumber) {
        appointmentPage.phoneTextBox.sendKeys(phoneNumber);
        Driver.wait(2);

    }

    @Given("user provides the date {string}")
    public void user_provides_the_date(String date) {

        appointment.setDate(date);
        appointmentPage.dateTextBox.sendKeys(date);
        Driver.wait(2);
    }

    @Then("user sends an appointment request.")
    public void user_sends_an_appointment_request() {

        appointmentPage.requestButton.click();
        saveAppointData(appointment);
    }

    @Then("There should be Success message.")
    public void there_should_be_success_message() {
        Assert.assertTrue(Driver.waitForVisibility(appointmentPage.successMessageToastContainer, 5).isDisplayed());
    }

    @When("sign in the app with the provided {string} and {string}")
    public void sign_in_the_app_with_the_provided_and(String username, String password) {
        Driver.waitAndClick(appointmentPage.loginDropdown);
        Driver.waitAndClick(appointmentPage.signInButton);
        Driver.waitAndSendText(appointmentPage.userNameTextBox, username);
        Driver.waitAndSendText(appointmentPage.passwordTextBox, password);
        Driver.waitAndClick(appointmentPage.signinbutton);

    }

    @Then("verify the appointment")
    public void verify_the_appointment() {

        Driver.waitAndClick(appointmentPage.myPagesDropdown);
        Driver.waitAndClick(appointmentPage.myAppointmentsButton);
        Driver.wait(7);
        Assert.assertTrue(appointmentPage.appointmentHeading.isDisplayed());
        Driver.closeDriver();

    }

    @Given("user provides invalid first name as {string}")
    public void user_provides_invalid_first_name_as(String firstName) {
        appointment.setFirstname(firstName);
        appointmentPage.firstNameBox.sendKeys(firstName);
        Driver.wait(2);
        appointmentPage.lastNameTextBox.click();
    }

    @Then("user verifies fail message of first name")
    public void user_verifies_fail_message_of_first_name() {

        Assert.assertTrue(appointmentPage.alertMessageFirstName.isDisplayed());
    }

    @Then("user provides invalid last name as {string}")
    public void user_provides_invalid_last_name_as(String lastName) {
        appointment.setLastname(lastName);
        appointmentPage.lastNameTextBox.sendKeys(lastName);
        Driver.wait(2);
        appointmentPage.ssnBox.click();
    }

    @Then("user verifies fail message of last name")
    public void user_verifies_fail_message_of_last_name() {
        Assert.assertTrue(appointmentPage.alertMessageLastName.isDisplayed());
    }

    @Then("user provides invalid SSN name as {string}")
    public void user_provides_invalid_ssn_name_as(String SSN) {
        appointment.setSsn(SSN);
        appointmentPage.ssnBox.sendKeys(SSN);
        Driver.wait(2);
        appointmentPage.emailTextBox.click();
        ;
    }

    @Then("user verifies fail message of SSN")
    public void user_verifies_fail_message_of_ssn() {

        Assert.assertTrue(appointmentPage.alertMessageSSNInvalid.isDisplayed());

    }

    @Then("user provides invalid email as {string}")
    public void user_provides_invalid_email_as(String email) {
        appointment.setEmail(email);
        appointmentPage.emailTextBox.sendKeys(email);
        Driver.wait(2);
        appointmentPage.phoneTextBox.click();
    }

    @Then("user verifies fail message of email")
    public void user_verifies_fail_message_of_email() {
        Assert.assertTrue(appointmentPage.alertMessageEmailInvalid.isDisplayed());

    }

    @Then("user provides invalid phone number as {string}")
    public void user_provides_invalid_phone_number_as(String phoneNumber) {
        appointment.setPhoneNumber(phoneNumber);
        appointmentPage.phoneTextBox.sendKeys(phoneNumber);
        Driver.wait(2);
        appointmentPage.dateTextBox.click();
    }

    @Then("user verifies fail message of phone number")
    public void user_verifies_fail_message_of_phone_number() {
        Assert.assertTrue(appointmentPage.alertMessagePhoneNumberInvalid.isDisplayed());


    }

    @Then("user data will be created")
    public void user_data_will_be_created() {

        appointmentPage.requestButton.click();
        Driver.wait(2);
        saveNegativeData(appointment);
        Driver.closeDriver();

    }

}
