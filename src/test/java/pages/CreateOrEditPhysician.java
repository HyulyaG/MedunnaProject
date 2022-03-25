package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditPhysician {

    public CreateOrEditPhysician(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement adminItemsAndTitlesDropdown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement physicianDropdownItem;

    @FindBy(id = "physician-heading")
    public WebElement physicianHeader;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewPhycisianButton;

    @FindBy(id = "useSSNSearch")
    public WebElement useSsnSearCheckBox;

//    @FindBy(xpath = "(//*[text()='SSN']//following::input)[1]")
//    public WebElement ssnTextBox;

    @FindBy(id = "searchSSN")
    public WebElement ssnTextBox;

    @FindBy(xpath = "//*[text()='Search User']")
    public WebElement searchUserButton;

    @FindBy(xpath = "(//*[@class='form-group']//following::input)[2]")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "(//*[@class='form-group']//following::input)[3]")
    public WebElement lastNameTextBox;

    @FindBy(id = "physician-birthDate")
    public WebElement physicianBirthDay;

    @FindBy(id = "physician-speciality")
    public WebElement physicianSpecialityDropDropdown;

    @FindBy(id = "file_image")
    public WebElement chooseFileButton;

    @FindBy(name = "user.id")
    public WebElement userIdDropdown;

    @FindBy(id = "physician-examFee")
    public WebElement examFee;

    @FindBy(id = "physician-gender")
    public WebElement physicianGender;


    @FindBy(id = "physician-country")
    public WebElement physicianCountry;

    @FindBy(id = "physician-cstate")
    public WebElement physicianState;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[.='Create or edit a Physician'])[4]")
    public WebElement createOrEditAPhysicianHeader;

    @FindBy(id = "physician-description")
    public WebElement physicianDescription;

    @FindBy(id = "physician-phone")
    public WebElement physicianPhone;









}