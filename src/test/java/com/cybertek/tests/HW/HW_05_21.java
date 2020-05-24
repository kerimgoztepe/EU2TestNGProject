package com.cybertek.tests.HW;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
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
    public void optionIsDisplayedTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

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
    @Test
    public void pageNumberTest() {
        extentLogger = report.createTest("Verify page subtitle Option is displayed test");

        //Go to “https://qa1.vytrack.com/"  (TestBase handles this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");
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
    @Test
    public void viewPerPageTest() {
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events test");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitForPageToLoad(5);

        //Verify that view per page number is equals to "25"
        extentLogger = report.createTest("Verify that view per page number is equals to \"25\" test");
        Assert.assertEquals(new CalendarEventsPage().viewPerPageNo.getText(), "25", "Verify that view per page number is equals to \"25\"");

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
    public void numberOfRecordsTest() {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");


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
    public void calendarEventsSelectedTest() {
        extentLogger = report.createTest("Verify that all calendar events were selected test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

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
            //page 25 ten sonra çakıyor...
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
    public void testersMeetingTest() {
        extentLogger = report.createTest("Verify that predefined Testers Meeting is displayed test");

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        new LoginPage().loginAs("storemanager");

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        //check all rows for Testers meeting with the Start date of Nov 27, 2019, 9:30 AM and end date of Nov 27, 2019, 10:30 AM
        extentLogger = report.createTest("check all rows for Testers meeting test");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);

        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo = rowNo + calendarEventsPage.tableRows.size();

            for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {

                //System.out.println("row is selected = " + calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"));

                //Assert.assertTrue(calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"), "verify row is selected");

                if (calendarEventsPage.headTitle.getText().contains("Testers meeting") &
                        calendarEventsPage.headStart.getText().contentEquals("Nov 27, 2019, 10:30 AM")) {
                    //System.out.println("page no:" + pageNoAsInt + " and row no:" + calendarEventsPage.tableRows.get(calendarEventsPage.tableRows.size()) + " is NOT selected");                    //calendarEventsPage.rightArrow.click();
                    //calendarEventsPage.waitUntilLoaderScreenDisappear();

                    break;
                }
                calendarEventsPage.tableRows.get(k).click();
                break;
            }

            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }

        /*//Click on Filter Button
        extentLogger = report.createTest("Click on Filter Button test");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.filterBtn.click();
        //Click on Filter by Title button
        extentLogger = report.createTest("Filter by Title Button test");
        calendarEventsPage.filterByTitleBtn.click();

        //Send keys "Testers meeting" and click Update button
        extentLogger = report.createTest("Send keys \"Testers meeting\" and click Update button test");
        calendarEventsPage.filterInputBox.sendKeys("Testers meeting", Keys.ENTER);*/


        extentLogger.pass("PASS : Verify that predefined Testers Meeting is displayed test");

    }
}