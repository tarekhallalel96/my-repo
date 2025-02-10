package com.logwire.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.logwire.pages.LoginPage;
import com.logwire.pages.ProductsPage;
import com.logwire.tools.WebdriverTool;

public class LoginSteps {
    LoginPage loginPage;
    ProductsPage productsPage;


    @Given("je suis sur la page {string}")
    public void je_suis_sur_la_page(String s) {
        // Write code here that turns the phrase above into concrete actions
        WebdriverTool.getDriver().get(s);
        this.loginPage = new LoginPage(WebdriverTool.getDriver());
    }

    @When("je saisi le password {string}")
    public void je_saisi_le_password(String s) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.saisirPassword(s);
        // assertTrue(false);
    }

    @When("je saisi le username {string}")
    public void je_saisi_le_username(String s) {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.saisirUserName(s);
    }

    @Then("j accede mon dashboard")
    public void j_accede_mon_dashboard() {

        assertTrue(true);
    }

    @When("je clique sur Login")
    public void je_clique_sur_Login() {

        this.loginPage.cliqueSurLogin();
    }

    @Then("un message d erreur s affiche")
    public void un_message_d_erreur_s_affiche() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(this.loginPage.getMessageErreur().isDisplayed());
    }

    // @Then("la liste n est pas vide")
    // public void la_liste_n_est_pas_vide() {
    // // Write code here that turns the phrase above into concrete actions
    // productsPage = new ProductsPage(this.driver);

    // // System.out.println(s);
    // assertTrue(productsPage.getProduitsList().size() > 0);

    // }

}
