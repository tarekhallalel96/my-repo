package com.logwire.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDataSteps {
    @Then("c est ok")
    public void c_est_ok() {
        System.out.println("c est ok !!!!!!!!!1");

    }

    @Given("je suis sur l environnement {string}")
    public void je_suis_sur_l_environnement(String s) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("######## env: " + s);
    }

    @When("je saisi mon username {string}")
    public void je_saisi_mon_username(String s) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("######## username: " + s);
    }

}
