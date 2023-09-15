package tests;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import pages.ItemsPage;
import pages.LoginPage;
import utils.BrowserUtilityClass;
import utils.Driver;
import utils.TestDataReader;

import java.time.Duration;

public class CraterLoginTest {
    public static void main(String[] args) {

        craterLoginTest();
}

    static CommonPage commonpage;
    static WebDriverWait wait;
    static ItemsPage itemsPage;
    static LoginPage loginPage;

    static BrowserUtilityClass browserUtilityClass;

public static void craterLoginTest() {

    commonpage = new CommonPage();
    itemsPage = new ItemsPage();
    browserUtilityClass = new BrowserUtilityClass();
    loginPage = new LoginPage();

//go to crater
    Driver.getDriver().get(TestDataReader.getProperty("craterurl"));
    Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    Driver.getDriver().manage().window().maximize();
    browserUtilityClass.waitForElementToBeVisible(loginPage.login_page_email_box);

    //2. click on login button without filling out the credential fields
    loginPage.login_page_login_btn.click();


    //3. then verify there are 2 fields required messages display
    browserUtilityClass.waitForAllElementsToBeVisible(loginPage.login_page_fieldRequired_Messages);
    if (loginPage.login_page_fieldRequired_Messages.size() == 2) {
        System.out.println("There are 2 required field messages displayed");
    }else {
        System.out.println("Something is wrong with required field messages.");
    }
    //4. enter valid email dummy@primetechschool.com and invalid password primeschool
    browserUtilityClass.sendkeysWithActionClass(loginPage.login_page_email_box, "dummy@primetechschool.com");
    browserUtilityClass.sendkeysWithActionClass(loginPage.login_page_password_box, "primeschool");
    //5. click login button
    loginPage.login_page_login_btn.click();

    //6. then veirfy that an error message  "These credentials do not match our records." displays
    browserUtilityClass.waitForElementToBeVisible(loginPage.login_page_invalidLogin_message);
    if (loginPage.login_page_invalidLogin_message.isDisplayed()) {
        System.out.println("Credential invalid Error message displayed");
    }else {
        System.out.println("Credential invalid Error message not displayed");
    }

    }
}
