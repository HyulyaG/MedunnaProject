package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {

    public AppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//*[.='Make an Appointment'])[2]")
    public WebElement appointmentButton;

    @FindBy(id = "firstName")
    public WebElement firstNameBox;

    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "phone")
    public WebElement phoneTextBox;

    @FindBy(name = "appoDate")
    public WebElement dateTextBox;

    @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement requestButton;

    @FindBy(xpath = "//*[text()='Appointment registration saved!']")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//*[contains(text(),'Your FirstName is required.')]")
    public WebElement alertMessageFirstName;

    @FindBy(xpath = "//*[contains(text(),'Your LastName is required.')]")
    public WebElement alertMessageLastName;


    @FindBy(xpath = "//*[contains(text(),'Your SSN is invalid')]")
    public WebElement alertMessageSSNInvalid;


    @FindBy(xpath = "//*[contains(text(),'This field is invalid')]")
    public WebElement alertMessageEmailInvalid;

    @FindBy(xpath = "//*[contains(text(),'Phone number is invalid')]")
    public WebElement alertMessagePhoneNumberInvalid;

    @FindBy (xpath = "//*[@aria-haspopup='true']")
    public WebElement loginDropdown;

    @FindBy (xpath = "//*[text()='Sign in']")
    public WebElement signInButton;

    @FindBy (name = "username")
    public WebElement userNameTextBox;

    @FindBy (name = "password")
    public WebElement passwordTextBox;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement signinbutton;

    @FindBy (xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesDropdown;

    @FindBy (xpath = "(//*[@role='menuitem'])[1]")
    public WebElement myAppointmentsButton;

    @FindBy (css = "#appointment-heading")
    public WebElement appointmentHeading;



}


