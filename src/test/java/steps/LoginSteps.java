package steps;

import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentTest extentTest;

    public LoginSteps() {
        this.driver = Hooks.driver;
        this.extentTest = Hooks.extentTest;
        loginPage = new LoginPage(driver);
    }

        @Given("I am on the login page")
        public void i_am_on_the_login_page() {
            driver.get("https://www.saucedemo.com/");
            ExtentTest.log(LogStatus.PASS, "Navigated to login page");
        }

        @When("I enter valid username and password")
        public void i_enter_valid_username_and_password() {
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            ExtentTest.log(LogStatus.PASS, "Entered valid username and password");
        }

        @When("I enter invalid username and valid password")
        public void i_enter_invalid_username_and_valid_password() {
            loginPage.enterUsername("invalid_user");
            loginPage.enterPassword("secret_sauce");
            ExtentTest.log(LogStatus.PASS, "Entered invalid username and valid password");
        }

        @When("I click the login button")
        public void i_click_the_login_button() {
            loginPage.clickLoginButton();
            ExtentTest.log(LogStatus.PASS, "Clicked login button");
        }

        @Then("I should be redirected to the main page")
        public void i_should_be_redirected_to_the_main_page() {
            String actualTitle = loginPage.getPageTitle();
            Assert.assertEquals(actualTitle, "Swag Labs");
            ExtentTest.log(LogStatus.PASS, "Redirected to the main page");
        }

        @Then("I should see an error message")
        public void i_should_see_an_error_message() {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed());
            ExtentTest.log(LogStatus.PASS, "Error message is displayed");
        }
    }
