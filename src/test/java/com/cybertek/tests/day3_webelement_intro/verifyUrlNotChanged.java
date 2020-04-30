package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyUrlNotChanged {

    /**
     *Verify URL not changed
     * open chrome browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * click on Retrieve password
     * verify that url did not change
     */
    public static void main(String[] args) throws InterruptedException {
    //    WebDriverManager.chromedriver().setup();    No need bc we created a method under utilities
     //   WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");    //open chrome

        driver.get("http://practice.cybertekschool.com/forgot_password");       // go to web page

        //save url before we click retrieve password button
        String expectedUrl = driver.getCurrentUrl();

        // click on Retrieve password
        // WebElement --> Interface that represent elements on the web-page
        // findElement--> method used to find element on a web-page
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // not saying new here
            // work with WebElement comes from Selenium bc working on web elements   // driver works as new here

        retrievePasswordButton.click();     //assign driver to retrievePasswordButton and click on the web element

        //verify that url did not change
        //we save the url after we click button
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(5000);

        driver.quit();  //close and quit the tab

    }

}
