package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="ssn")
    public WebElement ssnTextBox;
    @FindBy(id = "firstName")
    public WebElement firstnameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastnameTextBox;
    @FindBy(id = "username")
    public WebElement usernameTextBox;
    @FindBy(id = "email")
    public WebElement emailTextbox;
    @FindBy(xpath = "//*[text()='New password']/following::input")
    public WebElement firstPasswordTextBox;
    @FindBy(id= "secondPassword")
    public WebElement newPasswordTextBox;
    @FindBy(id = "register-submit")
    public WebElement registerButton;


}
