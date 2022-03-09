package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.UserSettingsPage;

public class US06_UserSettingsNotEditableStepDefs {
    LoginPage loginPage = new LoginPage();
    UserSettingsPage userSettings = new UserSettingsPage();

    @Then("verify the negative result for firstname")
    public void verify_the_negative_result_for_firstname() {
        userSettings.settingsFirstName.clear();
        userSettings.firstNameIsRequiredText.isDisplayed();
    }

    @Then("verify the negative result for lastname")
    public void verify_the_negative_result_for_lastname() {
        userSettings.settingsLastName.clear();
        userSettings.lastNameIsRequiredText.isDisplayed();
    }
    @Then("verify the negative result for email")
    public void verify_the_negative_result_for_email() {
        userSettings.settingsEmail.clear();
        userSettings.emailIsRequiredText.isDisplayed();
    }

    @Given("user sends new email as a String {string}")
    public void user_sends_new_email_as_a_string(String string) throws InterruptedException {
        userSettings.settingsEmail.clear();
        Thread.sleep(1000);
        userSettings.settingsEmail.sendKeys(string);
    }

    @Then("verify the negative result for email as an invalid")
    public void verify_the_negative_result_for_email_as_an_invalid() {
        userSettings.emailInvalidText.isDisplayed();
    }



}
