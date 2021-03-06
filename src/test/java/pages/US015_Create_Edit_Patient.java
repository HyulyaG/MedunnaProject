package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US015_Create_Edit_Patient {

    public US015_Create_Edit_Patient(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuButton;

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerMenuButton;

    @FindBy(xpath = "//*[@id='register-title']")
    public WebElement registrationTitle;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordBox;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li[5]")
    public WebElement fifthStrengthBar;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li")
    public List<WebElement> strengthsBar;

    @FindBy(xpath = "//div[text()='Your password is required to be at least 4 characters.']")
    public WebElement passwordInvalid4Char;

    @FindBy(id = "login-item")
    public WebElement signInMenuButton;

    @FindBy(xpath = "//h5")
    public WebElement signInTitleText;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;

    @FindBy(xpath = "//*[text()='User Recep']")
    public WebElement adminNameHomePage;

    @FindBy(xpath = "//a[@href='/account/password']")
    public WebElement passwordMenuButton;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutMenuButton;

    @FindBy(id = "password-title")
    public WebElement passwordTitleText;

    @FindBy(id = "currentPassword")
    public WebElement currentPasswordBox;

    @FindBy(id = "newPassword")
    public WebElement newPasswordBox;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement saveSubmitButton;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public  WebElement passwordChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'The password could not be changed')]")
    public  WebElement passwordNotChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'at least 4 characters')]")
    public  WebElement passwordMoreThanFourMessage;

    @FindBy(xpath = "//*[contains(text(),'confirmation do not match!')]")
    public  WebElement passwordNotMatchMessage;

    @FindBy(xpath = "//*[text()='New password confirmation']")
    public  WebElement passwordShouldBeConfirmMessage;

    @FindBy(xpath = "//div[text()='Your password is required.']")
    public  WebElement passwordIsRequiredMessage;

    @FindBy(xpath = "//div[text()='Authentication information not correct.']")
    public  WebElement passwordInformationIncorrectMessage;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement itemsTitlesMenu;

    @FindBy(xpath = "//span[text()='Patient']")
    public WebElement patientMenuInItems;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewPatientVerify;

    @FindBy(xpath = "(//span[text()='View'])[1]")
    public WebElement viewButtonOfFirstPatient;

    @FindBy(xpath = "//span[text()='SSN']")
    public WebElement ssnTitleVerify;

    @FindBy(xpath = "//span[text()='First Name']")
    public WebElement firstNameTitleVerify;

    @FindBy(xpath = "//span[text()='Last Name']")
    public WebElement lastNameTitleVerify;

    @FindBy(xpath = "//span[text()='Birth Date']")
    public WebElement birthDateTitleVerify;

    @FindBy(xpath = "//span[text()='Phone']")
    public WebElement phoneTitleVerify;

    @FindBy(xpath = "//span[text()='Gender']")
    public WebElement genderTitleVerify;

    @FindBy(xpath = "//span[text()='Blood Group']")
    public WebElement bloodGroupTitleVerify;

    @FindBy(xpath = "//span[text()='Address']")
    public WebElement addressTitleVerify;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement descriptionTitleVerify;

    @FindBy(xpath = "//span[text()='Created Date']")
    public WebElement createdDateTitleVerify;

    @FindBy(xpath = "//span[text()='User']")
    public WebElement userTitleVerify;

    @FindBy(xpath = "//dt/span[text()='Country']")
    public WebElement countryTitleVerify;

    @FindBy(xpath = "//span[text()=' State/City']")
    public WebElement stateCityTitleVerify;

    @FindBy(xpath = "//dt/span")
    public List<WebElement> patientInformationInView;

    @FindBy(xpath = "//div/label/span")
    public List<WebElement> patientInformationInEdit;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButtonOfFirstPatient;

    @FindBy(xpath = "//td[13]")
    public List<WebElement> userInformationInTable;

    @FindBy(xpath = "//span[text()='Delete']")
    public List<WebElement> deleteButtonInTable;

    @FindBy(xpath = "//a[@aria-label='Next']")
    public WebElement pageNumberGoNext;

    @FindBy(xpath = "//*[@id=\"jhi-confirm-delete-patient\"]/span")
    public WebElement deleteButtonForAPatient;

    @FindBy(xpath = "//*[contains(text(),'A Patient is deleted with identifier')]")
    public WebElement deleteVerifyMessage;



}