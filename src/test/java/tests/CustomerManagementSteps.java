package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.ItemsPage;
import pages.LoginPage;
import utils.BrowserUtilityClass;
import utils.Driver;
import utils.TestDataReader;

import static tests.CraterLoginTest.browserUtilityClass;
import static utils.Driver.driver;

public class CustomerManagementSteps {

    BrowserUtilityClass utils = new BrowserUtilityClass();
    DashboardPage dashboardPage = new DashboardPage();
    CustomersPage customersPage = new CustomersPage();
    LoginPage loginPage = new LoginPage();

    ItemsPage itemsPage = new ItemsPage();

    static String name;

    @When("I navigate to the customers tab")
    public void i_navigate_to_the_customers_tab() {
        utils.waitForElementToBeVisible(dashboardPage.customers_tab);
        dashboardPage.customers_tab.click();
        utils.waitForElementToBeVisible(customersPage.customer_page_Customers_TextHeader);
        Assert.assertTrue(customersPage.customer_page_Customers_TextHeader.isDisplayed());

    }

    @Then("I should see the New Customer button displayed")
    public void i_should_see_the_new_customer_button_displayed() {
        Assert.assertTrue(customersPage.customer_page_NewCustomerBTN.isDisplayed());
        Driver.quitDriver();

    }

    //Verification of Basic Info label present
    @Then("I click on the New Customer button")
    public void i_click_on_the_new_customer_button() {
        utils.waitForElementToBeVisible(customersPage.customer_page_NewCustomerBTN);
        customersPage.customer_page_NewCustomerBTN.click();
    }

    @Then("I verify that a Basic info form label is present")
    public void i_verify_that_a_basic_info_form_label_is_present() {
        Assert.assertTrue(customersPage.basicTextLabel.isDisplayed());
    }

    //Verification of the fields
    @Then("I verify that Display Name *, Primary Contact Name, Email, Primary Currency *, Website, Prefix are present")
    public void i_verify_that_display_name_primary_contact_name_email_primary_currency_website_prefix_are_present(String displayName, String primaryContactName, String email, String primaryCurrency, String website) {
        utils.waitForElementToBeVisible(customersPage.customer_page_BasicInfo_DisplayName_Field);
        Assert.assertTrue(customersPage.customer_page_BasicInfo_DisplayName_Field.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_BasicInfo_PrimaryContactName_Field.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_BasicInfo_Email_Field.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_BasicInfo_PrimaryCurrency_Field.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_BasicInfo_Website_Field.isDisplayed());
    }

    //Verification of CustomerTableVisibility
    @Then("I verify that a customer list table is present")
    public void i_verify_that_a_customer_list_table_is_present() {
        if (customersPage.customer_page_NoCustomersYet.isDisplayed()) {
            customersPage.customer_page_NewCustomerBTN.click();
            utils.waitForElementToBeVisible(customersPage.customer_page_BasicInfo_DisplayName_Field);
            customersPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Student");
            customersPage.customer_page_NewCustomerSubmit_BTN.click();
            dashboardPage.customers_tab.click();
            utils.waitForElementToBeVisible(customersPage.customer_page_Customers_TextHeader);
            Assert.assertTrue(customersPage.customer_page_CustomerTable.isDisplayed());
        } else {
            Assert.assertTrue(customersPage.customer_page_CustomerTable.isDisplayed());

        }
    }

    //Customer Fields Verification
    @Then("I verify the four columns are present in the table Name, Phone, Amount Due, Added On")
    public void i_verify_the_four_columns_are_present_in_the_table_name_phone_amount_due_added_on() {

        Assert.assertTrue(customersPage.customer_page_NameField.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_Amount_Due.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_PhoneField.isDisplayed());
        Assert.assertTrue(customersPage.customer_page_Added_On.isDisplayed());
    }

    //Customer More Link Verification
    @Then("I verify that a More Link for the customer row with the option Edit, View, and Delete is present")
    public void i_verify_that_a_more_link_for_the_customer_row_with_the_option_edit_view_and_delete_is_present() {
        Assert.assertTrue(itemsPage.items_page_3dot_menu.isDisplayed());
    }

    //Invalid credentials test case - start
    @When("I enter invalid useremail {string} and password {string}")
    public void i_enter_invalid_useremail_and_password(String usermail, String passweord) {
        utils.sendkeysWithActionClass(loginPage.login_page_email_box, " " + usermail);
        utils.sendkeysWithActionClass(loginPage.login_page_password_box, " " + passweord);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.login_page_login_btn.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        utils.waitForAllElementsToBeVisible(loginPage.login_page_all_Error_messages);
        Assert.assertFalse(loginPage.login_page_all_Error_messages.isEmpty());
    }

