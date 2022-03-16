package stepdefinitions.uisteps;


import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.UserSettingsPage;
import utilities.Driver;

public class US06_UserSettingsStepDefs {

    LoginPage loginPage = new LoginPage();
    UserSettingsPage userSettings = new UserSettingsPage();


    @Then("user clicks on the account menu")
    public void user_clicks_on_the_account_menu() throws InterruptedException {
        Driver.waitAndClick(userSettings.account_menu);
        //Thread.sleep(1000);
        //userSettings.account_menu.click();
    }
    @Then("clicks on the settings button")
    public void clicks_on_the_settings_button() throws InterruptedException {
        Driver.waitAndClick(userSettings.settignsButton);
        //Thread.sleep(1000);
        //userSettings.settignsButton.click();
        //Thread.sleep(2000);
    }

    @Then("verify the same credentials")
    public void verify_the_same_credentials() {
        //Assert.assertTrue(userSettings.settingsFirstName.isDisplayed());
        Driver.waitForVisibility(userSettings.settingsFirstName, 4);

    }

    @Then("verify the settings page")
    public void verify_the_settings_page() {

        Driver.waitForVisibility(userSettings.settingsForUserText, 4);
        //userSettings.settingsForUserText.isDisplayed();
    }
}
