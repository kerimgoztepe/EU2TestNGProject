package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class exercise_verifyUrlChanged {
/**
 * Verify URL changed
 *          * open browser
 *          * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
 *          * enter any email
 *          * click on Retrieve password
 *          * verify that url changed to http://practice.cybertekschool.com/email_sent
 */

public static void main(String[] args) {

    //open browser
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    //go to http://practice.cybertekschool.com/forgot_password Links to an external site
    driver.get("http://practice.cybertekschool.com/forgot_password");

    //get beforeUrl
    String beforeUrl = driver.getCurrentUrl();

    //enter any email
    WebElement emailBoxFind = driver.findElement(By.name("email"));
    emailBoxFind.sendKeys("hiltasacademy@hotmail.com");

    //click on Retrieve password
    WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
    retrievePasswordButton.click();

    //verify that url changed to http://practice.cybertekschool.com/email_sent
    String afterUrl = driver.getCurrentUrl();

    if (afterUrl.equals(beforeUrl)){
        System.out.println("PASS");
    }else{
        System.out.println("FAIL");
        System.out.println(afterUrl);
    }
    driver.quit();
}
}
