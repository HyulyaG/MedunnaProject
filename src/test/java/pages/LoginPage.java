package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="account-menu")
    public WebElement loginDropdown;
    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//span[.='Cancel']")
    public WebElement cancel;
    @FindBy(id = "rememberMe")
    public WebElement rememberMe;
    @FindBy(xpath = "//span[.='Did you forget your password?']")
    public WebElement forgetPassword;
    @FindBy(xpath = "(//*[text()='Register'])[1]")
    public WebElement registerButton;

    public void loginApplication(String userName, String pass){
        loginDropdown.click();
        signInButton.click();
        username.sendKeys(userName);
        password.sendKeys(pass);
        loginButton.click();
        cancel.click();
        rememberMe.click();
        forgetPassword.click();
        registerButton.click();
    }
}
