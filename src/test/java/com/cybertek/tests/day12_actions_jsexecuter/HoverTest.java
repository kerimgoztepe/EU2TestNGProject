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

import java.util.List;
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
    public void hoverTest1() throws InterruptedException {

        //navigate to web-page
        driver.get("http://practice.cybertekschool.com/hovers");

        int n = 3;

        WebElement link = null;
        WebElement img = null;

        //create actions object / passing driver as a constructor
        Actions mouseAction = new Actions(driver);

        //locate 3 images
        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                img = driver.findElement(By.xpath("(//img)[1]"));
                //hover over image
                mouseAction.moveToElement(img).perform();
                Thread.sleep(2000);
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[1]"));
                //verify message is displayed
                Assert.assertTrue(link.isDisplayed(), "verify View profile link is displayed");
                //get message and print
                System.out.println("link = " + link.getText());

            } else if (i == 2) {
                img = driver.findElement(By.xpath("(//img)[2]"));
                //hover over image
                mouseAction.moveToElement(img).perform();
                Thread.sleep(2000);
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[2]"));
                //verify message is displayed
                Assert.assertTrue(link.isDisplayed(), "verify View profile link is displayed");
                //get message and print
                System.out.println("link = " + link.getText());

            } else {
                img = driver.findElement(By.xpath("(//img)[3]"));
                //hover over image
                mouseAction.moveToElement(img).perform();
                Thread.sleep(2000);
                link = driver.findElement(By.xpath("(//h5[contains(text(),'user')])[3]"));
                //verify message is displayed
                Assert.assertTrue(link.isDisplayed(), "verify View profile link is displayed");
                //get message and print
                System.out.println("link = " + link.getText());

            }
        }

    }
    @Test
    public void hoverTest2() throws InterruptedException {

        //navigate to web-page
        driver.get("http://practice.cybertekschool.com/hovers");

        //locate 3 images and assign to List as web-element
        List<WebElement> elements = driver.findElements(By.xpath("//img"));

        //create actions object / passing driver as a constructor
        Actions action = new Actions(driver);

        //For String manipulation create str
        String str = null;

        //Loop for hovering over images, wait 2 secs, get texts and verify displayed
        for (int i = 0; i < elements.size(); i++) {
            str = "(//h5[contains(text(),'user')])["+(i+1)+"]";
            action.moveToElement(elements.get(i)).perform();
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.xpath(str)).isDisplayed());
            System.out.println(driver.findElement(By.xpath(str)).getText());
        }

    }
}
