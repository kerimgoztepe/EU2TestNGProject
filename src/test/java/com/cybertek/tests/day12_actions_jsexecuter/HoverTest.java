package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverTest {

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        int n = 3;

        for (int i = 1; i <= n; i++) {
            WebElement img = null;
            if (i == 1) {
                img = driver.findElement(By.xpath("(//img)[1]"));
            } else if (i == 2) {
                img = driver.findElement(By.xpath("(//img)[2]"));
            } else {
                img = driver.findElement(By.xpath("(//img)[3]"));
            }

            //how to create actions object / pasing driver as a constructor
            Actions mouseAction = new Actions(driver);
            //perform() --> perform the action, complete the action
            //moveToElement--> move your mouse to webelement(hover over)
            Thread.sleep(2000);
            mouseAction.moveToElement(img).perform();

            WebElement link = null;

            if (i == 1) {
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[1]"));
            } else if (i == 2) {
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[2]"));
            } else {
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[3]"));
            }


            Assert.assertTrue(link.isDisplayed(), "verify View profile link is displayed");

            System.out.println("link = " + link.getText());

        }

    }
}
