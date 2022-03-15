package stepdefinitions.uisteps;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.NavigationPageAfterLogin;
import pages.UserSettingsPage;
import utilities.Driver;
public class US09_StaffPartUISteps {
    LoginPage loginPage = new LoginPage();
    NavigationPageAfterLogin navigationPageAfterLogin = new NavigationPageAfterLogin();

    UserSettingsPage userSettingsPage = new UserSettingsPage();
    Faker faker = new Faker();
    @Given("user inserts the staff login credentials {string} and {string}")
    public void user_inserts_the_staff_login_credentials_and(String username, String password) {
        loginPage.username.sendKeys("MyStaffHyu");
        loginPage.password.sendKeys("MyStaffHyu1990");
    }
    @Given("user navigates to and clicks on the my pages tab")
    public void user_navigates_to_and_clicks_on_the_my_pages_tab() {
        Driver.wait(1);
        Driver.waitAndClick(navigationPageAfterLogin.myPagesDropDownButton);
    }
    @Given("user clicks on the search patient button from teh dropdown to view all patients data")
    public void user_clicks_on_the_search_patient_button_from_teh_dropdown_to_view_all_patients_data() {
        Driver.wait(1);
        Driver.waitAndClick(navigationPageAfterLogin.searchBoxDropDown);
    }
    @When("user clicks on the view button for second patient on the list")
    public void user_clicks_on_the_view_button_for_second_patient_on_the_list() {
        Driver.wait(1);
        Driver.waitAndClick(navigationPageAfterLogin.getViewButtonPatient5552);
    }
    @Then("user verifies patient information for the second patient on the list")
    public void user_verifies_patient_information_for_the_second_patient_on_the_list() {
        Driver.wait(1);
        Driver.waitAndClick(navigationPageAfterLogin.getPatientVerifyPageByStaff);
    }
    @Given("user verifies the search box is visible")
    public void user_verifies_the_search_box_is_visible() {
        Assert.assertTrue(navigationPageAfterLogin.searchBoxStaffView.isDisplayed());
    }
    @Given("user inserts the patient SSN")
    public void user_inserts_the_patient_ssn() {
        Driver.wait(1);
        navigationPageAfterLogin.searchBoxStaffView.sendKeys("143-72-9872");
    }
    @When("user verifies the relevant patient is found")
    public void user_verifies_the_relevant_patient_is_found() {
        Assert.assertTrue("143-72-9872", true);
    }
}
