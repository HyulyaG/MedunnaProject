package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.Driver;
import java.util.List;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.WriteToTxt.saveRegistrantData;

public class US02_RegistrationSteps {

    Registrant registrant = new Registrant();//SAVE DATA AND REUSE DATA
    Faker faker = new Faker();
    RegistrationPage rp = new RegistrationPage();//INITIALIZED WEBELEMENTS


//    @Given("user provides ssn id {string}")
//    public void user_provides_ssn_id(String ssn) {
//
//        ssn = faker.idNumber().ssnValid();
//        registrant.setSsn(ssn);
//        Driver.waitAndSendText(rp.ssnTextBox, ssn);
//
//    }

    @Given("user provides firstname and lastname {string} and {string}")
    public void user_provides_firstname_and_lastname_and(String firstname, String lastname) {

        firstname = faker.name().firstName();
        lastname = faker.name().lastName();

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);

        Driver.waitAndSendText(rp.firstNameTextBox, firstname);
        Driver.waitAndSendText(rp.lastNameTextBox, lastname);

    }

    @Then("user creates username {string}")
    public void user_creates_username(String username) {
        username = registrant.getFirstName() + registrant.getLastName();
        registrant.setLogin(username);
        Driver.waitAndSendText(rp.userNameTextBox, username);

    }

    @Then("user provides also email {string}")
    public void user_provides_also_email(String email) {
        Driver.wait(1);
        email = faker.internet().emailAddress();
        registrant.setEmail(email);
        Driver.waitAndSendText(rp.emailTextBox, email);
    }

    @Then("user generates the password {string}")
    public void user_generates_the_password(String password) {

        password = faker.internet().password(8, 20, true, true);
        registrant.setPassword(password);
        Driver.waitAndSendText(rp.firstPasswordTextBox, password);
        Driver.waitAndSendText(rp.secondPasswordTextBox, password);
    }

    @Given("user clicks on register")
    public void user_clicks_on_register() {
        Driver.waitAndClick(rp.registerButton);
        Driver.wait(1);
    }

    @Given("user validates")
    public void user_validates() {
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(rp.successMessageToastContainer, 5).isDisplayed());
    }

        //    @Then("user validates Your username is required message")
//    public void user_validates_your_username_is_required_message() {
//        Driver.wait(1);
//        String expectedMessage="Your username is required.";
//        Assert.assertTrue(rp.yourEmailIsRequiredMessage.isDisplayed());
//    }

        //    @Then("user verifies Your email is required. message")
//    public void user_verifies_your_email_is_required_message() {
//        Driver.wait(1);
//        String expectedMessage="Your email is required.";
//        Assert.assertEquals(expectedMessage,rp.yourEmailIsRequiredMessage.getText());
//    }

        //    @Then("verify This field is invalid message is visible")
//    public void verify_this_field_is_invalid_message_is_visible() {
//        Driver.wait(1);
//       Assert.assertTrue(Driver.getDriver().getPageSource().contains("This field is invalid message is visible"));
//    }

        //        verify username
//        Assert.assertTrue(rp.usernameIsRequiredMessage.isDisplayed());
//        verify success message
        //Assert.assertTrue(rp.successMessageToastContainer.isDisplayed());
//        verify blank email warning message

//    @Then("user creates the records to a correspondent file")
//    public void user_creates_the_records_to_a_correspondent_file() {
//
//        saveRegistrantData(registrant);
//    }

//    @Then("close the application")
//    public void close_the_application() {
//        Driver.closeDriver();
//    }

    @Given("user does not provide username")
    public void user_does_not_provide_username() {
        rp.userNameTextBox.sendKeys("");
        Driver.waitAndClick(rp.registerButton);

    }

    @Given("user provides wrong email {string}")
    public void user_provides_wrong_email(String string) {
        rp.emailTextBox.sendKeys("johnyse014gmail.com");
    }

    @Then("verify error message")
    public void verify_error_message() {
        Assert.assertTrue(rp.thisFieldIsInvalidMessage.isDisplayed());

    }

    @Then("verify username is required  message")
    public void verify_username_is_required_message() {
        Assert.assertTrue(Driver.waitForVisibility(rp.usernameIsRequiredMessage, 8).isDisplayed());
    }

    @Given("user does not provide email")
    public void user_does_not_provide_email() {

        rp.emailTextBox.sendKeys("");
    }
    @Then("verify Your email is required. message is displayed")
    public void verify_your_email_is_required_message_is_displayed() {
        Assert.assertTrue(Driver.waitForVisibility(rp.yourEmailIsRequiredMessage,4).isDisplayed());
    }

//    @Given("user provides the password {string}")
//    public void user_provides_the_password(String password) {
//        Driver.waitAndSendText(rp.firstPasswordTextBox, password);
//    }

    @Then("user valides the password strength {string}")
    public void user_valides_the_password_strength(String level) {

        if (1 == Integer.parseInt(level)) {
            Assert.assertTrue(rp.passwordStrength1.isDisplayed());
        } else if (2 == Integer.parseInt(level)) {
            Assert.assertTrue(rp.passwordStrength2.isDisplayed());
        } else if (3 == Integer.parseInt(level)) {
            Assert.assertTrue(rp.passwordStrength3.isDisplayed());
        }

    }

    @Then("user gets DB records and validates the ssn")
    public void user_gets_db_records_and_validates_the_ssn() {

   List<String> actualSSNIDs = getSSNIDs();

        Assert.assertTrue(actualSSNIDs.contains(registrant.getSsn()));

    }
}