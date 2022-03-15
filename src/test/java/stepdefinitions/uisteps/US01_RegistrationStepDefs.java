package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.WriteToTxt.saveRegistrantData;

public class US01_RegistrationStepDefs {
    RegistrationPage registrationPage = new RegistrationPage();
    Registrant registrant = new Registrant();//SAVE DATA AND REUSE DATA
    Faker faker = new Faker();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));


    }
    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) throws InterruptedException {
        // Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);
        ssn = faker.idNumber().ssnValid();
        registrant.setSsn(ssn);
        Thread.sleep(3);
        Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);


    }
    @Given("user enters firstname as {string} and lastname as {string}")
    public void user_enters_firstname_as_and_lastname_as(String firstname, String lastname) {
//        Driver.waitAndSendText(registrationPage.firstName,firstname);
//        Driver.waitAndSendText(registrationPage.lastName,lastname);
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);

        Driver.waitAndSendText(registrationPage.firstNameTextBox,firstname);
        Driver.waitAndSendText(registrationPage.lastNameTextBox,lastname);
    }
    @Given("user provides username {string}")
    public void user_provides_username(String username) {
        // Driver.waitAndSendText(registrationPage.userName,username);
        username = faker.name().username();
        registrant.setUserName(username);
        Driver.waitAndSendText(registrationPage.userNameTextBox,username);

    }
    @Given("user provides email {string}")
    public void user_provides_email(String email) {
        // Driver.waitAndSendText(registrationPage.email,email);
        email = faker.internet().emailAddress();
        registrant.setEmail(email);
        Driver.waitAndSendText(registrationPage.emailTextBox,email);

    }
    @Given("user provides the password as {string}")
    public void user_provides_the_first_password_as_and_second_password_as(String password) {
//        Driver.waitAndSendText(registrationPage.firstPassword,password1);
//        Driver.waitAndSendText(registrationPage.secondPassword,password2);

        password= faker.internet().password(8,20,true,true);
        registrant.setPassword(password);
        Driver.waitAndSendText(registrationPage.firstPasswordTextBox,password);
        Driver.waitAndSendText(registrationPage.secondPasswordTextBox,password);


    }
    @Given("user clicks on the register button and validate ssn is valid")
    public void user_clicks_on_the_register_button_and_validate_ssn_is_valid() {
        Driver.waitAndClick(registrationPage.registerSubmitButton);
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.successMessageToastContainer, 5).isDisplayed());



    }

    @Given("user clicks on the register button and see the error message as {string}")
    public void user_clicks_on_the_register_button_and_see_the_success_message_as(String string) {

        //Assert.assertTrue(Driver.getDriver().getPageSource().contains("Your SSN is invalid"));
        Assert.assertTrue(registrationPage.errorSsnMessage.isDisplayed());
    }
    @Given("user clicks on the register button and validate error message {string}")
    public void user_clicks_on_the_register_button_and_validate_error_message(String string) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Your SSN is required."));

    }
    @Then("user creates the records to a correspondent file")
    public void user_creates_the_records_to_a_correspondent_file() {

        saveRegistrantData(registrant);
    }
//    @Then("close the application")
//    public void close_the_application() {
//
//        Driver.closeDriver();
//    }
    @Given("user enters invalid ssn number as {string}")
    public void user_enters_invalid_ssn_number_as(String ssn) {
        Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);

    }
    @Given("user left empty ssn text box as {string}")
    public void user_left_empty_ssn_text_box(String ssn) {

        Driver.waitAndSendText(registrationPage.ssnTextBox,ssn);
    }
    @Given("user clicks on the register button and validate")
    public void user_clicks_on_the_register_button_and_validate() {
        Driver.waitAndClick(registrationPage.registerSubmitButton);
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.successMessageToastContainer,5).isDisplayed());
    }
    @Given("user clicks on the register button and validate error message")
    public void user_clicks_on_the_register_button_and_validate_error_message() {
        Driver.waitAndClick(registrationPage.registerSubmitButton);
        Assert.assertTrue(registrationPage.errorFirstNameMessage.isDisplayed());
    }
    @Given("user enters blank firstname as {string} and lastname as {string}")
    public void user_enters_blank_firstname_as_and_lastname_as(String firstname, String lastname) {
        Driver.waitAndSendText(registrationPage.firstNameTextBox,firstname);
        Driver.waitAndSendText(registrationPage.lastNameTextBox,lastname);
    }

    @Given("user enters firstname as {string} and blank lastname as {string}")
    public void user_enters_firstname_as_and_blank_lastname_as(String firstname, String lastname) {
        Driver.waitAndSendText(registrationPage.firstNameTextBox,firstname);
        Driver.waitAndSendText(registrationPage.lastNameTextBox,lastname);
    }
}