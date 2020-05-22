package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement optionsButton;

    @FindBy(xpath = "//input[@class='input-widget']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement viewPerPageNo;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalPagesNo;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public  WebElement rightArrow;

    @FindBy(xpath = "//label[contains(text(),'Total of 1562 records')]")
    public WebElement totalRecordNo;

    /*public int tableRowsSize(WebElement driver){
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr"));
        return elements.size();
    }*/

}