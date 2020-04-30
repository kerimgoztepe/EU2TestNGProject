package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HW_TestCase3 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");

        // Go to wikipedia.org
        driver.get("https://www.wikipedia.org/");

        // enter search term `selenium webdriver`
        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("selenium webdriver");

        // click on search button
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i")).click();

        // click on search result `Selenium (software)`
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul/li[1]/div[1]/a")).click();

        // verify url ends with `Selenium_(software)'
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("currentUrl ends with = " + currentUrl);
        }
        driver.quit();
    }
}
