package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US014_InPatientPage {
    public US014_InPatientPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[.='My Inpatients']")
    public WebElement myInPatientButton;

    @FindBy(id = "fromDate")
    public WebElement inPatientFromDate;
    @FindBy(id = "fromDate")
    public WebElement inPatientToDate;

    @FindBy(xpath = "(//tbody/tr/td[1])[1]")
    public WebElement inPatientID;
    @FindBy(xpath = "(//tbody/tr/td[2])[1]")
    public WebElement inPatientStartDate;
    @FindBy(xpath = "(//tbody/tr/td[3])[1]")
    public WebElement inPatientEndDate;
    @FindBy(xpath = "(//tbody/tr/td[4])[1]")
    public WebElement inPatientStatus;
    @FindBy(xpath = "(//tbody/tr/td[5])[1]")
    public WebElement inPatientDescription;
    @FindBy(xpath = "(//tbody/tr/td[6])[1]")
    public WebElement inPatientCreatedDate;
    @FindBy(xpath = "(//tbody/tr/td[7])[1]")
    public WebElement inPatientRoom;
    @FindBy(xpath = "(//tbody/tr/td[8])[1]")
    public WebElement inPatientAppointmentID;
    @FindBy(xpath = "(//tbody/tr/td[9])[1]")
    public WebElement inPatientPatientName;
    @FindBy(xpath = "(//*[.='Edit'])[1] ")
    public WebElement inPatientEditButton;
    @FindBy(id="in-patient-id")
    public WebElement editInPatientID;
    @FindBy(id = "in-patient-startDate")
    public WebElement editPatientStartDate;
    @FindBy(id = "in-patient-endDate")
    public WebElement editInPatientEndDate;
    @FindBy(id = "in-patient-description")
    public WebElement editInPatientDescription;
    @FindBy(id = "in-patient-createdDate")
    public WebElement editInPatientCreatedDate;
    @FindBy(id = "in-patient-appointment")
    public WebElement editInPatientAppointmentID;
    @FindBy(id = "in-patient-status")
    public WebElement editInPatientStatus;
    @FindBy(id = "in-patient-room")
    public WebElement editInPatientRoom;
    @FindBy(xpath = "//*[.='InPatient status can not be changed with this type of status']")
    public WebElement toastContainerErrorMessage;
    @FindBy(xpath ="//*[.='Save']")
    public WebElement inPatientSaveButton;







}
