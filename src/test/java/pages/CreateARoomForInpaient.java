package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateARoomForInpaient {

    public CreateARoomForInpaient() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="entity-menu")
    public WebElement ItemTitlesDropDown;

    @FindBy(xpath="(//a[@class='dropdown-item'])[6]")
    public WebElement RoomNavigateDropDown;

    @FindBy(id = "jh-create-entity")
    public WebElement createARoomButton;

    @FindBy(xpath = "//*[text()='Create or edit a Room']")
    public WebElement createARoomTittle;

    @FindBy(xpath = "//input[@id='room-roomNumber']")
    public WebElement roomNumber;

    @FindBy(xpath = "//div[text()='This field should be a number.']")
    public WebElement invalidRoomNumberMessage;

    @FindBy(xpath = "//select[@name='roomType']")
    public WebElement roomTypeDropDown;

    @FindBy(xpath = "//input[@name='status']")
    public WebElement statusCheckBox;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;

    @FindBy(xpath = "//*[text()='This field should be at least 0.']")
    public WebElement invalidPriceMessage;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement description;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createDateForStay;

    @FindBy( xpath = "//button[@type='submit']")
    public WebElement submitButtonForRoom;

    @FindBy(id = "room-heading']")
    public WebElement validMessageForRoomCreated;

    @FindBy (xpath ="((//li[@class='page-item'])[4]")
    public WebElement page9;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewRoomButtonAfterEdit;

    @FindBy(xpath = "(//[text()='12345']")
    public WebElement verifiedRoom12345;

    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement signOutButtonDropDown;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButtonForPatientwithId1451;

}