    // newCustomerCreatedMessageTest - start
    @Then("I enter a display name")
    public void i_enter_a_display_name() {
        utils.waitForElementToBeVisible(customersPage.customer_page_BasicInfo_DisplayName_Field);
        customersPage.customer_page_BasicInfo_DisplayName_Field.sendKeys("Student");
    }

    @Then("click save")
    public void click_save() {
        customersPage.customer_page_NewCustomerSubmit_BTN.click();
    }

    @Then("I should see the pop up message {string}")
    public void i_should_see_the_pop_up_message(String message) {
        utils.waitForElementToBeVisible(customersPage.customer_page_Customer_Creation_Successful_Msg);
        Assert.assertEquals(customersPage.customer_page_Customer_Creation_Successful_Msg.getText(), message);
    }

    @Then("I delete the customer")
    public void i_delete_the_customer() {
        utils.waitForElementToBeVisible(dashboardPage.customers_tab);
        dashboardPage.customers_tab.click();
        utils.waitForElementToBeVisible(customersPage.customer_page_New_Customer_3dotMoreLink);
        customersPage.customer_page_New_Customer_3dotMoreLink.click();
        customersPage.customer_page_customerTable_3dotMoreLink_Delete.click();
        utils.waitForElementToBeVisible(customersPage.customer_page_customerTable_3dotMoreLink_Delete_OK_BTN);
        customersPage.customer_page_customerTable_3dotMoreLink_Delete_OK_BTN.click();
        Driver.quitDriver();
    }

    // ErrorFieldVerification test starts here
    @Then("I should see the error message {string} below the Display Name field")
    public void i_should_see_the_error_message_below_the_display_name_field(String message) {
        utils.waitForElementToBeVisible(customersPage.customer_page_newCustomer_FieldsRequired_Error_message);
        Assert.assertEquals(customersPage.customer_page_newCustomer_FieldsRequired_Error_message.getText(), message);
    }

// newCustomers test start here
@When("I enter a valid {string}, {string}, {string}, {string}, and {string}")
public void i_enter_a_valid_and(String DisplayName, String Email, String State, String City, String ZipCode) throws InterruptedException {
    name = DisplayName;

    utils.waitForElementToBeVisible(customersPage.customer_page_BasicInfo_DisplayName_Field);
    customersPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(name);
    customersPage.customer_page_BasicInfo_Email_Field.sendKeys(Email);
    customersPage.customer_page_newCustomer_Billing_NameField.sendKeys(name);
    customersPage.customer_page_newCustomer_Billing_CityField.sendKeys(City);
    customersPage.customer_page_newCustomer_Billing_ZipcodeField.sendKeys(ZipCode);
    utils.clickWithActionsClass(customersPage.customer_page_newCustomer_Billing_CountryDropDown);
    utils.waitForElementToBeVisible(customersPage.customer_page_newCustomer_Billing_CountryDropDown_UnitedStates);
    utils.clickWithActionsClass(customersPage.customer_page_newCustomer_Billing_CountryDropDown_UnitedStates);
    utils.clickWithActionsClass(customersPage.customer_page_newCustomer_CopyFromBillingBTN);
    utils.moveToWithActionsClass(customersPage.customer_page_NewCustomerSubmit_BTN);
    utils.waitUntilElementClickable(customersPage.customer_page_NewCustomerSubmit_BTN);
    customersPage.customer_page_NewCustomerSubmit_BTN.click();
}
    @Then("I view the saved customer in the Customers Table")
    public void i_view_the_saved_customer_in_the_customers_table() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[contains(text(), '" + name + "')]")).isDisplayed());
    }

//New Customer Invalid Credential test starts here
@And("I enter Display Name {string} and Email {string}")
public void i_enter_display_name_and_email(String DisplayName, String Email) throws InterruptedException {
    utils.waitForElementToBeVisible(customersPage.customer_page_BasicInfo_DisplayName_Field);
    customersPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(DisplayName);
    customersPage.customer_page_BasicInfo_DisplayName_Field.sendKeys(Email);
    customersPage.customer_page_NewCustomerSubmit_BTN.click();
    Thread.sleep(500);

}

    @Then("I should see error messages")
    public void i_should_see_error_messages() {
        boolean usErrorVisible = false;
        for (WebElement errorMessage : customersPage.customer_page_all_Error_messages) {
            if (errorMessage.isDisplayed()) {
                usErrorVisible = true;
                break;
            }
        }

        Assert.assertTrue(usErrorVisible);
        Driver.quitDriver();
    }}

