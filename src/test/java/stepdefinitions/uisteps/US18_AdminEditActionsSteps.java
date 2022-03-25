package stepdefinitions.uisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CreateOrEditPhysician;
import pages.LoginPage;
import utilities.Driver;

public class US18_AdminEditActionsSteps {

    LoginPage loginPage = new LoginPage();
    CreateOrEditPhysician createOrEditPhysician = new CreateOrEditPhysician();


    @When("user logs in as admin")
    public void user_logs_in_as_admin() {
        loginPage.loginDropdown.click();
        loginPage.signInButton.click();
        loginPage.username.sendKeys("MyAdminHyu");
        loginPage.password.sendKeys("MyAdminHyu1990");
        loginPage.loginButton.click();

    }
    @When("clicks on items and titles dropdown")
    public void clicks_on_items_and_titles_dropdown() {
        Driver.wait(5);
        WebElement element = Driver.getDriver().findElement(By.id("entity-menu"));
        element.click();
//       createOrEditPhysician.adminItemsAndTitlesDropdown.click();

    }
    @When("selects on Physician")
    public void selects_on_physician() {
        WebElement physicians = Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-item'])[3]"));
        physicians.click();
    }
    @Then("verify user is on Physician view portal")
    public void verify_user_is_on_physician_view_portal() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Physicians"));
        //Assert.assertTrue(Driver.waitForVisibility(createOrEditPhysician.physicianHeader,5).isDisplayed());

    }

    @When("user clicks on create new physician")
    public void user_clicks_on_create_new_physician() {
        Driver.wait(3);
        WebElement createPhysician = Driver.getDriver().findElement(By.id("jh-create-entity"));
        createPhysician.click();
    }

    @Then("verify Create or edit a Physician title is visible")
    public void verify_create_or_edit_a_physician_title_is_visible() {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Create or edit a Physician"));
    }

    @Then("click on use search checkbox")
    public void click_on_use_search_checkbox() {

        Driver.wait(4);
        Driver.waitAndClick(createOrEditPhysician.useSsnSearCheckBox);
//        WebElement ssnCheckbox = Driver.getDriver().findElement(By.id("useSSNSearch"));
//        ssnCheckbox.click();

    }

    @Then("enter SSN in the SSN textbox and click on search user button")
    public void enter_ssn_in_the_ssn_textbox_and_click_on_search_user_button() {
        Driver.waitForVisibility(By.id("searchSSN"),10);
        createOrEditPhysician.ssnTextBox.sendKeys("876-44-4488");

        Driver.waitAndClick(createOrEditPhysician.searchUserButton);
    }

    @Then("edit firstname, lastname, birthdate")
    public void edit_firstname_lastaname_birthdate() {
        Driver.wait(2);
        createOrEditPhysician.firstNameTextBox.clear();
        createOrEditPhysician.firstNameTextBox.sendKeys("Doctor Boris");
        Driver.wait(2);
        createOrEditPhysician.lastNameTextBox.clear();
        createOrEditPhysician.lastNameTextBox.sendKeys("Johnson");
        Driver.wait(2);
//        createOrEditPhysician.physicianBirthDay.clear();
//        createOrEditPhysician.physicianBirthDay.click();
//        createOrEditPhysician.physicianDropdownItem.sendKeys("01/05/1996 20:15");


    }

    @Then("provide a phone number")
    public void provide_a_phone_number() {
        createOrEditPhysician.physicianPhone.sendKeys("123-443-2345");
    }

    @Then("provide specialty for the doctor")
    public void provide_specialty_for_the_doctor() {
        Driver.wait(3);
        Driver.selectByIndex(createOrEditPhysician.physicianSpecialityDropDropdown,3);
    }

    @Then("provide a profile picture for the physician")
    public void provide_a_profile_picture_for_the_physician() {
        String pathOfImage = System.getProperty("user.home") + "/OneDrive/Desktop/23424.jpg";
        Driver.waitAndClick(createOrEditPhysician.chooseFileButton);
        Driver.waitAndSendText(createOrEditPhysician.chooseFileButton, pathOfImage);

    }
    @Then("choose a doctor among existing users")
    public void choose_a_doctor_among_existing_users() {
        Select select = new Select(createOrEditPhysician.userIdDropdown);
        select.selectByIndex(2);
    }

    @Then("provide the exam fee")
    public void provide_the_exam_fee () {
        createOrEditPhysician.examFee.sendKeys("200");
    }

    @Then("provide description")
    public void provide_description() {
        createOrEditPhysician.physicianDescription.sendKeys("HALKIN DOKTORU");
    }
    @Then("clicks on save button")
    public void clicks_on_save_button() {
        Driver.wait(2);
        Driver.waitAndClick(createOrEditPhysician.saveButton);
    }

    @Then("verify toast container")
    public void verify_toast_container() {
        Driver.wait(2);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Internal server error."));
    }

    @Then("verify that ID,SSN, First Name, Last Name, Birth Date etc. is visible on view portal")
    public void verify_that_id_ssn_first_name_last_name_birth_date_etc_is_visible_on_view_portal() {
        Driver.wait(3);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("ID"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("SSN"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("First Name"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Last Name"));
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Birth Date"));

    }





}