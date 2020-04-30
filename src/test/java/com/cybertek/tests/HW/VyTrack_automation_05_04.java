package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrack_automation_05_04 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

   @Test
    public void Test1() throws InterruptedException {
        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        driver.get("https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract");
        //Use credentials to login
       WebElement userNameBox = driver.findElement(By.id("prependedInput"));
       userNameBox.sendKeys("storemanager61");
       WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
       passwordBox.sendKeys("UserUser123");
       driver.findElement(By.id("_submit")).click();
       //wait until page loads
       //WebDriverWait wait = new WebDriverWait(driver,20);
       //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Halim Smith']")));
       //Find your contract named"Halim Smith" anc click and see details
       Thread.sleep(20000);
       driver.findElement(By.xpath("//*[.='Halim Smith']")).click();
       Thread.sleep(2000);
       //Verify that you get your vehicle info successfully
       String actualVehicleInfo = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();
       String expectedVehicleInfo = "Halim Smith Vendor Driver Smith Muhammet Ali";
       Assert.assertTrue(actualVehicleInfo.contentEquals(expectedVehicleInfo),"verify vehicle info");



   }

}
