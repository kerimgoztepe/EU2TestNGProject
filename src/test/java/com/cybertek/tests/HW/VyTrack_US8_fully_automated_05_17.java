package com.cybertek.tests.HW;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VyTrack_US8_fully_automated_05_17 extends TestBase {


    /***
     * AC1: Verify that authorized user should be able to access Vehicle Contract
     * and able to see all vehicle contracts on the grid
     */

    @Test(description = "AC1")
    public void accessVehicleContractTest() {
        extentLogger = report.createTest("Access Vehicle Contract Test");

        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        //Use credentials to login (Before method in TestBase)
        extentLogger = report.createTest("Login as storemanager_username");
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        extentLogger = report.createTest("Hover over to Fleet - Vehicle Contract module");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        //wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
        BrowserUtils.waitForPageToLoad(10);

        //get title and print
        extentLogger = report.createTest("get title and print");
        String pageSubTitle = dashboardPage.getPageSubTitle();

        //verify to access all vehicle contracts page
        extentLogger = report.createTest("verify to access all vehicle contracts page");
        Assert.assertEquals(pageSubTitle, "All Vehicle Contract", "verify to access all vehicle contracts page");

        extentLogger.pass("PASS: Access Vehicle Contract page test");

    }

    /***
     * AC2: Verify that authorized user should be able to create Vehicle contract
     *      * Hover over to Fleet module
     *      * Hover over to Vehicle Contracts module and click
     *      * Click on Create Vehicle Contract button
     *      * Verify to see Create Vehicle Contract page
     *      * Enter valid info to empty spaces
     *      * Click on Save And Close button
     *      * Verify to see your newly created contract page
     */

    @Test (description = "AC2")
    public void createVehicleContractTest() throws InterruptedException {
        extentLogger = report.createTest("Create Vehicle Contract Test");

        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        //Use credentials to login
        //LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login as storemanager_username");
        new LoginPage().login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        extentLogger = report.createTest("Hover over to Fleet - Vehicle Contract module");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        BrowserUtils.waitForPageToLoad(20);

        //Click on Create Vehicle Contract button
        extentLogger = report.createTest("CLick on Create Vehicle Contract button");
        WebElement create_vehicle_contract = driver.findElement(By.xpath("//*[@title='Create Vehicle Contract']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",create_vehicle_contract);
        //actions.moveToElement(create_vehicle_contract).pause(1000).click().perform();
        BrowserUtils.waitForPageToLoad(10);

        //Verify to see Create Vehicle Contract page
        extentLogger = report.createTest("Verify to see Create Vehicle Contract page");
        String text = driver.findElement(By.xpath("//*[.='Create Vehicle Contract']")).getText();

        //Enter valid info to empty spaces
        extentLogger = report.createTest("Enter valid info to empty spaces");
        extentLogger = report.createTest("Enter some name");
        driver.findElement(By.xpath("//*[@data-name='field__responsible']")).sendKeys("some name");
        extentLogger = report.createTest("Enter 12345");
        driver.findElement(By.xpath("//*[@data-name='field__activation-cost']")).sendKeys("12345");
        extentLogger = report.createTest("Enter Halim Driver");
        driver.findElement(By.xpath("//*[@data-name='field__driver']")).sendKeys("Halim Driver");
        extentLogger = report.createTest("Click on Save and Close");
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //Verify to see your newly created contract page
        extentLogger = report.createTest("Verify to see your newly created contract page");
        String newContract = driver.findElement(By.xpath("//*[.='some name Halim Driver']")).getText();
        Assert.assertEquals("some name Halim Driver",newContract,"Verify to see your newly created contract page");

        extentLogger.pass("PASS: Create Vehicle Contract Test");

    }
}
