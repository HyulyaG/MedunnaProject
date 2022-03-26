package stepdefinitions.uisteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.User08_UserPasswordPage;
import utilities.Driver;

public class US08_UserPasswordStepDefs {

    User08_UserPasswordPage userPassword = new User08_UserPasswordPage();


    @And("user enters admin_id {string} and admin_password {string}")
    public void userEntersAdmin_idAndAdmin_password(String adminId, String adminPass) throws InterruptedException {
        Driver.waitAndSendText(userPassword.username, adminId, 3);
        Driver.waitAndSendText(userPassword.password, adminPass, 3);
        Thread.sleep(2000);
    }

    @Given("user clicks on account menu on the account page")
    public void user_clicks_on_account_menu_on_the_account_page() throws InterruptedException {
        Driver.waitAndClick(userPassword.accountMenu, 3);
        Thread.sleep(2000);
    }

    @Then("user clicks on Password button")
    public void user_clicks_on_password_button() throws InterruptedException {
        Driver.waitAndClick(userPassword.passwordButton, 3);
        Thread.sleep(2000);
    }

    @Given("user sends current password {string} to current password part")
    public void user_sends_current_password_to_current_password_part(String currentPass) throws InterruptedException {
        Driver.waitAndSendText(userPassword.currentPassword, currentPass);
        Thread.sleep(2000);
    }

    @Given("user sends new password {string} to new password part")
    public void user_sends_new_password_to_new_password_part(String newPass) throws InterruptedException {
        Driver.waitAndSendText(userPassword.newPassword, newPass);
        Thread.sleep(2000);
    }

    @Given("user sends new password {string} again to new password confirmation part")
    public void user_sends_new_password_again_to_new_password_confirmation_part(String confirmationPass) throws InterruptedException {
        Driver.waitAndSendText(userPassword.confirmationPassword, confirmationPass, 3);
        Thread.sleep(2000);
    }

    @Given("user clicks on save button")
    public void user_clicks_on_save_button() throws InterruptedException {
        Driver.waitAndClick(userPassword.saveButton, 3);
        Thread.sleep(3000);
    }

    @Then("user sees success message in the toast container box")
    public void user_sees_success_message_in_the_toast_container_box() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();

        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(6000);
    }

    /*@And("user clicks account_menu")
    public void userClicksAccount_menu() throws InterruptedException {

        Driver.waitAndClick(userPassword.accountMenu);
        Thread.sleep(2000);
    }*/

    @And("user add character {string} to new password part")
    public void userAddCharacterToNewPasswordPart(String newpass) {
        Driver.waitAndSendText(userPassword.newPassword,newpass);
        Driver.wait(2);

    }
    @And("user cleans the current password part")
    public void userCleansTheCurrentPasswordPart() {
        userPassword.currentPassword.clear();
        Driver.wait(2);
    }

    @And("user cleans the new password part")
    public void userCleansTheNewPasswordPart() {
        userPassword.newPassword.clear();
        Driver.wait(2);
    }
    @And("user cleans the confirmation password part")
    public void userCleansTheConfirmationPasswordPart() {
        userPassword.confirmationPassword.clear();
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is one")
    public void userVerifiesThePasswordStrengthBarIsOne() {
        Assert.assertTrue(userPassword.passwordStrength1.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is two")
    public void userVerifiesThePasswordStrengthBarIsTwo() {
        Assert.assertTrue(userPassword.passwordStrength2.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is four")
    public void userVerifiesThePasswordStrengthBarIsFour() {
        Assert.assertTrue(userPassword.passwordStrength4.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is five")
    public void userVerifiesThePasswordStrengthBarIsFive() {
        Assert.assertTrue(userPassword.passwordStrength5.isDisplayed());
        Driver.wait(2);
    }

    @And("user sends current password {string} to new password part")
    public void userSendsCurrentPasswordToNewPasswordPart(String newPass) {
        Driver.waitAndSendText(userPassword.newPassword,newPass);
        Driver.wait(2);
    }

    @And("user sends current password {string} to confirmation password part")
    public void userSendsCurrentPasswordToConfirmationPasswordPart(String confirmationPass) {
        Driver.waitAndSendText(userPassword.confirmationPassword,confirmationPass);
        Driver.wait(2);
    }

    @Then("user sees the success message on the toast container box as a BUG")
    public void userSeesTheSuccessMessageOnTheToastContainerBoxAsABUG() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(6000);
    }

    @And("user verifies the success message on the toast container box")
    public void userVerifiesTheSuccessMessageOnTheToastContainerBox() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(6000);
    }

    @Then("user close the driver")
    public void userCloseTheDriver() {
        Driver.closeDriver();
    }

}
