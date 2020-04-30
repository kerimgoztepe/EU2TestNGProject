package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);

        driver.close();             // close the current tab opened with selenium
                                    // so can open a new tab using driver = new ChromeDriver()...
                                    //if there is more than one tab close is not enough
                                    //if there is more than one tab close is not enough
                                    //close will keep previous info inside

        driver = new ChromeDriver();

        driver.get("http://cybertekschool.com/open_new_tab");
        Thread.sleep(3000);

        driver.quit();              // generally we will use quit method to make sure all is closed...
                                    // quit will not keep previous info and quit...also will clean the cache

    }
}
