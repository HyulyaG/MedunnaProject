package stepdefinitions.uisteps;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import static utilities.WriteToTxt.saveRegistrantData;

public class US03_RegistrationSteps {
    Registrant registrant = new Registrant();//SAVE DATA AND REUSE DATA
    Faker faker = new Faker();
    RegistrationPage rp = new RegistrationPage();//INITIALIZED WEBELEMENTS
    @Given("user provides ssn id {string}")
    public void user_provides_ssn_id(String ssn) {
        ssn = faker.idNumber().ssnValid();
        registrant.setSsn(ssn);
        Driver.waitAndSendText(rp.ssnTextBox,ssn);
    }
//    @Given("user provides firstname and lastname {string} and {string}")
//    public void user_provides_firstname_and_lastname_and(String firstname, String lastname) {
//        firstname = faker.name().firstName();
//        lastname = faker.name().lastName();
//        registrant.setFirstName(firstname);
//        registrant.setLastName(lastname);
//        Driver.waitAndSendText(rp.firstNameTextBox,firstname);
//        Driver.waitAndSendText(rp.lastNameTextBox,lastname);
//    }
//    @Then("user creates username {string}")
//    public void user_creates_username(String username) {
//        username = registrant.getFirstName() + registrant.getLastName();
//        registrant.setLogin(username);
//        Driver.waitAndSendText(rp.userNameTextBox,username);
//    }
//    @Then("user provides also email {string}")
//    public void user_provides_also_email(String email) {
//        email = faker.internet().emailAddress();
//        registrant.setEmail(email);
//        Driver.waitAndSendText(rp.emailTextBox,email);
//    }
//    @Then("user generates the password {string}")
//    public void user_generates_the_password(String password) {
//        password = faker.internet().password(8,20, true,true);
//        registrant.setPassword(password);
//        Driver.waitAndSendText(rp.firstPasswordTextBox,password);
//        Driver.waitAndSendText(rp.secondPasswordTextBox,password);
//    }
//    @Then("user registers and validates")
//    public void user_registers_and_validates() {
//        Driver.waitAndClick(rp.registerButton);
//        Assert.assertTrue(Driver.waitForVisibility(rp.successMessageToastContainer, 5).isDisplayed());
//    }
//    @Then("user creates the records to a correspondent file")
//    public void user_creates_the_records_to_a_correspondent_file() {
//        saveRegistrantData(registrant);
//    }
    @Given("user is on registration page")
    public void user_is_on_registration_page()  {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }
    @And("user provides the password {string}")
    public void user_provides_the_password(String password) {
        Driver.waitAndSendText(rp.firstPasswordTextBox,password );
    }
    @Then("user validates the password strength {string}")
    public void user_validates_the_password_strength(String level) {
        if( 1 == Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength1.isDisplayed());
        }else if(2 == Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength2.isDisplayed());
        }else if(3 == Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength3.isDisplayed());
        }else if(4 == Integer.parseInt(level)){
            Assert.assertTrue(rp.passwordStrength4.isDisplayed());
        }

    }
}
