package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Bitrix24_US7_AC1 {

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

    /*
    1.Hover Over to More Tab
    2.Click on More
    3.Click on Announcement module
    4.Verify to see Announcement module page

     */
    @Test
    public void test1() {
        driver.get("https://login.nextbasecrm.com");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr11@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+Keys.ENTER);

        driver.findElement(By.id("feed-add-post-form-link-text")).click();
        driver.findElement(By.xpath("//span[@class='menu-popup-item-text'][contains(text(),'Announcement')]")).click();
        String expectedResult = "show announcement:";
        WebElement actualResult = driver.findElement(By.xpath("//span[@class='feed-add-post-expire-date-text' and 'show announcement:']"));

        Assert.assertEquals(actualResult.getText(), expectedResult,"Verify to see Announcement module page");
        Assert.assertTrue(actualResult.isDisplayed(),"Verify to see Announcement module page");
    }

}
