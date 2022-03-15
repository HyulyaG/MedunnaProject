package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.MyAppointments;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US12_RequestTestStepDefs {
    LoginPage loginPage = new LoginPage();
    MyAppointments myAppointments = new MyAppointments();

    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }
    @Given("user logs in as a doctor")
    public void user_logs_in_as_a_doctor() {
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
        loginPage.username.sendKeys("senoler");
        loginPage.password.sendKeys("senol123");
        loginPage.loginButton.click();
    }

    @Given("user navigates to my appointments page")
    public void user_navigates_to_my_appointments_page() {
        Driver.waitAndClick(myAppointments.myPagesDropdown);
        myAppointments.myAppointments.click();

    }

    @Then("user verifies being on appointments page")
    public void user_verifies_being_on_appointments_page() {
        Assert.assertTrue(myAppointments.appointmentHeader.isDisplayed());
    }

    @Given("user clicks on edit button")
    public void user_clicks_on_edit_button() {
        Driver.waitAndClick(myAppointments.editButton);
    }

    @Then("user verifies being on Create or Edit an Appointment page page")
    public void user_verifies_being_on_create_or_edit_an_appointment_page_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Create or Edit an Appointment"));
    }
    @Given("user clicks on request a test button")
    public void user_clicks_on_request_a_test_button() {
        Driver.wait(1);
        Driver.waitAndClick(myAppointments.requestATestButton,5);
    }

    @Then("user verifies being on Test Items page")
    public void user_verifies_being_on_test_items_page() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Test Items"));
    }

    @Given("user selects the  Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin options")
    public void user_selects_the_glucose_urea_creatinine_sodium_potassium_total_protein_albumin_hemoglobin_options() {
        Driver.wait(2);
        myAppointments.albuminCheckBox.click();
        myAppointments.creatininCheckBox.click();
        myAppointments.hemoglobinCheckBox.click();
        myAppointments.ureaCheckBox.click();
        myAppointments.totalProteinCheckBox.click();
        myAppointments.potassiumCheckBox.click();
        myAppointments.sodiumCheckBox.click();
        //myAppointments.glucoseCheckBox.click();
        Driver.wait(1);
    }
    @Given("user clicks in save button")
    public void user_clicks_in_save_button() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(myAppointments.saveButton);
        actions.doubleClick(myAppointments.saveButton);

        Driver.waitAndClick(myAppointments.saveButton,3);
    }
    @Then("user verifies the success message")
    public void user_verifies_the_success_message() {
        Driver.wait(1);
        Assert.assertTrue(myAppointments.toastContainerSuccessMessage.isDisplayed());
    }

}