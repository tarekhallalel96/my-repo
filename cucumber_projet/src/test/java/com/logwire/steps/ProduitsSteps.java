package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.logwire.pages.Checkoutpage;
import com.logwire.pages.LoginPage;
import com.logwire.pages.ProductsPage;
import com.logwire.tools.WebdriverTool;

// import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Duration;

public class ProduitsSteps {
    LoginPage loginPage;
    ProductsPage productsPage;
    Checkoutpage checkoutpage;
    

    @Then("la liste n est pas vide")
    public void la_liste_n_est_pas_vide() {
        // Write code here that turns the phrase above into concrete actions

        productsPage = new ProductsPage(WebdriverTool.getDriver());  
         assertTrue(productsPage.getProduitsList().size() > 0);

    }

    @Then("je rajoute un produit")
    public void je_rajoute_un_produit() {
        System.out.println("hello");
        productsPage = new ProductsPage(WebdriverTool.getDriver());
        WebElement addToCartButton = WebdriverTool.getDriver().findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        WebElement removeButton = WebdriverTool.getDriver().findElement(By.name("remove-sauce-labs-backpack"));


        assertTrue(removeButton.isDisplayed());

    }

    @Then("je vérifie que le produit  dans le panier")
    public void je_v_rifie_que_le_produit_dans_le_panier() {

        WebdriverTool.getDriver().get("https://www.saucedemo.com/cart.html");

        List<WebElement> listpanier = productsPage.getProduitsList();
        

        for (WebElement item : listpanier) {
            // Récupérer le titre/nom du produit
            String title = item.findElement(By.cssSelector(".inventory_item_name")).getText();

            assertEquals("Sauce Labs Backpack", title);

        }


    }

    @Then("je clique sur le boutton checkout")
    public void je_clique_sur_le_boutton_checkout() {
        WebdriverTool.getDriver().get("https://www.saucedemo.com/cart.html");

        WebElement checkoutButton = WebdriverTool.getDriver().findElement(By.name("checkout"));
        checkoutButton.click();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html",WebdriverTool.getDriver().getCurrentUrl());
    }


    @Then("je verifie le prix totale affiché")
    public void je_verifie_le_prix_totale_affich() {

        List<WebElement> list = WebdriverTool.getDriver().findElements(By.cssSelector(".cart_item"));
        System.out.println(list);
        double totalSum = 0;
        for (WebElement item : list) {
    
            
            String priceitemElement = item.findElement(By.cssSelector(".inventory_item_price")).getText();
            
            double priceItem = Double.parseDouble(priceitemElement.replace("$", ""));
            
            totalSum += priceItem;
            
        }
    
        WebElement itemTotalElement = WebdriverTool.getDriver().findElement(By.cssSelector(".summary_subtotal_label"));
        String itemTotalText = itemTotalElement.getText();
        String priceText = itemTotalText.replace("Item total: $", "").trim();
        double price = Double.parseDouble(priceText);
        assertEquals(price, totalSum);
    
        WebElement itemTaxElement = WebdriverTool.getDriver().findElement(By.cssSelector(".summary_tax_label"));
        String itemTaxtext = itemTaxElement.getText();
        String itemTax = itemTaxtext.replace("Tax: $", "").trim();
        double itemTaxDouble = Double.parseDouble(itemTax);
        WebElement itemTotalpriceElement = WebdriverTool.getDriver().findElement(By.cssSelector(".summary_total_label"));
    
        String itemTotalpriceText = itemTotalpriceElement.getText();
        String itemTotalprice = itemTotalpriceText.replace("Total: $", "").trim();
        
        double itemTotalpriceDouble = Double.parseDouble(itemTotalprice);
        assertEquals(itemTotalpriceDouble, totalSum+itemTaxDouble);
    


    }


     

    }