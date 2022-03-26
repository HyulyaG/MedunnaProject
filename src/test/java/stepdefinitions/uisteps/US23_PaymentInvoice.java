package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.PaymentInvoicePage;
import pages.StaffPage;
import utilities.ConfigurationReader;
import utilities.Driver;
public class US23_PaymentInvoice {
    LoginPage loginPage = new LoginPage();
    StaffPage staffPage = new StaffPage();
    PaymentInvoicePage paymentInvoicePage = new PaymentInvoicePage();
    @Given("user navigates to medunna home page")
    public void user_navigates_to_medunna_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("user signs in with staff credentials")
    public void user_signs_in_with_staff_credentials() {
        Driver.waitAndClick(loginPage.loginDropdown);
        Driver.waitAndClick(loginPage.signInButton);
        Driver.waitAndSendText(loginPage.username,"fatihstaffabi");//Staff username
        Driver.waitAndSendText(loginPage.password,"1211402301");
        Driver.waitAndClick(loginPage.loginButton);
    }
    @Given("user clicks my pages dropdown")
    public void user_clicks_my_pages_dropdown() {
        Driver.waitAndClick(staffPage.myPagesDropdown);
    }
    @Given("user clicks search patient button")
    public void user_clicks_search_patient_button() {
        Driver.waitAndClick(staffPage.searchPatientButton);
        Driver.wait(2);
    }
    @Then("user searchs patient with SSN {string} in the search box")
    public void user_searchs_patient_with_ssn_in_the_search_box(String ssn) {
        Driver.waitAndSendText(staffPage.patientSSNTextBox,ssn);
        Driver.wait(3);
    }
    @Then("user clicks show appointment button")
    public void user_clicks_show_appointment_button() {
        Driver.waitAndClick(staffPage.showAppointmentsButton);
    }
    @Then("user verifies patient's status completed or cancelled")
    public void user_verifies_patient_s_status_completed_or_cancelled() {
        Assert.assertTrue(Driver.waitForVisibility(staffPage.completedText,5).isDisplayed());
        Driver.wait(3);
    }
    @Then("user clicks payment invoice process")
    public void user_clicks_payment_invoice_process() {
        Driver.waitAndClick(staffPage.paymentInvoiceButton);
    }
    @Then("user sees the following fields in the invoice page")
    public void user_sees_the_following_fields_in_the_invoice_page() {
        Driver.wait(3);
        Assert.assertTrue(paymentInvoicePage.examFeeTxt.isDisplayed());
        Assert.assertTrue(paymentInvoicePage.examFeePrice.isDisplayed());
        Assert.assertTrue(paymentInvoicePage.diabetesFee.isDisplayed());
        Assert.assertTrue(paymentInvoicePage.theoTestFee.isDisplayed());
        Assert.assertTrue(paymentInvoicePage.nickyTestFee.isDisplayed());
        Driver.wait(3);
    }
    @Then("user clicks create invoice button")
    public void user_clicks_create_invoice_button() {
        Driver.waitAndClick(paymentInvoicePage.createInvoiceButton);
    }
    @Then("user clicks save button")
    public void user_clicks_save_button() {
        Driver.waitAndClick(paymentInvoicePage.saveButton);
    }
    @Then("user verifies success message")
    public void user_verifies_success_message() {
        Assert.assertTrue(Driver.waitForVisibility(paymentInvoicePage.invoiceSuccessMessage,5).isDisplayed());
    }
    @Then("user search patient with SSN {string} in the search box again")
    public void user_search_patient_with_ssn_in_the_search_box_again(String ssn) {
        Driver.waitAndSendText(staffPage.patientSSNTextBox,ssn);
    }
    @Then("user clicks show appointment")
    public void user_clicks_show_appointment() {
        Driver.waitAndClick(staffPage.showAppointmentsButton);
        Driver.wait(3);
    }
    @Then("user clicks again for payment invoice")
    public void user_clicks_again_for_payment_invoice() {
        Driver.waitAndClick(staffPage.paymentInvoiceButton);
        Driver.wait(3);
    }
    @Then("user clicks show invoice button")
    public void user_clicks_show_invoice_button() {
        Driver.wait(3);
        Driver.waitAndClick(paymentInvoicePage.showInvoiceButton);
    }
    @Then("user verifies the invoice page")
    public void user_verifies_the_invoice_page() {
        Driver.wait(3);
        Assert.assertTrue(paymentInvoicePage.invoicePageHeader.isDisplayed());
        Driver.closeDriver();
    }
}
