package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    @FindBy(css = ".cart_item")
   
    
    private List<WebElement> produitsListElements;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProduitsList() {
        return this.produitsListElements;
    }

}
