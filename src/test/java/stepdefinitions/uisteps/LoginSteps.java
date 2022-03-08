package stepdefinitions.uisteps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    LoginPage loginpage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));
        Driver.wait(1);

    }

    @Given("user clicks on login dropdown")
    public void user_clicks_on_login_dropdown() {
        loginpage.loginDropdown.click();
        Driver.wait(1);
    }

    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        loginpage.signInButton.click();
        Driver.wait(1);

    }

    @Given("user enters admin_id and admin_password")
    public void user_enters_admin_id_and_admin_password(DataTable credentials) {
        List<Map<String,String>> adminCredentials = credentials.asMaps(String.class,String.class);
        System.out.println(adminCredentials);

        for (Map<String,String> eachCredentials : adminCredentials) {
            loginpage.username.sendKeys(eachCredentials.get("admin_username"));
            loginpage.password.sendKeys(eachCredentials.get("admin_password"));
            Driver.wait(1);
        }


    }
    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginpage.loginButton.click();
        Driver.wait(1);

    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("+1 (336) 546-5245"));
        Driver.wait(1);

    }
    @Given("user clicks on the cancel button")
    public void user_clicks_on_the_cancel_button() {
        loginpage.cancel.click();
        Driver.wait(1);
    }
    @Given("user clicks on remember me box")
    public void user_clicks_on_remember_me_box() {
        loginpage.rememberMe.click();
        Driver.wait(1);

    }
    @Then("user clicks on the forget password button")
    public void user_clicks_on_the_forget_password_button() {
        loginpage.forgetPassword.click();
        Driver.wait(1);

    }
    @Given("user clicks on register button")
    public void user_clicks_on_register_button() {
        loginpage.registerButton.click();
        Driver.wait(1);
    }
    @Then("close the application")
    public void close_the_application(){
        Driver.closeDriver();
    }

}

