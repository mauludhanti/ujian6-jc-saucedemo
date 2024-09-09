package com.juaracoding.steps;

import com.juaracoding.Hooks;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.ProductPage;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;


public class ProductSteps {
    private WebDriver driver;
    private ProductPage productPage;
    private ExtentTest extentTest;

    public ProductTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am logged in with valid credentials")
    public void i_am_logged_in_with_valid_credentials() {
        productPage.login("standard_user", "secret_sauce");
        Hooks.extentTest.log(LogStatus.PASS, "Logged in with valid credentials");
    }

    @When("I add {string} to the cart")
    public void i_add_item_to_the_cart(String itemName) {
        productPage.addItemToCart(itemName);
        Hooks.extentTest.log(LogStatus.PASS, "Added item to cart: " + itemName);
    }

    @Then("I should see {int} item(s) in the cart")
    public void i_should_see_items_in_the_cart(int itemCount) {
        CartPage.goToCart();
        Assert.assertEquals(CartPage.getCartItemCount(), itemCount);
        Hooks.extentTest.log(LogStatus.PASS, "Verified item count in the cart: " + itemCount);
    }
}