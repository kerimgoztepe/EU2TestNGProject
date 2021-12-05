package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com/");

        // getting title with selenium
        // first short cut to introduce local variable

        String title = driver.getTitle();           // Option or ALT + Enter + Enter
        System.out.println("title = " + title);     // soutv + Enter

        String currentUrl = driver.getCurrentUrl(); // getCurrentUrl() => gets the current url of the page
        System.out.println("currentUrl = " + currentUrl);

        /*String pageSource = driver.getPageSource();     // getPageSource => gets the source code of the page
        System.out.println("pageSource = " + pageSource);*/
    }

}
