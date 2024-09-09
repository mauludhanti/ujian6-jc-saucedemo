package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.pages.CartPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.juaracoding.pages.CheckoutPage;

public class CheckoutSteps {
    private  WebDriver driver;
    private ProductPage productToCartPage = new ProductPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private LoginPage loginPage = new LoginPage();
    private ExtentTest extentTest;

    public CheckoutTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I have items in my cart")
    public void i_have_items_in_my_cart() {
        CartPage.goToCart();
        Assert.assertTrue(CartPage.getCartItemCount() > 0);
        Hooks.extentTest.log(LogStatus.PASS, "Items are in the cart");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        CartPage.clickCheckout();
        Hooks.extentTest.log(LogStatus.PASS, "Proceeded to checkout");
    }

    @When("I enter my shipping details")
    public void i_enter_my_shipping_details() {
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        Hooks.extentTest.log(LogStatus.PASS, "Entered shipping details");
    }

    @When("I complete the purchase")
    public void i_complete_the_purchase() {
        checkoutPage.completeCheckout();
        Hooks.extentTest.log(LogStatus.PASS, "Completed the purchase");
    }

    @Then("I should see the order confirmation page")
    public void i_should_see_the_order_confirmation_page() {
        Assert.assertTrue(checkoutPage.isOrderConfirmationDisplayed());
        Hooks.extentTest.log(LogStatus.PASS, "Order confirmation displayed");
    }
}