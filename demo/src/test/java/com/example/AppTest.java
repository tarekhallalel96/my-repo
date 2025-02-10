package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.pages.LoginPage;
import com.example.pages.CheckoutInformation;
/**
 * Unit test for simple App.
 */
@Tag("regression")
@Tag("page1")
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    WebDriver driver;
    LoginPage loginPage ;
    CheckoutInformation checkoutInformation ;
  

    @BeforeEach
    public void setup(){

        String browser = System.getProperty("browser", "firefox").toLowerCase();
        switch (browser) {
            case "chrome" :
                driver = new ChromeDriver();
                break;
            case "firefox" :
                driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        
        
        driver.get("https://www.saucedemo.com");

        }
    }

    @AfterEach
    public void tearDown()
    {
    try {
        driver.quit();
    } catch (NoSuchSessionException e) {
        System.out.println("Session already closed or not established");
    }
}
    
    
    @Test
    @Tag("TC-001")
    public void testLoginCorrectPasswordIncorrect() {
        loginPage.saisirUsername("standard_user");
        loginPage.saisirPassword("incorrect");
        loginPage.cliqueSurBoutonLogin();
        WebElement errormsg = driver.findElement(By.cssSelector(".error-message-container.error"));

        assertTrue(errormsg.isDisplayed());
        
}      

@Tag("TC-002")
public void testLogininCorrectPasswordcorrect() {
    loginPage.saisirUsername("exemple");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    WebElement errormsg = driver.findElement(By.cssSelector(".error-message-container.error"));

    assertTrue(errormsg.isDisplayed());

}     
@Tag("TC-003")
public void testLogininCorrectPasswordIncorrect() {
    loginPage.saisirUsername("exemple");
    loginPage.saisirPassword("exemple");
    loginPage.cliqueSurBoutonLogin();
    WebElement errormsg = driver.findElement(By.cssSelector(".error-message-container.error"));

    assertTrue(errormsg.isDisplayed());

}     
@Test
@Tag("TC-004")
public void testLoginCorrectPasswordcorrect() {
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    assertTrue(driver.getCurrentUrl().contains("/inventory"));
}     
      
    @Test
    @Tag("TC-005")
    public void testlistinventory() {
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
    System.out.println(list);
    assertTrue(driver.getCurrentUrl().contains("/inventory"));

}
    


    @Test
    @Tag("TC-006")
    public void verifie_leproduit_ajoute_au_panier() {
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();

    WebElement messagElement = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));

    messagElement.click();

    driver.get("https://www.saucedemo.com/cart.html");

    List<WebElement> listpanier = driver.findElements(By.cssSelector(".inventory_item"));

    for (WebElement item : listpanier) {
        String title = item.findElement(By.cssSelector(".inventory_item_name")).getText();
        WebElement button = item.findElement(By.cssSelector("btn.btn_secondary.btn_small.cart_button\""));
        
        String buttonText = button.getText();
        System.out.println(buttonText);
        assertEquals("Sauce Labs Backpack", title);

    }
    }



    @Test
    @Tag("TC-007")
    public void tester_buttonRemove() {
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();

    WebElement messagElement = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));

    messagElement.click();

    driver.get("https://www.saucedemo.com/cart.html");


    WebElement messagElementRemove = driver.findElement(By.name("remove-sauce-labs-backpack"));

    messagElementRemove.click();


    List<WebElement> listpanier = driver.findElements(By.cssSelector(".inventory_item"));

    for (WebElement item : listpanier) {
        // Récupérer le titre/nom du produit
        String title = item.findElement(By.cssSelector(".inventory_item_name")).getText();
        WebElement button = item.findElement(By.cssSelector("btn.btn_secondary.btn_small.cart_button\""));
        
        String buttonText = button.getText();
        System.out.println(buttonText);
        // Afficher les informations du produi
        assertEquals("Sauce Labs Backpack", title);

    }
    


}


@Test
@Tag("TC-008")
public void tester_button_checkout() {
loginPage.saisirUsername("standard_user");
loginPage.saisirPassword("secret_sauce");
loginPage.cliqueSurBoutonLogin();

driver.get("https://www.saucedemo.com/cart.html");

WebElement messagElement = driver.findElement(By.name("checkout"));

messagElement.click();
String url  = driver.getCurrentUrl();
assertEquals("https://www.saucedemo.com/checkout-step-one.html",url);

}



@Test
@Tag("TC-009")
public void tester_formulaire_checkout() {
    // Étape 1 : Localiser le champ "First Name"
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    driver.get("https://www.saucedemo.com/checkout-step-one.html");
    checkoutInformation.saisirFirstname("tarek");
    checkoutInformation.saisirLasttname("hallalel");
    checkoutInformation.saisirCodepostal("paris");
    checkoutInformation.cliqueSurBoutonContinuer();
    assertTrue(driver.getCurrentUrl().contains("/checkout-step-two"));
}

@Test
@Tag("TC-010")
public void testEmptylastname() {
    // Étape 1 : Localiser le champ "First Name"
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    driver.get("https://www.saucedemo.com/checkout-step-one.html");
    checkoutInformation.saisirFirstname("tarek");
    checkoutInformation.saisirLasttname("");
    checkoutInformation.saisirCodepostal("paris");
    checkoutInformation.cliqueSurBoutonContinuer();
    WebElement messageError = driver.findElement(By.cssSelector(".error-message-container"));
    assertTrue(messageError.isDisplayed());
}

@Test
@Tag("TC-011")
public void testEmptyfirstname() {
    // Étape 1 : Localiser le champ "First Name"
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    driver.get("https://www.saucedemo.com/checkout-step-one.html");
    checkoutInformation.saisirFirstname("");
    checkoutInformation.saisirLasttname("hallalel");
    checkoutInformation.saisirCodepostal("paris");
    checkoutInformation.cliqueSurBoutonContinuer();
    WebElement messageError = driver.findElement(By.cssSelector(".error-message-container"));
    assertTrue(messageError.isDisplayed());
}

