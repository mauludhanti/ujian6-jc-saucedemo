package com.juaracoding.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartBikeLight;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartLink;

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void addItemToCart(String itemName) {
        By productAddButton = By.xpath("//div[text()='" + itemName + "']/following-sibling::button");
        driver.findElement(productAddButton).click();
    }

    public void addBackpackToCart() {
        addToCartBackpack.click();
    }

    public void addBikeLightToCart() {
        addToCartBikeLight.click();
    }

    public void goToCart() {
        cartLink.click();
    }
}