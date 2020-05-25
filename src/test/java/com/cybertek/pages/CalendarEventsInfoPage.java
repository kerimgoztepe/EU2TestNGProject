package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsInfoPage extends BasePage {

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[1]")
    public WebElement titleInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[2]")
    public WebElement descriptionInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[3]")
    public WebElement startInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[4]")
    public WebElement endInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[5]")
    public WebElement allDayEventInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[6]")
    public WebElement organizerInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[7]")
    public WebElement guestsInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[8]")
    public WebElement recurrenceInfo;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[9]")
    public WebElement callViaHangoutInfo;


}
