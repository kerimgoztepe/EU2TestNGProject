package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW_TestCase1 {
    public static void main(String[] args) {
        WebDriver chrome = WebDriverFactory.getDriver("chrome");
        chrome.get("https://www.ebay.com/");
        WebElement searchBox = chrome.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox.sendKeys("mac");
        chrome.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
        WebElement result = chrome.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]"));
        System.out.println("result.getText() = " + result.getText());

        chrome.quit();
    }
}
