package com.cybertek.tests.HW;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;

import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_05_21 extends TestBase {

    /*LoginPage login = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();*/

    /***
     * Test case #1
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that page subtitle "Options" is displayed
     */

    @Test (priority = 1, description = "TestCase # 1")
    public void optionIsDisplayedTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");
                //login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //Verify that page subtitle "Options" is displayed
        extentLogger = report.createTest("Verify that page subtitle \"Options\" is displayed test");
        Assert.assertTrue(new CalendarEventsPage().optionsButton.isDisplayed(), "Verify that page subtitle \"Options\" is displayed");

        extentLogger.pass("PASS : Verify that page subtitle \"Options\" is displayed");
    }

    /***
     * Test case #2
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that page number is equals to "1"
     */
    @Test (priority = 2, description = "TestCase # 2")
    public void pageNumberTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        //Thread.sleep(3000);

        //Verify that page number is equals to "1"
        extentLogger = report.createTest("Verify that page number is equals to \"1\" test");
        String pageNumberText = new CalendarEventsPage().pageNumber.getAttribute("value");
        Assert.assertEquals(pageNumberText, "1", "Verify that page number is equals to \"1\"");

        extentLogger.pass("PASS : Verify that page number is equals to \"1\"");

    }

    /***
     * Test case #3
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that view per page number is equals to "25"
     */
    @Test (priority = 3, description = "TestCase # 3")
    public void viewPerPageTest() {
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        //dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(10);

        //Verify that view per page number is equals to "25"
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String perPage = calendarEventsPage.viewPerPageNo.getText();
        //System.out.println("perPage = " + perPage);
        Assert.assertEquals(perPage, "25", "Verify that view per page number is equals to \"25\"");

        extentLogger.pass("PASS : Verify that view per page number is equals to \"25\" test");

    }

    /***
     * Test case #4
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Verify that number of calendar events (rows in the table) is equals to number of records (1559)
     */

    @Test
    public void t4numberOfRecordsTest() {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");


        //Verify that number of calendar events (rows in the table) is equals to number of records
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);
        //new DashboardPage().waitUntilLoaderScreenDisappear();
        //System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo = rowNo + calendarEventsPage.tableRows.size();
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }

        //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));
        int totalRecordNoAsInt = Integer.parseInt(calendarEventsPage.totalRecordNo.getText().substring(9, calendarEventsPage.totalRecordNo.getText().length() - 8));
        System.out.println("totalRecordNoAsInt = " + totalRecordNoAsInt);
        System.out.println("rowNo = " + rowNo);
        System.out.println("pageNoAsInt = " + pageNoAsInt);
        System.out.println("pageNoAsString = " + pageNoAsString);

        Assert.assertEquals(rowNo, totalRecordNoAsInt, "verify number of calendar events (rows in the table) is equals to number of total records");

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records (25) test");


    }

    /***
     * Test Case #5
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on the top checkbox to select all
     * 5. Verify that all calendar events were selected
     */

    @Test
    public void t5calendarEventsSelectedTest() {
        extentLogger = report.createTest("Verify that all calendar events were selected test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //Click on the top checkbox to select all
        extentLogger = report.createTest("Click on the top checkbox to select all test");
        BrowserUtils.waitForPageToLoad(5);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.checkBoxAll.click();
        BrowserUtils.waitFor(1);

        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        //System.out.println("pageNoAsInt = " + pageNoAsInt); 63
        int rowNo = 0;

        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo += calendarEventsPage.tableRows.size();

            for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {

                //System.out.println("row is selected = " + calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"));

                Assert.assertTrue(calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"), "verify row is selected");

                if (!calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected")) {
                    //System.out.println("page no:" + pageNoAsInt + " and row no:" + calendarEventsPage.tableRows.get(calendarEventsPage.tableRows.size()) + " is NOT selected");                    //calendarEventsPage.rightArrow.click();
                    //calendarEventsPage.waitUntilLoaderScreenDisappear();
                    break;
                }
            }
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }
        System.out.println("rowNo = " + rowNo);
        System.out.println("pageNoAsInt = " + pageNoAsInt);

        //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));

        /*String str = calendarEventsPage.totalRecordNo.getText();
        str= str.substring(9,str.length()-8);
        System.out.println("str =" + str);*/


        //Assert.assertEquals(rowNo,Integer.parseInt(calendarEventsPage.totalRecordNo.getText().substring(9,13)),"verify number of calendar events (rows in the table) is equals to number of total records");

        extentLogger.pass("PASS : Verify that all calendar events were selected test");

    }

    /***
     * Test Case #6
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Select “Testers meeting”
     * 5. Verify that following data is displayed:
     *
     * Title                Testers meeting
     * Description          This is a a weekly testers meeting
     * Start                Nov 27, 2019, 9:30 AM
     * End                  Nov 27, 2019, 10:30 AM
     * All-Day Event        No
     * Organizer            Stephan Haley
     * Guests               Tom Smith
     * Recurrence           Weekly every 1 week on Wednesday
     * Call Via Hangout     No
     */

    @Test
    public void t6testersMeetingTest() {
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger = report.createTest("Verify that predefined Testers Meeting is displayed test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger.info("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger.info("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //check all rows for Testers meeting with the Start date of Nov 27, 2019, 9:30 AM and end date of Nov 27, 2019, 10:30 AM
        extentLogger.info("check all rows for Test Event test");

        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);

        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        //int rowNo = 0;
        String expectedEventInfo = "Test Event Stephan Haley Apr 4, 2020, 10:29 AM Apr 4, 2020, 11:29 AM No N/A Not responded";

        //boolean b = false;

        label:

        //while (b=false) {

            for (int i = 0; i < pageNoAsInt; i++) {

                //rowNo = rowNo + calendarEventsPage.tableRows.size();

                for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {

                    if (calendarEventsPage.tableRows.get(k).getText().contains(expectedEventInfo)) {
                        System.out.println("tableRows.get(k).getText() = " + calendarEventsPage.tableRows.get(k).getText());
                        calendarEventsPage.tableRows.get(k).click();
                        calendarEventsPage.waitUntilLoaderScreenDisappear();
                        //b = true;
                        break label;
                    }
                }
                calendarEventsPage.rightArrow.click();
                calendarEventsPage.waitUntilLoaderScreenDisappear();
            }


        CalendarEventsInfoPage calendarEventsInfoPage = new CalendarEventsInfoPage();

        for (int i=0; i<calendarEventsInfoPage.eventInfoDetails.size(); i++){
            extentLogger.info("Verify Calendar event info detail: " + calendarEventsInfoPage.eventInfoDetails.get(i).getText()+ " is displayed successfully test");
            System.out.println("calendarEventsInfoPage.eventInfoDetails.get(i).getText() = " + calendarEventsInfoPage.eventInfoDetails.get(i).getText());
            Assert.assertTrue(calendarEventsInfoPage.eventInfoDetails.get(i).isDisplayed(),"verify event details info is displayed");
        }

        extentLogger.pass("PASS : Verify that predefined Test Event is displayed test");





      /*

        //System.out.println("calendarEventsInfoPage.eventInfoDetails.getText() = " + calendarEventsInfoPage.eventInfoDetails.getText());
        //System.out.println("calendarEventsInfoPage.eventInfoDetails.isDisplayed() = " + calendarEventsInfoPage.eventInfoDetails.isDisplayed());

        String expectedTitle = "Title Test event";
        String actualTitle = calendarEventsInfoPage.titleInfo.getText();

        extentLogger.info("Verify title is " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Verify title is ");

        String expectedDescription = " Description some description";
        String actualDescription = calendarEventsInfoPage.descriptionInfo.getText();

        extentLogger.info("Verify description is " + expectedDescription);
        Assert.assertEquals(actualDescription, expectedDescription, "Verify description is " + expectedDescription);

        String expectedStart = "Start Apr 4, 2020, 9:23 AM";
        String actualStart = calendarEventsInfoPage.startInfo.getText();

        extentLogger.info("Verify start is " + expectedStart);
        Assert.assertEquals(actualStart, expectedStart, "Verify start is " + expectedStart);

        String expectedEnd = "End Apr 4, 2020, 10:23 AM";
        String actualEnd = calendarEventsInfoPage.endInfo.getText();

        extentLogger.info("Verify end is " + expectedEnd);
        Assert.assertEquals(actualEnd, expectedEnd, "Verify end is " + expectedEnd);

        String expectedAllDayEvent = "All-Day Event No";
        String actualAllDayEvent = calendarEventsInfoPage.allDayEventInfo.getText();

        extentLogger.info("Verify All-Day Event info is " + expectedAllDayEvent);
        Assert.assertEquals(actualAllDayEvent, expectedAllDayEvent, "Verify All-Day Event info is " + expectedAllDayEvent);

        String expectedOrganizer = "Organizer Stephan Haley";
        String actualOrganizer = calendarEventsInfoPage.organizerInfo.getText();

        extentLogger.info("Verify Organizer is " + expectedOrganizer);
        Assert.assertEquals(actualOrganizer, expectedOrganizer, "Verify Organizer is " + expectedOrganizer);

        *//*String expectedGuests = "Tom Smith";
        String actualGuests = calendarEventsInfoPage.guestsInfo.getText();

        extentLogger.info("Verify Guests is " + expectedGuests);
        Assert.assertEquals(actualGuests, expectedGuests, "Verify Guests is " + expectedGuests);

        String expectedRecurrence = "Weekly every 1 week on Wednesday";
        String actualRecurrence = calendarEventsInfoPage.recurrenceInfo.getText();

        extentLogger.info("Verify Recurrence is " + expectedRecurrence);
        Assert.assertEquals(actualRecurrence, expectedRecurrence, "Verify Recurrence is " + expectedRecurrence);*//*

        String expectedCallViaHangout = "No";
        String actualCallViaHangout = calendarEventsInfoPage.callViaHangoutInfo.getText();

        extentLogger.info("Verify Call via Hangout is " + expectedCallViaHangout);
        Assert.assertEquals(actualCallViaHangout, expectedCallViaHangout, "Verify Call via Hangout is " + expectedCallViaHangout);



        //Verify Calendar event Title is displayed successfully
        extentLogger.info("Verify Calendar event Title is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.titleInfo.isDisplayed(),"Calendar event title is displayed successfully");

        //Verify Calendar event Description is displayed successfully
        extentLogger.info("Verify Calendar event Description is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.descriptionInfo.isDisplayed(),"Calendar event Description is displayed successfully");

        //Verify Calendar event Start is displayed successfully
        extentLogger.info("Verify Calendar event Start is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.startInfo.isDisplayed(),"Calendar event Start is displayed successfully");

        //Verify Calendar event End is displayed successfully
        extentLogger.info("Verify Calendar event End is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.endInfo.isDisplayed(),"Calendar event End is displayed successfully");

        //Verify Calendar event All-Day Event is displayed successfully
        extentLogger.info("Verify Calendar event All-Day Event is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.allDayEventInfo.isDisplayed(),"Calendar event All-Day Event is displayed successfully");

        //Verify Calendar event Organizer is displayed successfully
        extentLogger.info("Verify Calendar event Organizer is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.organizerInfo.isDisplayed(),"Calendar event Organizer is displayed successfully");


        Verify Calendar event Call Via Hangout is displayed successfully
        extentLogger.info("Verify Calendar event Call Via Hangout is displayed successfully test");
        Assert.assertTrue(calendarEventsInfoPage.callViaHangoutInfo.isDisplayed(),"Calendar event Call Via Hangout is displayed successfully");
*/




    }
}