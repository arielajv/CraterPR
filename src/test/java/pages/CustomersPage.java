package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class CustomersPage {
    public CustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//h3[text()='Customers']")
    public WebElement customer_page_Customers_TextHeader;

    @FindBy (xpath = "//button[text()=' New Customer']")
    public WebElement customer_page_NewCustomerBTN;

    @FindBy (xpath = "//h6[text()='Basic Info']")
    public WebElement basicTextLabel;

    @FindBy (xpath = "//label[text()='No customers yet!']")
    public WebElement customer_page_NoCustomersYet_text;

    @FindBy (xpath = "(//input[@name='name'])[1]")
    public WebElement customer_page_BasicInfo_DisplayName_Field;

    @FindBy (xpath = "(//div[@class='relative rounded-md shadow-sm font-base']/input)[2]")
    public WebElement customer_page_BasicInfo_PrimaryContactName_Field;

    @FindBy (xpath = "(//input[@name='phone'])[1]")
    public WebElement customer_page_BasicInfo_Phone_Field;

    @FindBy (xpath = "//button[text()=' Copy from Billing']")
    public WebElement customer_page_NewCustomer_CopyfromBilling_BTN;

    @FindBy (xpath = "//h6[text() = ' Sales and Expenses']")
            public WebElement customer_page_NewCustomer_SalesExpenses_header;



    @FindBy (xpath = "(//div//child::input[@type='text'])[6]")
    public WebElement customer_page_BasicInfo_PrimaryCurrency_Field;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement customer_page_BasicInfo_Email_Field;

    @FindBy (xpath = "//input[@type='url']")
    public WebElement customer_page_BasicInfo_Website_Field;

    @FindBy (xpath = "(//input[@name='name'])[2]")
    public WebElement customer_page_BasicInfo_Prefix_Field;

    @FindBy (xpath = "//label[text()='No customers yet!']")
    public WebElement customer_page_NoCustomersYet;

    @FindBy (xpath="//table")
    public WebElement customer_page_CustomerTable;

    @FindBy (xpath="//th[text()='Name ']")
    public WebElement customer_page_NameField;

    @FindBy (xpath="//th[text()='Phone ']")
    public WebElement customer_page_PhoneField;

    @FindBy (xpath="//th[text()='Amount Due ']")
    public WebElement customer_page_Amount_Due;

    @FindBy (xpath="//th[text()='Added On ']")
    public WebElement customer_page_Added_On;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement customer_page_NewCustomerSubmit_BTN;

    @FindBy (xpath = "/html/body/div/main/div/div/form/div[1]/div[2]/div/button")
    public WebElement customer_page_saveCustomer_BTN;

@FindBy (xpath="//p[text()='Customer created successfully']")
    public WebElement customer_page_Customer_Creation_Successful_Msg;

    @FindBy (xpath = "(//button[contains(@id, 'headlessui')])[4]")
    public WebElement customer_page_New_Customer_3dotMoreLink;

    @FindBy (xpath = "//button[text()='Ok']")
    public WebElement customer_page_customerTable_3dotMoreLink_Delete_OK_BTN;

    @FindBy (xpath="//a[text()=' Delete']")
    public WebElement customer_page_customerTable_3dotMoreLink_Delete;

    @FindBy (xpath = "//span[text()='Field is required']")
    public WebElement customer_page_newCustomer_FieldsRequired_Error_message;

    @FindBy (xpath = "(//div[text()='Select Country'])[1]")
    public WebElement customer_page_newCustomer_Billing_CountryField;

    @FindBy (xpath = "(//input[@name='address_name'])[1]")
    public WebElement customer_page_newCustomer_Billing_NameField;

    @FindBy (xpath = "//input[@name='billing.state']")
    public WebElement customer_page_newCustomer_Billing_StateField;

    @FindBy (xpath = "//input[@name=\'billing.city\']")
    public WebElement customer_page_newCustomer_Billing_CityField;

    @FindBy (xpath = "(//input[@name=\"zip\"])[1]")
    public WebElement customer_page_newCustomer_Billing_ZipcodeField;

    @FindBy (xpath = "//button[text()=' Copy from Billing']")
    public WebElement customer_page_newCustomer_CopyFromBillingBTN;

    @FindBy (xpath = "//input[@name='address_name']")
    public WebElement customer_page_newCustomer_Shipping_NameField;

    @FindBy (xpath = "(//input[@type='text']//following-sibling::div[text()='Select Country'])[1]")
    public WebElement customer_page_newCustomer_Billing_CountryDropDown;

    @FindBy (xpath = "(//span[text()='United States'])[1]")
    public WebElement customer_page_newCustomer_Billing_CountryDropDown_UnitedStates;

    @FindBy (xpath = "//h6[text()=' Sales & Expenses']")
    public WebElement customer_page_Sales_and_Expenses_header;

    @FindBy(xpath = ("//span[text()='Name must have at least 3 letters.']"))
    public WebElement customer_page_invalidDisplay_message;

    @FindBy(xpath = ("//span[text()='Field is required']"))
    public WebElement customer_page_invalidEmpty_Display_message;

    @FindBy (xpath = "(//span[text()='Name must have at least 3 letters.'] | //span[text()='Field is required'] | //span[text()='Incorrect Email.'])")
    public List<WebElement> customer_page_all_Error_messages;
}
