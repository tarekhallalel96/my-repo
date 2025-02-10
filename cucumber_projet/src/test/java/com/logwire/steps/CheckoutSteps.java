package com.logwire.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.logwire.pages.Checkoutpage;
import com.logwire.pages.LoginPage;
import com.logwire.pages.ProductsPage;
import com.logwire.tools.WebdriverTool;


public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    Checkoutpage checkoutpage;

    public CheckoutSteps() {
        this.driver = WebdriverTool.getDriver(); 
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.checkoutpage = new Checkoutpage(driver);
    }
    @Then("je clique sur continue")
    public void je_clique_sur_continue() {
        this.checkoutpage.cliqueSurcontinue();  
    }


    @When("je saisi le codepostal {string}")
    public void je_saisi_le_codepostal(String s) {
        this.checkoutpage.saisirCodePostal(s); 

       }

    @When("je saisi le lasttname {string}")
    public void je_saisi_le_lasttname(String s) {
        this.checkoutpage.saisirLastname(s);     }


   
 

    @When("je saisi le firstt namee {string}")
    public void je_saisi_le_firstt_namee(String s) {
        this.checkoutpage.saisirfirstName(s);
    }

    @Then("je suis sur la page Checkout: Overview")
    public void je_suis_sur_la_page_Checkout_Overview() {
        assertEquals("https://www.saucedemo.com/checkout-step-two.html",WebdriverTool.getDriver().getCurrentUrl());


    }
}