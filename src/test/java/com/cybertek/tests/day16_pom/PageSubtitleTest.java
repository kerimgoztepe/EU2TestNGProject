package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case:
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * Verify that page subtitle is Calendar Events
     */

    @Test
    public void test1(){

        //Login as a Driver
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        //Same thing with thread.sleep(3000)
        //BrowserUtils.waitFor(2);
        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";

        String actualSubtitle = dashboardPage.getPageSubTitle();
        //Verify that page subtitle is Quick Launchpad
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitles");
        //Go to Activities -> Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(2);
        //Verify that page subtitle is Calendar Events
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify subtitles");

    }

}