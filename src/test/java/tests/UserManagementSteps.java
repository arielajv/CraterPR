package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BrowserUtilityClass;
import utils.Driver;
import utils.TestDataReader;

import java.time.Duration;

public class UserManagementSteps {

    BrowserUtilityClass utils = new BrowserUtilityClass();
    LoginPage loginpage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    //valid credential login test
    @Given("As a user, I am on the login page")
    public void as_a_user_i_am_on_the_login_page() {
        Driver.getDriver().get(TestDataReader.getProperty("craterurl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
        utils.waitForElementToBeVisible(loginpage.login_page_email_box);

    }
    @When("I enter valid usermail and valid password")
    public void i_enter_valid_usermail_and_valid_password() {
        utils.sendkeysWithActionClass(loginpage.login_page_email_box, TestDataReader.getProperty("email"));
        utils.sendkeysWithActionClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
        // Write code here that turns the phrase above into concrete actions
    }
    @When("Click on login button")
    public void click_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginpage.login_page_login_btn.click();
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        utils.waitUntilElementVisibleWithLocator(By.xpath("//span[text()='Amount Due']"));
        Assert.assertTrue(dashboardPage.dashboard_tab.isDisplayed());
    }

    // invalid email login attempt - start
    @When("I enter invalid username and valid password")
    public void i_enter_invalid_username_and_valid_password() {
        utils.sendkeysWithActionClass(loginpage.login_page_email_box, "yummy@primetechschool.com");
        utils.sendkeysWithActionClass(loginpage.login_page_password_box, TestDataReader.getProperty("password"));
    }

    @Then("I should see an error message {string} displays")
    public void i_should_see_an_error_message_displays(String errorMessage) {
        utils.waitForElementToBeVisible(loginpage.login_page_invalidLogin_message);
        Assert.assertEquals(errorMessage, loginpage.login_page_invalidLogin_message.getText());
        Assert.assertEquals(5, 5);
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        Assert.assertTrue(loginpage.login_page_login_btn.isDisplayed());
    }
    // invalid email login attempt - end
}
