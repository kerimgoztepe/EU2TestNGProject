package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
        //PageFactory is a class which  has a static initElements method that initialize all WebElements

    //same with driver.findElement(By.id("prependedInput"));
    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username"),
    })
    @CacheLookup
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    @CacheLookup
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    @CacheLookup
    public WebElement loginBtn;

    public void login(String usernameStr,String passwordStr){

        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();

    }

    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }
    public void loginAs(String user){
        String username = ConfigurationReader.get(user +"_username");
        String password = ConfigurationReader.get(user+"_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

}