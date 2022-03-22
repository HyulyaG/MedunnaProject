package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class NavigationPageAfterLogin {
    public NavigationPageAfterLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "admin-menu")
    public WebElement administrationDropdown;
    @FindBy(xpath = "//*[.='User management']")
    public WebElement userManagementButton;
    @FindBy(id="entity-menu")
    public WebElement ItemAndTitlesDropDown;
    @FindBy(xpath="(//a[@class='dropdown-item'])[1]")
    public WebElement PatientDropDown;
    @FindBy(xpath = "(//a[@href='/patient/1051'])[2]")
    public WebElement ViewButtonPatient1051;
    @FindBy(xpath = "(//a[@href='/patient'])[2]")
    public WebElement BackButtonPatient1051;
    @FindBy(xpath = "//html[@class='no-js']" )
    public WebElement PatientVerifyPage;
    @FindBy (xpath = "(//span[@class='d-none d-md-inline'])[2]")
    public WebElement EditButtonPatient1051;
    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstNamePatientEditBox;
    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement lastNamePatientEditBox;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement eMailPatientEditBox;
    @FindBy (xpath = "//*[@id='patient-birthDate']")
    public WebElement BirthDateBox;
    @FindBy (xpath="//*[@id='patient-phone']")
    public WebElement phonePatientEditBox;
    @FindBy(xpath="//*[@id='patient-gender']")
    public WebElement genderDropDown;
    @FindBy(id="patient-bloodGroup")
    public WebElement bloodGroupDropDown;
    @FindBy (id="patient-adress")
    public WebElement patientAddressBox;
    @FindBy (id="patient-description")
    public WebElement patientDescriptionBox;
    @FindBy(name = "user.id")
    public WebElement userTypeDropDown;
    @FindBy (id="patient-country")
    public WebElement patientCountry;
    @FindBy(id="patient-cstate")
    public WebElement stateOrCityDropDown;
    @FindBy (id="save-entity")
    public WebElement savePatientDataButton;
    @FindBy (id="cancel-save")
    public WebElement backPatientDataButton;
    @FindBy (id="//div[@class='app-container']")
    public WebElement allPatientsListPage;
    @FindBy (xpath = "//a[@href='/patient/1051/delete?page=1&sort=id,asc']")
    public WebElement deletePatientButton;
    @FindBy (id="jhi-confirm-delete-patient")
    public WebElement deletePatientConfirmButton;
    @FindBy (xpath = "//li[@id='entity-menu']")
    public WebElement myPagesDropDownButton;
    @FindBy (xpath = "(//a[@href='/search-patient'])[1]")
    public WebElement searchBoxDropDown;
    @FindBy (xpath = "//a[@href='/patient-detail/5552']")
    public WebElement getViewButtonPatient5552;
    @FindBy (id = "app-view-container")
    public WebElement getPatientVerifyPageByStaff;
    @FindBy (id ="account-menu")
    public WebElement accountDropDownButton;
    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement signOffButtonDropDown;
    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement searchBoxStaffView;
}

