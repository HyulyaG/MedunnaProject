package stepdefinitions.uisteps;


import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.UserSettingsPage;

public class US06_UserSettingsEditableStepDefs {
    LoginPage loginPage = new LoginPage();
    UserSettingsPage userSettings = new UserSettingsPage();

    @Given("user sends new firstname as {string}")
    public void user_sends_new_firstname_as(String string) throws InterruptedException {
        Thread.sleep(1000);
        userSettings.settingsFirstName.clear();
        userSettings.settingsFirstName.sendKeys(string);
    }

    @Then("clicks on the save button")
    public void clicks_on_the_save_button() throws InterruptedException {
        Thread.sleep(1000);
        userSettings.settingsSaveButton.click();
    }
    @Then("verify the result")
    public void verify_the_result() throws InterruptedException {
        Thread.sleep(1000);
        userSettings.settingsForUserText.isDisplayed();
    }

    @Given("user sends new lastname as {string}")
    public void user_sends_new_lastname_as(String string) {
        userSettings.settingsLastName.clear();
        userSettings.settingsLastName.sendKeys(string);
    }

    @Given("user sends new email as {string}")
    public void user_sends_new_email_as(String string) {
        userSettings.settingsEmail.clear();
        userSettings.settingsEmail.sendKeys(string);
    }

}