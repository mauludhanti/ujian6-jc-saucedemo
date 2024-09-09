package com.juaracoding.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//div[@class='cart_item']")
    WebElement cartItems;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to get the number of items in the cart
    public int getCartItemCount() {
        return cartItems.size();
    }

    // Method to go to the cart page
    public void goToCart() {
        cartIcon.click();
    }

    // Method to click the checkout button
    public void clickCheckout() {
        checkoutButton.click();
    }
}
