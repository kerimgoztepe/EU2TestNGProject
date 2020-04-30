package com.cybertek.tests.day3_webelement_intro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class verifyUrlChanged {

    public static void main(String[] args) {
        /**
         * Verify URL changed
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter any email
         * click on Retrieve password
         * verify that url changed to http://practice.cybertekschool.com/email_sent
         */
        //open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys("test@gmail.com");
        //click on retrieve password button
        WebElement retrievePasswordBtn = driver.findElement(By.id("form_submit"));  // look for ID if not look for name
        retrievePasswordBtn.click();

        //verify that url changed to http://practice.cybertekschool.com/email_sent
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //get current url from browser and save as an actual
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }
        //close the browser
        driver.quit();


    }

}
