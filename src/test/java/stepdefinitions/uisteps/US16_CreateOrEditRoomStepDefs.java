/*package stepdefinitions.uisteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CreateARoomForInpaient;
import pages.LoginPage;
import pages.NavigationPageAfterLogin;
import pojos.US16_EditOrCreateRoomForInpatient;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.JSUtils.scrollDownByJS;
import static utilities.JSUtils.scrollIntoViewJS;

public class US16_CreateOrEditRoomStepDefs {

    CreateARoomForInpaient room= new CreateARoomForInpaient();
    LoginPage login = new LoginPage();
    NavigationPageAfterLogin navigate =new NavigationPageAfterLogin();

    @Given("user is on the homepage page")
    public void user_is_on_the_homepage_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));
    }
    @And("user clicks on login dropdown and selects the signIn button")
    public void user_clicks_on_login_dropdown_and_selects_the_sign_in_button() {
        login.loginDropdown.click();
        login.signInButton.click();

    }
    @And("user provides admin, password and clicks the submit button")
    public void user_provides_admin_password_and_clicks_the_submit_button() {
        login.username.sendKeys("adminaccount");
        login.password.sendKeys("12345");
        login.loginButton.click();
    }
    @And("user clicks on items_tittles dropdown and selects room")
    public void user_clicks_on_items_tittles_dropdown_and_selects_room() {
        Driver.waitAndClick(room.ItemTitlesDropDown);
        Driver.waitAndClick(room.RoomNavigateDropDown);

    }
    @And("user clicks on create a room button")
    public void user_clicks_on_create_a_room_button() {
        room.createARoomButton.click();
    }
    @And("user provides a room number")
    public void user_provides_a_room_number() {
        room.roomNumber.sendKeys("1265");
    }
    @And("user selects a room type")
    public void user_selects_a_room_type() {
        Driver.waitAndClick(room.roomTypeDropDown);
    }

    @Given("user clicks the status checkbox")
    public void user_clicks_the_status_checkbox() {
        room.statusCheckBox.click();
    }
    @And("user provides the price")
    public void user_provides_the_price() {
        room.price.sendKeys("120");
    }

    @And("user writes a description")
    public void user_writes_a_description() {
        room.description.sendKeys("Mayday");
    }

    @And("user provides the date for stay")
    public void user_provides_the_date_for_stay() {
        room.createDateForStay.sendKeys("12232022");
    }

    @And("user clicks the save button")
    public void user_clicks_the_save_button() {
        Driver.waitAndClick(room.submitButtonForRoom);
    }

    @And("user clicks on the signout button")
    public void user_clicks_on_the_signout_button() {
        login.loginDropdown.click();
        room.signOutButtonDropDown.click();
    }
    @And("user closes the page")
    public void user_closes_the_page() {

    }
    @Given("user clicks on edit button for the selected patient")
    public void user_clicks_on_edit_button_for_the_selected_patient() {
        Driver.waitAndClick(room.editButtonForPatientwithId1451);
    }
    @And("user updates all the information")
    public void user_updates_all_the_information() throws InterruptedException {
        Thread.sleep(3000);
        // room.roomNumber.click();
        room.roomNumber.clear();
        Thread.sleep(3000);
        Driver.clickWithJS(room.roomNumber);
        Driver.waitAndSendText(room.roomNumber,"9872",5);
        room.price.clear();
        room.price.sendKeys("450");
        //room.statusCheckBox.click();
        room.description.clear();
        room.description.sendKeys("Urgent");
        room.createDateForStay.clear();
        room.createDateForStay.sendKeys("11170020220000");
        Driver.waitAndClick(room.submitButtonForRoom);
    }
    @Given("user clicks on the view button after edit")
    public void user_clicks_on_the_view_button_for_a_patient() {
        Driver.waitAndClick(room.viewRoomButtonAfterEdit);
    }
    //@Then("user validates that the room is created")
    //public void user_validates_that_the_room_is_created() {

    //  Assert.assertTrue(room.verifiedRoom12345.isDisplayed());
    //}

    @Given("user creates a room with a past date")
    public void user_creates_a_room_with_a_past_date() {
        room.roomNumber.sendKeys("1953");
        Driver.waitAndClick(room.roomTypeDropDown);
        room.price.sendKeys("300");
        room.statusCheckBox.click();
        room.description.sendKeys("Acilllll");
        room.createDateForStay.sendKeys("10192020");
        Driver.waitAndClick(room.submitButtonForRoom);
    }

    @Given("user provides a nonnumerical room number")
    public void user_provides_a_nonnumerical_room_number(){

        room.roomNumber.sendKeys("1ab");
        Driver.waitAndClick(room.roomTypeDropDown);
    }
    @Then("user validates the invalid message")
    public void user_validates_the_invalid_message(){
        String expectedMessage="This field should be a number.";
        String actualMessage = room.invalidRoomNumberMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);


    }








}
*/
