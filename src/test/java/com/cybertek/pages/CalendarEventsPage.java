package com.cybertek.pages;

import com.cybertek.tests.day8_types_of_elements2.ListOfElements;
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
    public WebElement pageNumber;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement  perPageBtn;

    @FindBy(xpath = "//a[contains(text(),'100')]")
    public  WebElement perPage100;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement viewPerPageNo;
                                            ////tbody/tr[18]/td[4] row bölümleri
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> tableColumns;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalPagesNo;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public  WebElement rightArrow;

    @FindBy(xpath = "//label[contains(text(),'Total of ')]")
    public WebElement totalRecordNo;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']//input")
    public WebElement checkBoxAll;

    @FindBy(xpath = "//thead/tr/th[2]")
    public WebElement headTitle;

    @FindBy(xpath = "//thead/tr/th[4]")
    public WebElement headStart;

    /*@FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterBtn;*/

    /*@FindBy(xpath = "//div[contains(text(),'Title')]")
    public WebElement filterByTitleBtn;*/

    /*@FindBy(xpath = "//input[@name='value']")
    public WebElement filterInputBox;*/

}