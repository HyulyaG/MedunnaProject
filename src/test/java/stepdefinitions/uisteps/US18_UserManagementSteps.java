package stepdefinitions.uisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.NavigationPageAfterLogin;
import utilities.Driver;

public class US18_UserManagementSteps {
    NavigationPageAfterLogin navigationPageAfterLogin = new NavigationPageAfterLogin();

    @When("clicks on administration dropdown")
    public void clicks_on_administration_dropdown() {
       navigationPageAfterLogin.administrationDropdown.click();
    }
    @When("clicks on user management")
    public void clicks_on_user_management() {
        navigationPageAfterLogin.userManagementButton.click();
    }
    @Then("verify user is on user management page")
    public void verify_user_is_on_user_management_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Users"));
    }
    @Then("user clicks on the delete button")
    public void user_clicks_on_the_delete_button() {

    }
    @Then("user confirms delete operation")
    public void user_confirms_delete_operation() {

    }
    @Then("verify physician is deleted message")
    public void verify_physician_is_deleted_message() {

    }




}
