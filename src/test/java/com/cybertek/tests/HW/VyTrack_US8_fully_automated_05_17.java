package com.cybertek.tests.HW;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VyTrack_US8_fully_automated_05_17 extends TestBase {


    /***
     * AC1: Verify that authorized user should be able to access Vehicle Contract
     * and able to see all vehicle contracts on the grid
     */

    @Test(description = "AC1")
    public void AC1() {
        extentLogger = report.createTest("AC1 Test");

        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        //Use credentials to login (Before method in TestBase)
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        //wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
        BrowserUtils.waitForPageToLoad(10);

        //get title and print
        String pageSubTitle = dashboardPage.getPageSubTitle();

        //verify to see all vehicle contracts as a list
        Assert.assertEquals(pageSubTitle, "All Vehicle Contract", "verify to access Vehicle Contract and see list");

        extentLogger = report.createTest("Positive login test");

    }

    /***
     * AC2: Verify that authorized user should be able to create Vehicle contract
     */

    @Test (description = "AC2")
    public void AC2(){
        extentLogger = report.createTest("AC2 Test");

        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        //Use credentials to login
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        BrowserUtils.waitForPageToLoad(10);

        //Click on Create Vehicle Contract button

        extentLogger = report.createTest("Positive login test");
    }
}
