package tests;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DashboardPage;
import utils.BrowserUtilityClass;
import utils.Driver;

public class dahboardManagement_steps {
    BrowserUtilityClass utils = new BrowserUtilityClass();
    DashboardPage dashboardPage = new DashboardPage();

    @Then("I should be on the Dashboard home page")
    public void i_should_be_on_the_dashboard_home_page() {
        System.out.println(Driver.getDriver().getTitle());

    }

    @Then("I should see the header {string}")
    public void i_should_see_the_header(String string) {
        utils.waitForElementToBeVisible(dashboardPage.dashboard_page_SalesAndExpensesHeader);
        Assert.assertTrue(dashboardPage.dashboard_page_SalesAndExpensesHeader.isDisplayed());
        Driver.quitDriver();

    }

    @Then("I should see the buttons {string}, {string}, {string}, and {string}")
    public void i_should_see_the_buttons_and(String amountDue, String customers, String invoices, String estimates) {
        if (dashboardPage.dashboard_page_AmountDue_Button.getText().contains(amountDue)) {
            Assert.assertTrue(true);
        }

        if (dashboardPage.dashboard_page_Customers_Button.getText().contains(customers)) {
            Assert.assertTrue(true);
        }

        if (dashboardPage.dashboard_page_Invoices_Button.getText().contains(invoices)) {
            Assert.assertTrue(true);
        }

        if (dashboardPage.dashboard_page_Estimates_Button.getText().contains(estimates)) {
            Assert.assertTrue(true);
        }
    }}
