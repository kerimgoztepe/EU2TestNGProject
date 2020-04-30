package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task_09_12_Data_Provider {

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



        @DataProvider
        public static Object[] statusCode() { //              todo Data provider annotation helps to provide data var test cases
            //TODO-->return type should be Object Array (Object[]), set any name to your method(like: getDATA() or bilgiAL()
            //TODO-->                                                   Rows - Number of times your test has to be repeated.
            //TODO-->                                                           Columns - Number of parameters in test data.
            String[][] data = new String[4][1];// TODO-->             -->test will run 4 times and  need 1 data(status code)
            data[0][0] = "200";
            data[1][0] = "301";
            data[2][0] = "404";
            data[3][0] = "500";
            return data;
        }

        @Test(dataProvider = "statusCode")
        //TODO--->implement (dataProvider = "statusCode") next to your @Test annotation
        public void test(String statusCode) {
            //TODO-->enter type of variable and name to your test constructor as param (String statusCode)
            driver.get("https://practice-cybertekschool.herokuapp.com/");

            driver.findElement(By.linkText("Status Codes")).click();

            driver.findElement(By.partialLinkText(statusCode)).click();//statusCode coming from dataProvider

            String actualResult = (driver.findElement(By.xpath("//p")).getText());

            System.out.println("statusCode = " + statusCode);

            System.out.println("actualResult = " + actualResult.split(".")[0]);

            Assert.assertTrue(actualResult.contains(statusCode));

        }

    }
