package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class User08_UserPasswordPage {
    public User08_UserPasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement dropdown;
    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement homePageSignIn;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "(//*[.=\"Sign in\"])[5]")
    public WebElement signInPageSignInButton;
    @FindBy(id = "account-menu")
    public WebElement accountMenu;
    @FindBy(xpath = "//*[.='Password']")
    public WebElement passwordButton;
    @FindBy(id = "currentPassword")
    public WebElement currentPassword;
    @FindBy(id = "newPassword")
    public WebElement newPassword;
    @FindBy(id = "confirmPassword")
    public WebElement confirmationPassword;
    @FindBy(xpath = "(//*[.='Save'])[2]")
    public WebElement saveButton;
    @FindBy(xpath = "(//*[.='Password changed!'])[3]")
    public WebElement successMessage;
    @FindBy(xpath = "//*[.='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
    public WebElement passwordStrength4;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')]")
    public WebElement passwordStrength5;

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

}
