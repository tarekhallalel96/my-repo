package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    @FindBy(name = "username")
    private WebElement userNameElement;

    LoginPageFactory(WebDriver driver ) {

PageFactory.initElements(driver , this );



    }


    //action 
    public void saisirUsername(String username){
    userNameElement.sendKeys((username));

    }

}
