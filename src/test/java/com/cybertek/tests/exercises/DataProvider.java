package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProvider {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("a[href='/status_codes']")).click();

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @org.testng.annotations.DataProvider
    public Object[][] createData1(Method method) {

        System.out.println(method.getName());

        if(method.getName().equals("test9")) {
            return new Object[][]{{"200", "This page returned a 200 status code."}};
        }else if(method.getName().equals("test10")) {
            return new Object[][]{{"301", "This page returned a 301 status code."}};
        }else if(method.getName().equals("test10")) {
            return new Object[][]{{"404", "This page returned a 404 status code."}};
        } else {
            return new Object[][]{{"500","This page returned a 500 status code."}};
        }

    }

    @Test(dataProvider = "testCase_9_12")
    public void test9(String locator , String expectedMessage) throws InterruptedException {
        String actualMessage="";

        driver.findElement(By.xpath("//a[contains(@href,'status_codes/"+locator+"')]")).click();
        String message = driver.findElement(By.xpath("//div/p")).getText();
        int index = message.indexOf(".");
        actualMessage = message.substring(0, index+1);



        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test(dataProvider = "testCase_9_12")
    public void test10(String locator , String expectedMessage) throws InterruptedException {
        String actualMessage="";

        driver.findElement(By.xpath("//a[contains(@href,'status_codes/"+locator+"')]")).click();
        String message = driver.findElement(By.xpath("//div/p")).getText();
        int index = message.indexOf(".");
        actualMessage = message.substring(0, index+1);



        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(dataProvider = "testCase_9_12")
    public void test11(String locator , String expectedMessage) throws InterruptedException {
        String actualMessage="";
        driver.findElement(By.xpath("//a[contains(@href,'status_codes/"+locator+"')]")).click();
        String message = driver.findElement(By.xpath("//div/p")).getText();
        int index = message.indexOf(".");
        actualMessage = message.substring(0, index+1);


        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(dataProvider = "testCase_9_12")
    public void test12(String locator , String expectedMessage) throws InterruptedException {
        String actualMessage="";
        driver.findElement(By.xpath("//a[contains(@href,'status_codes/"+locator+"')]")).click();
        String message = driver.findElement(By.xpath("//div/p")).getText();
        int index = message.indexOf(".");
        actualMessage = message.substring(0, index+1);


        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
