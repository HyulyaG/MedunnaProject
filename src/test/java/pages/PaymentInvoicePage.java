package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class PaymentInvoicePage {
    public PaymentInvoicePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[contains(text(),'Exam Fee')]")
    public WebElement examFeeTxt;
    @FindBy (xpath = "//*[contains(text(),'500')]")
    public WebElement examFeePrice;
    @FindBy (xpath = "//*[contains(text(),'98.5')]")
    public WebElement diabetesFee;
    @FindBy (xpath = "//*[contains(text(),'116')]")
    public WebElement theoTestFee;
    @FindBy (xpath = "//*[contains(text(),'119')]")
    public WebElement nickyTestFee;
    @FindBy (xpath = "//*[contains(text(),'Create')]")
    public WebElement createInvoiceButton;
    @FindBy (id = "save-entity")
    public WebElement saveButton;
    @FindBy (xpath = "//*[@class='Toastify__toast-body']")
    public WebElement invoiceSuccessMessage;
    @FindBy (xpath = "//*[contains(text(),'Invoice')]")
    public WebElement showInvoiceButton;
    @FindBy (xpath = "//*[text()='INVOICE']")
    public WebElement invoicePageHeader;
}
