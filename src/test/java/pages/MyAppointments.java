package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class MyAppointments {
    public MyAppointments(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[contains(text(),'MY PAGES')]")
    public WebElement myPagesDropdown;
    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointments;
    @FindBy(xpath = "(//*[text()='Edit'])[4]")
    public WebElement editButton;
    @FindBy(linkText= "Request A Test")
    public WebElement requestATestButton;
    @FindBy(id = "1402")
    public WebElement ureaCheckBox;
    @FindBy(id ="1403" )
    public WebElement creatininCheckBox;
    @FindBy(id ="1404" )
    public WebElement sodiumCheckBox;
    @FindBy(id ="1405" )
    public WebElement potassiumCheckBox;
    @FindBy(id ="1406" )
    public WebElement totalProteinCheckBox;
    @FindBy(id ="1407" )
    public WebElement albuminCheckBox;
    @FindBy(id ="1408" )
    public WebElement hemoglobinCheckBox;
    @FindBy(id ="1401" )
    public WebElement glucoseCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;
    @FindBy(className = "Toastify")
    public WebElement toastContainerSuccessMessage;
    @FindBy(id = "appointment-heading")
    public WebElement appointmentHeader;
}
