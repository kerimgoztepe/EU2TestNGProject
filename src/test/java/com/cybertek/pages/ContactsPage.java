package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage {

    //since we are extending BasePage we do not need explicit constructor for this class
    //PageFactory is a class which  has a static initElements method that initialize all WebElements

    //we want a dynamic email to reach locator all the time so create method which accepts email as String
    public WebElement getContactEmail(String email){
        String xpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";

        return Driver.get().findElement(By.xpath(xpath));
    }
}
