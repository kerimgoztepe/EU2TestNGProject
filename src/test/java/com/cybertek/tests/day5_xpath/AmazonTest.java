package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * TASK
         * go to amazon.com
         * search for selenium
         * click search button
         * print 1-48 of 304 results for "selenium"
         *
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java");
        Thread.sleep(2000);
        //finding search button and clicking directly
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("result.getText() = " + result.getText());
        System.out.println("this is ok");
        driver.quit();
    }
}