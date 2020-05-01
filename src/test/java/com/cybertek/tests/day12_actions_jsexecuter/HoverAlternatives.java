package com.cybertek.tests.day12_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HoverAlternatives {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    //    @AfterMethod
//    public void afterMethod() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
    @Test
    public void Test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        //I took the source code of the page to make string manupulation
        String pageSource = driver.getPageSource();
        //I create a users List to store "name: userx" string objects inside
        List<String> users = new ArrayList<>();
        int index = 0;
        //I created a while loop to take the "name: userX" objects inside the users List
        while (pageSource.contains("name: user")) {
            index = pageSource.indexOf("name: user"); // find the first "name: user" object index number in the source code
            String str = pageSource.substring(index, index + 11); //retrieve the "name: userX" object from the source code
            users.add(str); // add the "name: userX" object into the list
            pageSource = pageSource.replace(str, " ");// delete "name: userX" object from source code to find others
        }
        System.out.println("users.toString() = " + users.toString()); // to see users list inside
        List<WebElement> images = driver.findElements(By.cssSelector(".figure img")); // the list of images objects
        Integer userNumber = 0; // i created this wrapper to hold user number. I will convert string to Integer
        // i will compare the index number with the converted user number
        for (Integer i = 1; i <= images.size(); i++) { // to compare image numbers with the user numbers (first image, first user)
            userNumber = Integer.parseInt(users.get(i - 1).substring(10)); // taking the index number of user by parseint
            Assert.assertEquals(i, userNumber);
        }
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        List<WebElement> images = driver.findElements(By.cssSelector(".figure img"));
        System.out.println("images.size() = " + images.size());
        List<WebElement> users = driver.findElements(By.cssSelector(".figure div h5"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).perform();
            Thread.sleep(2000);
            Assert.assertTrue(users.get(i).isDisplayed());
            System.out.println(users);
        }
    }
    @Test
    public void Test5() {
        driver.get("http://practice.cybertekschool.com/hovers");
        //img locate
        //List<WebElement> images = driver.findElements(By.cssSelector(".figure img"));
        WebElement element = driver.findElement(By.xpath("(//div[@class='figure']//div//h5)[1]"));
        System.out.println("element.getText() = " + element.getText());
    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> elements = driver.findElements(By.xpath("//img"));

            //how to create actions object / passing driver as a constructor
            Actions mouseAction = new Actions(driver);

            String str = null;

            for (int i = 0; i < elements.size(); i++) {
                str = "(//h5[contains(text(),'user')])["+(i+1)+"]";
                mouseAction.moveToElement(elements.get(i)).perform();
                Thread.sleep(2000);
                Assert.assertTrue(driver.findElement(By.xpath(str)).isDisplayed());
                System.out.println(driver.findElement(By.xpath(str)).getText());
            }

        }

    }

