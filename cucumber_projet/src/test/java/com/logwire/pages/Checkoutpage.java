package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
    @FindBy(name  = "firstName")
    private WebElement firstnameElement;

    @FindBy(id = "last-name")
    private WebElement lastnameElement;
    @FindBy(id = "postal-code")
    private WebElement postalecodeElement;
    @FindBy(id = "continue")
    private WebElement continueElement;

    @FindBy(css  = ".error-button")
    private WebElement errorMessageElement;

    public Checkoutpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void saisirfirstName(String firstname) {
        firstnameElement.sendKeys(firstname);
    }

    public void saisirLastname(String lastname) {
        lastnameElement.sendKeys(lastname);
    }

    public void saisirCodePostal(String codepostal) {
        postalecodeElement.sendKeys(codepostal);
    }

    public void cliqueSurcontinue() {
        continueElement.click();
    }

    public WebElement getMessageErreur() {
        return this.errorMessageElement;
    }

}
