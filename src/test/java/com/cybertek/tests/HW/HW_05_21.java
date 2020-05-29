package com.cybertek.tests.HW;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
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

    @Test (priority = 1, description = "TestCase # 1")
    public void optionIsDisplayedTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

                //login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        //dashboardPage.waitUntilLoaderScreenDisappear();

        //Verify that page subtitle "Options" is displayed
        extentLogger = report.createTest("Verify that page subtitle \"Options\" is displayed test");
        Assert.assertTrue(calendarEventsPage.optionsButton.isDisplayed(), "Verify that page subtitle \"Options\" is displayed");

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

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

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

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        //dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(10);

        //Verify that view per page number is equals to "25"
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
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

    @Test (priority = 4, description = "TestCase # 4")
    public void numberOfRecordsTest() {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitForClickablility(calendarEventsPage.perPageBtn, 10);

        //change view per page to 100
        calendarEventsPage.perPageBtn.click();
        calendarEventsPage.perPage100.click();

        //Verify that number of calendar events (rows in the table) is equals to number of records
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);

        //new DashboardPage().waitUntilLoaderScreenDisappear();
        //System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo += calendarEventsPage.tableRows.size();
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

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records test");


    }

    /***
     * Test Case #5
     * 1. Go to “https://qa1.vytrack.com/"
     * 2. Login as a store manager
     * 3. Navigate to “Activities -> Calendar Events”
     * 4. Click on the top checkbox to select all
     * 5. Verify that all calendar events were selected
     */

    @Test (priority = 5, description = "TestCase # 5")
    public void calendarEventsSelectedTest() {
        extentLogger = report.createTest("Verify that all calendar events were selected test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitForClickablility(calendarEventsPage.perPageBtn, 10);

        //change view per page to 100
        calendarEventsPage.perPageBtn.click();
        calendarEventsPage.perPage100.click();

        //Click on the top checkbox to select all
        extentLogger = report.createTest("Click on the top checkbox to select all test");
        BrowserUtils.waitForPageToLoad(5);

        calendarEventsPage.checkBoxAll.click();
        //BrowserUtils.waitFor(1);

        //Verify that all calendar events were selected
        extentLogger = report.createTest("Verify that all calendar events were selected test");
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        //System.out.println("pageNoAsInt = " + pageNoAsInt); 63
        int rowNo = 0;

        for (int i = 1; i <= pageNoAsInt; i++) {

            for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {
                //System.out.println("row is selected = " + calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"));

                rowNo++;
                Assert.assertTrue(calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"), "verify page no:"+i+" and row no: "+rowNo+" : "+calendarEventsPage.tableRows.get(k).getText()+ " is selected");

                /*if (!calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected")) {
                    System.out.println("page no:" + pageNoAsInt + " and row no:" + calendarEventsPage.tableRows.get(calendarEventsPage.tableRows.size()) + " is NOT selected");                    //calendarEventsPage.rightArrow.click();
                    calendarEventsPage.waitUntilLoaderScreenDisappear();
                    break;
                }*/
            }
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            //BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow,5);
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
     * 4. Select “Test event”
     * 5. Verify that following data is displayed:
     *
     * Title                Scrum Meeting
     * Description          Some description
     * Start                Apr 4, 2020, 9:12 AM
     * End                  Apr 4, 2020, 10:12 AM
     * All-Day Event        No
     * Organizer            Stephan Haley
     * Call Via Hangout     No
     */

    @Test (priority = 6, description = "TestCase # 6")
    public void testersMeetingTest() {
        extentLogger = report.createTest("Verify that predefined Test event is displayed test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger.info("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAs("storemanager");
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger.info("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        /*BrowserUtils.waitForClickablility(calendarEventsPage.perPageBtn, 10);

        //change view per page to 100
        calendarEventsPage.perPageBtn.click();
        BrowserUtils.waitForClickablility(calendarEventsPage.perPage100,5);
        calendarEventsPage.perPage100.click();*/

        //check all rows for Daily stand-up
        extentLogger.info("check all rows for Test event test");

        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);

        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);

        String [] arr = new String[]{"Scrum Meeting","Daily at 4:15pm","Dec 14, 2019, 4:49 PM","Dec 14, 2019, 5:49 PM","No",
        "Stephan Haley","Admin Admin - Required","No"};

        /*String expectedTitle = "Scrum Meeting";
        String expectedDescription = "Daily at 4:15pm";
        String expectedStart = "Dec 14, 2019, 4:49 PM";
        String expectedEnd = "Dec 14, 2019, 5:49 PM";
        String expectedRecurrence = "N/A";
        String expectedAllDayEvent = "No";
        String expectedOrganizer = "Stephan Haley";
        String expectedGuests = "Admin Admin - Required";
        String expectedCallViaHangout = "No";*/

        String expectedInfo = "Scrum Meeting";

        label:
            for (int i = 0; i < pageNoAsInt; i++) {

                for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {

                    if (calendarEventsPage.tableRows.get(k).getText().contains(expectedInfo)){
                        calendarEventsPage.tableRows.get(k).click();
                        BrowserUtils.waitForPageToLoad(5);
                        break label;
                    }
                }

                calendarEventsPage.rightArrow.click();
                calendarEventsPage.waitUntilLoaderScreenDisappear();
            }

            CalendarEventsInfoPage calendarEventsInfoPage = new CalendarEventsInfoPage();

            extentLogger.pass("PASS : Verify that predefined Test Event is displayed test");


            for (int m = 0; m<calendarEventsInfoPage.eventInfoDetails.size(); m++) {
                Assert.assertEquals(arr[m],calendarEventsInfoPage.eventInfoDetails.get(m).getText(),"verify info details displayed");

        }

        extentLogger.pass("PASS : Verify that predefined Test event is displayed test");

        }
    }
