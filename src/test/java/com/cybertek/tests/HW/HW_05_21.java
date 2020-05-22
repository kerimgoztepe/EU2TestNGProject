package com.cybertek.tests.HW;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_05_21 extends TestBase {

    /***
     * Test case #1
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that page subtitle "Options" is displayed
     */

    @Test
    public void optionIsDisplayedTest(){
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Verify that page subtitle "Options" is displayed
        extentLogger = report.createTest("Verify that page subtitle \"Options\" is displayed test");
        Assert.assertTrue(new CalendarEventsPage().optionsButton.isDisplayed(),"Verify that page subtitle \"Options\" is displayed");

        extentLogger.pass("PASS : Verify that page subtitle \"Options\" is displayed");
    }
    /***
     * Test case #2
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that page number is equals to "1"
     */
    @Test
    public void pageNumberTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities","Calendar Events");
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        //Thread.sleep(3000);

        //Verify that page number is equals to "1"
        extentLogger = report.createTest("Verify that page number is equals to \"1\" test");
        String pageNumberText = new CalendarEventsPage().pageNumber.getAttribute("value");
        Assert.assertEquals(pageNumberText,"1","Verify that page number is equals to \"1\"");

        extentLogger.pass("PASS : Verify that page number is equals to \"1\"");

    }
    /***
     * Test case #3
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that view per page number is equals to "25"
     */
    @Test
    public void viewPerPageTest(){
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events test");
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Verify that view per page number is equals to "25"
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
        Assert.assertEquals(new CalendarEventsPage().viewPerPageNo.getText(),"25","Verify that view per page number is equals to \"25\"");

        extentLogger.pass("PASS : Verify that view per page number is equals to \"25\" test");

    }
    /***
     * Test case #4
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that number of calendar events (rows in the table) is equals to number of records (25)
     */

    @Test
    public void numberOfRecordsTest(){
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities","Calendar Events");


        //Verify that number of calendar events (rows in the table) is equals to number of records
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow,10);
        //new DashboardPage().waitUntilLoaderScreenDisappear();
        System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText().substring(3, 5);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo = rowNo + calendarEventsPage.tableRows.size();
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }
        //System.out.println("rowNo = " + rowNo);
        calendarEventsPage.totalRecordNo.getText()


       Assert.assertEquals(new CalendarEventsPage().tableRows,,"verify table rows equals");

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records (25) test");


    }
}
