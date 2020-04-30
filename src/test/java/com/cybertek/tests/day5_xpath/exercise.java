package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class exercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("huzur veren ezan");
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        //driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        driver.quit();

        WebDriver driver2 = WebDriverFactory.getDriver("firefox");
        driver2.get("https://www.youtube.com/");
        driver2.findElement(By.xpath("//input[@id='search']")).sendKeys("Huzur Veren Ezan");
        Thread.sleep(1000);
        //driver2.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        //driver2.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        driver2.quit();

        WebDriver driver3 = WebDriverFactory.getDriver("edge");
        driver3.get("https://www.youtube.com/");
        driver3.findElement(By.xpath("//input[@id='search']")).sendKeys("huzur veren ezan");
        Thread.sleep(1000);
        //driver3.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        //driver3.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        driver3.quit();

        WebDriver driver4 = WebDriverFactory.getDriver("ie");
        driver4.get("https://www.youtube.com/");
        driver4.findElement(By.cssSelector("input#masthead-search-term")).sendKeys("huzur veren ezan");
        Thread.sleep(1000);
        //driver4.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        //driver4.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        driver4.quit();

    }
    }
