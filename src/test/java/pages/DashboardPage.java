package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = " Dashboard")
    public WebElement dashboard_tab;

    @FindBy (xpath = "//a[text()=' Items']")
    public WebElement items_tab;

    @FindBy (xpath = "//a[text() = ' Customers']")
    public WebElement customers_tab;

    @FindBy (xpath = "//p[text()='Logged in successfully.']")
    public WebElement loggedInSuccess_message;


    @FindBy (xpath = "//h6[text()=' Sales & Expenses']")
    public WebElement dashboard_page_SalesAndExpensesHeader;

    @FindBy (xpath = "//span[text()='Amount Due']")
    public WebElement dashboard_page_AmountDue_Button;

    @FindBy (xpath = "//span[text()='Customers']")
    public WebElement dashboard_page_Customers_Button;

    @FindBy (xpath = "//span[text()='Invoices']")
    public WebElement dashboard_page_Invoices_Button;

    @FindBy (xpath = "//span[text()='Estimates']")
    public WebElement dashboard_page_Estimates_Button;

    @FindBy (xpath = "//h6[text()='Due Invoices']")
public WebElement dashboard_page_DueInvoices;

}