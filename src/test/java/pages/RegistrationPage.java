package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement loginDropdown;
    @FindBy(linkText = "Register")
    public WebElement registerButton;
    @FindBy(id = "ssn")
    public WebElement ssnTextBox;
    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;
    @FindBy(id = "username")
    public WebElement userNameTextBox;
    @FindBy(id = "email")
    public WebElement emailTextBox;
    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextBox;
    @FindBy(id = "secondPassword")
    public WebElement secondPasswordTextBox;
    @FindBy(id = "register-submit")
    public WebElement registerSubmitButton;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement errorSsnMessage;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement errorFirstNameMessage;
    @FindBy(xpath = "//div[@class='invalid-feedback'])[2]")
    public WebElement errorLastNameMessage;
    @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
    public WebElement passwordStrength3;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')]")
    public WebElement passwordStrength4;
    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement yourEmailIsRequiredMessage;
    @FindBy(xpath = "//*[text()='Your username is required.']")
    public  WebElement usernameIsRequiredMessage;
    @FindBy(xpath = "//*[.='This field is invalid']")
    public WebElement thisFieldIsInvalidMessage;
}