@Test
@Tag("TC-012")
public void testEmptycodePostal() {
    // Étape 1 : Localiser le champ "First Name"
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();
    driver.get("https://www.saucedemo.com/checkout-step-one.html");
    checkoutInformation.saisirFirstname("tarek");
    checkoutInformation.saisirLasttname("hallalel");
    checkoutInformation.saisirCodepostal("");
    checkoutInformation.cliqueSurBoutonContinuer();
    WebElement messageError = driver.findElement(By.cssSelector(".error-message-container"));
    assertTrue(messageError.isDisplayed());
}

@Test
@Tag("TC-013")
public void comparer_le_panier_avec_les_produits_achats_finales() {
 
    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();

    WebElement messagElement = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
    messagElement.click();

    driver.get("https://www.saucedemo.com/cart.html");


    List<WebElement> list = driver.findElements(By.cssSelector(".cart_item"));

    
    List<String> cartProductNames = new ArrayList<>();
    List<String> cartProductPrices = new ArrayList<>();

    for (WebElement item : list) {

        String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
        String price = item.findElement(By.cssSelector(".inventory_item_price")).getText();
        cartProductNames.add(name);
        cartProductPrices.add(price);
    }

    driver.findElement(By.cssSelector(".checkout_button")).click();
    assertTrue(driver.getCurrentUrl().contains("/checkout-step-one.html"), "La page checkout-step-one n'est pas affichée !");

    checkoutInformation.saisirFirstname("tarek");
    checkoutInformation.saisirLasttname("hallalel");
    checkoutInformation.saisirCodepostal("paris");
    checkoutInformation.cliqueSurBoutonContinuer();

    List<WebElement> list2 = driver.findElements(By.cssSelector(".cart_item"));

    List<String> cartProductNames2 = new ArrayList<>();
    List<String> cartProductPrices2 = new ArrayList<>();

    for (WebElement item2 : list2) {

        String name2 = item2.findElement(By.cssSelector(".inventory_item_name")).getText();
        String price2 = item2.findElement(By.cssSelector(".inventory_item_price")).getText();
        cartProductNames2.add(name2);
        cartProductPrices2.add(price2);
    }
    assertEquals(cartProductNames, cartProductNames2);
    assertEquals(cartProductPrices, cartProductPrices2);


    
}

@Test
@Tag("TC-013")
public void testerleprixtotal () {

    loginPage.saisirUsername("standard_user");
    loginPage.saisirPassword("secret_sauce");
    loginPage.cliqueSurBoutonLogin();

    WebElement messagElement = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));

    messagElement.click();

    driver.get("https://www.saucedemo.com/cart.html");


    driver.findElement(By.cssSelector(".checkout_button")).click();
    assertTrue(driver.getCurrentUrl().contains("/checkout-step-one.html"), "La page checkout-step-one n'est pas affichée !");

    checkoutInformation.saisirFirstname("tarek");
    checkoutInformation.saisirLasttname("hallalel");
    checkoutInformation.saisirCodepostal("paris");
    checkoutInformation.cliqueSurBoutonContinuer();

    List<WebElement> list = driver.findElements(By.cssSelector(".cart_item"));
    System.out.println(list);
    double totalSum = 0;
    for (WebElement item : list) {

        
        String priceitemElement = item.findElement(By.cssSelector(".inventory_item_price")).getText();
        
        double priceItem = Double.parseDouble(priceitemElement.replace("$", ""));
        
        totalSum += priceItem;
        
    }

    WebElement itemTotalElement = driver.findElement(By.cssSelector(".summary_subtotal_label"));
    String itemTotalText = itemTotalElement.getText();
    String priceText = itemTotalText.replace("Item total: $", "").trim();
    double price = Double.parseDouble(priceText);
    assertEquals(price, totalSum);

    WebElement itemTaxElement = driver.findElement(By.cssSelector(".summary_tax_label"));
    String itemTaxtext = itemTaxElement.getText();
    String itemTax = itemTaxtext.replace("Tax: $", "").trim();
    double itemTaxDouble = Double.parseDouble(itemTax);
    WebElement itemTotalpriceElement = driver.findElement(By.cssSelector(".summary_total_label"));

    String itemTotalpriceText = itemTotalpriceElement.getText();
    String itemTotalprice = itemTotalpriceText.replace("Total: $", "").trim();
    
    double itemTotalpriceDouble = Double.parseDouble(itemTotalprice);
    assertEquals(itemTotalpriceDouble, totalSum+itemTaxDouble);
    



    
}

@Test
@Tag("TC-012")
public void testbuttonpanieremove() {
loginPage.saisirUsername("standard_user");
loginPage.saisirPassword("secret_sauce");
loginPage.cliqueSurBoutonLogin();

WebElement messagElement = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
messagElement.click();

WebElement messagElement2 = driver.findElement(By.name("remove-sauce-labs-backpack"));

messagElement2.click();

driver.get("https://www.saucedemo.com/cart.html");

List<WebElement> listpanier = driver.findElements(By.cssSelector(".inventory_item"));

for (WebElement item : listpanier) {
    // Récupérer le titre/nom du produit
    String title = item.findElement(By.cssSelector(".inventory_item_name")).getText();
    WebElement button = item.findElement(By.cssSelector("btn.btn_secondary.btn_small.cart_button\""));
    
    String buttonText = button.getText();
    System.out.println(buttonText);
    // Afficher les informations du produi
    assertNotEquals("Sauce Labs Backpack", title);


}
    
}
}




        

    





 
