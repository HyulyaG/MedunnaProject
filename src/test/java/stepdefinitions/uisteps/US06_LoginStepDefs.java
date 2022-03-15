package stepdefinitions.uisteps;

import pages.LoginPage;
import io.cucumber.java.en.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US06_LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("user clicks on login dropdown")
    public void user_clicks_on_login_dropdown() {
        Driver.waitAndClick(loginPage.loginDropdown);

    }
    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {

        Driver.waitAndClick(loginPage.signInButton);

    }
    @Given("user sends username {string}")
    public void user_sends_username(String username) {

        Driver.waitAndSendText(loginPage.username, username);
        //loginPage.userName.sendKeys(string);
    }
    @Given("user sends password {string}")
    public void user_sends_password(String password) {

        Driver.waitAndSendText(loginPage.password, password);
        //loginPage.password.sendKeys(string);
    }
//    @Given("user clicks on the login button")
//    public void user_clicks_on_the_login_button() {
//
//        Driver.waitAndClick(loginPage.loginButton);
//        //loginPage.logInButton.click();
//    }

    @Then("verify the my page")
    public void verify_the_my_page() throws InterruptedException {
        Driver.waitForVisibility(loginPage.rememberMe, 5);

        //Thread.sleep(1000);
        //loginPage.myPageText.isDisplayed();
    }

    @Then("close the application")
    public void close_the_application() {

        Driver.closeDriver();
    }



}
