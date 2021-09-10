package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();    // 1 - setting up chrome for automation

        WebDriver driver = new ChromeDriver();      // 2 - creating driver object for chrome

        driver.get("https://www.google.com");       // 3 - navigate to website using get method (navigate Google)
                                            // get waits until page fully loaded but navigate not wait
        Thread.sleep(3000);           // waits 3 seconds and then go on to next job

        driver.navigate().to("https://www.facebook.com");   // navigate to another website using navigate method

        Thread.sleep(3000);           // how to go back to google after we navigate to facebook
                                            // wait 3 seconds here then go back from facebook to google

        driver.navigate().back();           //goes back to google now
        Thread.sleep(3000);

        driver.navigate().forward();        // go to forward now
        Thread.sleep(3000);

        driver.navigate().refresh();        // refresh the website

        driver.findElement(By.id("email")).sendKeys("someEmail@email.com");
        Thread.sleep(2000);

        driver.findElement(By.id("pass")).sendKeys("any password");
        Thread.sleep(2000);

        driver.quit();
    }
}
