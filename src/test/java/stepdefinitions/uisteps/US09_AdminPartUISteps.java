package stepdefinitions.uisteps;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.NavigationPageAfterLogin;
import pages.UserSettingsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import javax.swing.*;
public class US09_AdminPartUISteps {
    LoginPage loginPage = new LoginPage();
    NavigationPageAfterLogin navigationPageAfterLogin = new NavigationPageAfterLogin();
    UserSettingsPage userSettingsPage = new UserSettingsPage();
    Faker faker = new Faker();
    @Given("user goes to the site")
    public void user_goes_to_the_site() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
    }
    @Given("user inserts the admin login credentials {string} and {string}")
    public void user_inserts_the_admin_login_credentials_and(String username, String password) {
        loginPage.username.sendKeys("MyAdminHyu");
        loginPage.password.sendKeys("MyAdminHyu1990");
    }
    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.loginButton.click();
    }
    @Given("user navigates to and clicks on the item and title tab")
    public void user_navigates_to_and_clicks_on_the_item_and_title_tab() {
        Driver.waitAndClick(navigationPageAfterLogin.ItemAndTitlesDropDown);
    }
    @Given("user clicks on the patient button from teh dropdown to view all patients data")
    public void user_clicks_on_the_patient_button_from_teh_dropdown_to_view_all_patients_data() {
        Driver.waitAndClick(navigationPageAfterLogin.PatientDropDown);
    }
    @When("user clicks on the view button")
    public void user_clicks_on_the_view_button() {
        Driver.waitAndClick(navigationPageAfterLogin.ViewButtonPatient1051);
    }
    @Then("user verifies patient information")
    public void user_verifies_patient_information() {
        Assert.assertTrue(navigationPageAfterLogin.PatientVerifyPage.isDisplayed());
    }
    @Given("user clicks on the edit button for a patient")
    public void user_clicks_on_the_edit_button_for_a_patient() {
        Driver.waitAndClick(navigationPageAfterLogin.EditButtonPatient1051);
    }
    @Given("user updates all patient data")
    public void user_updates_all_patient_data() {
        Driver.wait(2);
        navigationPageAfterLogin.firstNamePatientEditBox.clear();
        navigationPageAfterLogin.firstNamePatientEditBox.sendKeys("Ipek");
        navigationPageAfterLogin.lastNamePatientEditBox.clear();
        navigationPageAfterLogin.lastNamePatientEditBox.sendKeys("Gunes");
        navigationPageAfterLogin.BirthDateBox.clear();
        Driver.waitAndSendText(navigationPageAfterLogin.BirthDateBox, "01.01.0019901915");
        navigationPageAfterLogin.eMailPatientEditBox.clear();
        navigationPageAfterLogin.eMailPatientEditBox.sendKeys("ipek@gunes.com");
        navigationPageAfterLogin.phonePatientEditBox.clear();
        navigationPageAfterLogin.phonePatientEditBox.sendKeys("1231231230");
        Select selectGender = new Select(navigationPageAfterLogin.genderDropDown);
        selectGender.selectByIndex(1);
        Select selectBloodGroup = new Select(navigationPageAfterLogin.bloodGroupDropDown);
        selectBloodGroup.selectByIndex(0);
        navigationPageAfterLogin.patientAddressBox.clear();
        navigationPageAfterLogin.patientAddressBox.sendKeys(faker.address().fullAddress());
        navigationPageAfterLogin.patientDescriptionBox.clear();
        navigationPageAfterLogin.patientDescriptionBox.sendKeys("Really tired of Medunna's bugs");
        Select userType = new Select(navigationPageAfterLogin.userTypeDropDown);
        userType.selectByIndex(14);
        Select country = new Select(navigationPageAfterLogin.patientCountry);
        country.selectByIndex(5);
        Select stateCity = new Select (navigationPageAfterLogin.stateOrCityDropDown);
        stateCity.selectByIndex(0);
    }
    @Given("user saves the updated details")
    public void user_saves_the_updated_details() {
        Driver.waitAndClick(navigationPageAfterLogin.savePatientDataButton);
    }
    @When("user click on the back button")
    public void user_click_on_the_back_button() {
        Driver.waitAndClick(navigationPageAfterLogin.backPatientDataButton);
    }
    @Then("user verifies being on the all patients page")
    public void user_verifies_being_on_the_all_patients_page() {
        Driver.wait(2);
        Driver.waitAndClick(navigationPageAfterLogin.allPatientsListPage);
    }
    @Given("user clicks on the delete button for a patient")
    public void user_clicks_on_the_delete_button_for_a_patient() {
        Driver.wait(2);
        Driver.waitAndClick(navigationPageAfterLogin.deletePatientButton);
    }
    @Then("user deletes the user")
    public void user_deletes_the_user() {
        Driver.wait(2);
        Driver.waitAndClick(navigationPageAfterLogin.deletePatientConfirmButton);
    }
}