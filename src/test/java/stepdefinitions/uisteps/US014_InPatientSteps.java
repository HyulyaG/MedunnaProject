package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import pages.DoctorPage;
import pages.US014_InPatientPage;
import utilities.Driver;

public class US014_InPatientSteps {
    US014_InPatientPage inPatientPage=new US014_InPatientPage();
    DoctorPage doctorPage=new DoctorPage();

    @Given("Doctor clicks on My InpatientButton")
    public void doctor_clicks_on_my_inpatient_button() {

    Driver.waitAndClick(inPatientPage.myInPatientButton,3);
            }

    @And("Doctor changes the start and end days to see InPatient information")
    public void doctorChangesTheStartAndEndDaysToSeeInPatientInformation() throws InterruptedException {
        Thread.sleep(1000);
        inPatientPage.inPatientFromDate.clear();
        Driver.clickWithJS(inPatientPage.inPatientFromDate);
        Thread.sleep(1000);
        Driver.waitAndSendText(inPatientPage.inPatientFromDate,"01Mar");
        inPatientPage.inPatientFromDate.sendKeys(Keys.ARROW_RIGHT);
        Driver.waitAndSendText(inPatientPage.inPatientFromDate,"002022");
        Thread.sleep(1000);

        inPatientPage.inPatientToDate.clear();
        Driver.clickWithJS(inPatientPage.inPatientToDate);
        Thread.sleep(1000);
        Driver.waitAndSendText(inPatientPage.inPatientToDate,"15Mar");
        inPatientPage.inPatientToDate.sendKeys(Keys.ARROW_RIGHT);
        Driver.waitAndSendText(inPatientPage.inPatientToDate,"002022");
        Thread.sleep(1000);

    }

    @And("Doctor clicks on Edit button for InPatients")
    public void doctorClicksOnEditButtonForInPatients() {
        Driver.waitAndClick(inPatientPage.inPatientEditButton,3);
    }

    @Then("Doctor should see and verify all InPatient information")
    public void doctor_should_see_and_verify_all_in_patient_information() {
        Driver.wait(3);

        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientID,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientStartDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientEndDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientStatus,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientDescription,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientCreatedDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientRoom,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientAppointmentID,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.inPatientPatientName,3).isDisplayed());
    }


    @Then("Doctor can update all InPatient information")
    public void doctorCanUpdateAllInPatientInformation() throws InterruptedException {
        Driver.waitAndClick(inPatientPage.editPatientStartDate);
        Thread.sleep(1000);
        Driver.waitAndSendText(inPatientPage.editPatientStartDate,"21Apr");
        inPatientPage.editPatientStartDate.sendKeys(Keys.ARROW_RIGHT);
        Driver.waitAndSendText(inPatientPage.editPatientStartDate,"0020221030PM");
        Thread.sleep(1000);

        Driver.waitAndClick(inPatientPage.editInPatientEndDate);
        Thread.sleep(1000);
        Driver.waitAndSendText(inPatientPage.editInPatientEndDate,"26Jun");
        inPatientPage.editInPatientEndDate.sendKeys(Keys.TAB);
        Driver.waitAndSendText(inPatientPage.editInPatientEndDate,"0020221115PM");
        Thread.sleep(1000);

        Driver.waitAndSendText(inPatientPage.editInPatientDescription,"paracetamol",3);
        Thread.sleep(2000);
//        inPatientPage.editInPatientDescription.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(2000);
//        inPatientPage.inPatientCreatedDate.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(2000);


        Driver.clickWithJS(inPatientPage.editInPatientCreatedDate);
        Driver.waitAndSendText(inPatientPage.editInPatientCreatedDate,"25Feb",1);
        inPatientPage.editInPatientCreatedDate.sendKeys(Keys.TAB);
        Driver.waitAndSendText(inPatientPage.editInPatientCreatedDate,"0020220923AM");
        Thread.sleep(1000);

    }

    @Then("Doctor can especially update status of InPatient")
    public void doctorCanEspeciallyUpdateStatusOfInPatient() {


        Driver.waitAndClick(inPatientPage.editInPatientStatus);
        Driver.selectAnItemFromDropdown(inPatientPage.editInPatientStatus,"UNAPPROVED");
        Driver.clickWithJS(inPatientPage.inPatientSaveButton);
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.toastContainerErrorMessage,2).isDisplayed());

        Driver.waitAndClick(inPatientPage.editInPatientStatus);
        Driver.selectAnItemFromDropdown(inPatientPage.editInPatientStatus,"STAYING");
        Driver.clickWithJS(inPatientPage.inPatientSaveButton);
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.toastContainerErrorMessage,2).isDisplayed());

        Driver.waitAndClick(inPatientPage.editInPatientStatus);
        Driver.selectAnItemFromDropdown(inPatientPage.editInPatientStatus,"CANCELLED");
        Driver.clickWithJS(inPatientPage.inPatientSaveButton);
        Assert.assertTrue(Driver.waitForVisibility(inPatientPage.toastContainerErrorMessage,2).isDisplayed());

    }

    @Then("Doctor closes the driver")
    public void doctorClosesTheDriver() {

        Driver.closeDriver();
    }




}
