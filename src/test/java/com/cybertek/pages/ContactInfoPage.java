package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    @FindBy(css = "h1.user-name")
    @CacheLookup
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;

    @FindBy(css = "a.phone")
    public WebElement phone;

}
