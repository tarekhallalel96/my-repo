Feature: Produits

  Scenario: verification de la liste des produits
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    Then je rajoute un produit
  Scenario: Vérifier qu'un produit est bien dans le panier
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    And je rajoute un produit
    Then je vérifie que le produit  dans le panier

  Scenario: je clique sur le boutton checkout
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    And je rajoute un produit
    Then je clique sur le boutton checkout

  Scenario: je rempli le formulaire checkout
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    And je rajoute un produit
    Then je clique sur le boutton checkout
    When je saisi le firstt namee "tarek"
    And je saisi le lasttname "tarek"
    And je saisi le codepostal "tarek"
    And je clique sur continue 
    Then je suis sur la page Checkout: Overview
   
    Scenario: je verifie le prix
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    And je rajoute un produit
    Then je clique sur le boutton checkout
    When je saisi le firstt namee "tarek"
    And je saisi le lasttname "tarek"
    And je saisi le codepostal "tarek"
    And je clique sur continue 
    Then je suis sur la page Checkout: Overview
    Then je verifie le prix totale affiché 



