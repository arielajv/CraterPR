package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy(linkText = "Dashboard")
public WebElement dashboard;


    @FindBy(linkText = "Customers")
    public WebElement customers;

    @FindBy(linkText = "Items")
    public WebElement items;

    @FindBy(linkText = "Estimates")
    public WebElement estimates;

    @FindBy(linkText = "Invoices")
    public WebElement invoices;

    @FindBy(linkText = "Recurring Invoices")
    public WebElement recurringInvoices;

    @FindBy(linkText = "Payments")
    public WebElement payments;

    @FindBy(linkText = "Expenses")
    public WebElement expenses;

    @FindBy(linkText = "Reports")
    public WebElement reports;

    @FindBy(linkText = "Settings")
    public WebElement settings;


}
