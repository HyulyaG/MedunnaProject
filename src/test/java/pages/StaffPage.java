package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class StaffPage {
    public StaffPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesDropdown;
    @FindBy (xpath = "(//*[@role='menuitem'])[1]")
    public WebElement searchPatientButton;
    @FindBy (name = "ssn")
    public WebElement patientSSNTextBox;
    @FindBy (xpath = "//*[contains(text(),'Appointments')]")
    public WebElement showAppointmentsButton;
    @FindBy (xpath = "(//*[text()='COMPLETED'])[1]")
    public WebElement completedText;
    @FindBy (xpath = "(//*[contains(text(),'Payment')])[1]")
    public WebElement paymentInvoiceButton;
}
