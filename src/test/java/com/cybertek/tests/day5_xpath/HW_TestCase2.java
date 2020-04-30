package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HW_TestCase2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to amazon
        driver.get("https://www.amazon.com/");
        //go to ebay
        driver.get("https://www.ebay.com/");

        //enter search term "macbook" click on search button
        driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("macbook");
        driver.findElement(By.id("gh-btn")).click();

        // verify title contains search term
        boolean contains = driver.getTitle().contains("macbook");

        if (contains=true){
            System.out.println("title contains \"macbook\" = " + contains);
        }else {
            System.out.println("title contains \"macbook\" = " + contains);
        }
        driver.quit();
    }
}
