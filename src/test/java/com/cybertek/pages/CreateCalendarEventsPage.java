package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    @CacheLookup
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    @CacheLookup
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    @CacheLookup
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    @CacheLookup
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    @CacheLookup
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    @CacheLookup
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    @CacheLookup
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    @CacheLookup
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    @CacheLookup
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    @CacheLookup
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    @CacheLookup
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    @CacheLookup
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    @CacheLookup
    public WebElement by;



    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}

