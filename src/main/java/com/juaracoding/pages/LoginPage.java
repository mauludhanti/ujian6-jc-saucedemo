package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Method to check if the error message is displayed
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    // Method to get error message text
    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
}