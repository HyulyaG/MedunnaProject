package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSettingsPage {
    public UserSettingsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "account-menu")
    public WebElement account_menu;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settignsButton;

    @FindBy(id = "settings-title")
    public WebElement settingsForUserText;

    @FindBy(id = "firstName")
    public WebElement settingsFirstName;

    @FindBy(id = "lastName")
    public WebElement settingsLastName;

    @FindBy(id = "email")
    public WebElement settingsEmail;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement settingsSaveButton;

    @FindBy(xpath = "//*[text()='Settings saved!']")
    public WebElement settingsSaveAlert;

    @FindBy(xpath = "//div[text()='Your first name is required.']")
    public WebElement firstNameIsRequiredText;

    @FindBy(xpath = "//div[text()='Your last name is required.']")
    public WebElement lastNameIsRequiredText;

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailIsRequiredText;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement emailInvalidText;

}