package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void clickWithJS()throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/");

        //locate dropdown link
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        Thread.sleep(1000);
        //clicking with JavascriptExecutor we use it when we cannot click using selenium
        //create js executor object
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //use executeScript to click // google it to find right code to click "arguments[0].click"
        jse.executeScript("arguments[0].click();",dropdownLink);
        Thread.sleep(2000);

    }
    @Test
    public void type() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //locate disabled button and send keys
        String str = "Hello disable input";
        String str2 = "World Citizen";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputbox);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].setAttribute('value', '" + str2 +"')", inputbox);
        Thread.sleep(3000);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor) driver;



        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, 250);");

        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, -250);");

        }


    }


}
