package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    @CacheLookup
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    @CacheLookup
    public WebElement optionsButton;

    @FindBy(xpath = "//input[@class='input-widget']")
    @CacheLookup
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    @CacheLookup
    public WebElement viewPerPageNo;

    @FindBy(xpath = "//tbody/tr")
    @CacheLookup
    public List<WebElement> tableRows;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    @CacheLookup
    public WebElement totalPagesNo;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    @CacheLookup
    public  WebElement rightArrow;

    @FindBy(xpath = "//label[contains(text(),'Total of 1562 records')]")
    @CacheLookup
    public WebElement totalRecordNo;

    /*public int tableRowsSize(WebElement driver){
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr"));
        return elements.size();
    }*/

}