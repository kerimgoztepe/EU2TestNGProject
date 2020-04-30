package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class exercise {
/**
 * Verify URL not changed
 *      * open chrome browser
 *      * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
 *      * click on Retrieve password
 *      * verify that expectedUrl and actualUrl are the same (not changed)
 *      close the browser at the end (quit)
 */

public static void main(String[] args) {

    //open chrome browser
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    //go to http://practice.cybertekschool.com/forgot_password Links to an external site
    driver.get("http://practice.cybertekschool.com/forgot_password");

    //get expectedUrl
    String expectedUrl = driver.getCurrentUrl();

    //click on Retrieve password
    WebElement retrievePassword = driver.findElement(By.id("form_submit"));
    retrievePassword.click();

    String actualUrl = driver.getCurrentUrl();

    if(actualUrl.equals(expectedUrl)){
        System.out.println("PASS");
    }else {
        System.out.println("FAIL");
    }
    driver.quit();

}
}
