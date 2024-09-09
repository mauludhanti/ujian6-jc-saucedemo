package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement orderConfirmationText;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to fill out checkout form
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
    }

    // Method to complete the checkout process
    public void completeCheckout() {
        finishButton.click();
    }

    // Method to verify if the order confirmation is displayed
    public boolean isOrderConfirmationDisplayed() {
        return orderConfirmationText.isDisplayed();
    }
}
