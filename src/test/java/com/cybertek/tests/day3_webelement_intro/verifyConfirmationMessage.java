package com.cybertek.tests.day3_webelement_intro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class verifyConfirmationMessage {
    public static void main(String[] args) {
        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "test@cybertekschool.com";
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //two main ways to get text from web elements
        //1.getText()--> it will work %99 and it will return string
        //2.getAttribute("value")--> second way of getting text especially input boxes
        String actualEmail = emailInputBox.getAttribute("value");   //know getAttribute method
                                        //if getText not work try getAttribute...

        //verify email is displayed
        if (actualEmail.equals(expectedEmail)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedEmail = " + expectedEmail);
        }
        //click on retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        //click()--> clicking web element
        retrievePasswordButton.click();
        //verify confirmation message
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        //save expected message that is defined in the test case
        String expectedMessage = "Your e-mail's been sent!";
        //save actual message that is coming from browser
        String actualMessage = actualConfirmationMessage.getText();
        //verify
        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }
        //close the browser
        driver.quit();

        /**
         * Once you get the test case, what do you do first
         * 1.Read and try to understand
         * 2.Manually execute test case
         * - functionality shouldn't be broken
         * - it should be automatable with selenium,(color design etc)
         * - should pass manually first
         * =================================
         * Create day3_webelement_intro package under tests folder
         * Create Verify URL not changed class under day3 package
         * 1.I created main method
         * 2.Copy test steps to class
         * How to read error message
         * 1.Go to end of the error
         * 2.Click the blue link to see which line caused error
         * 3.Find exception keyword and read the error message.
         */
    }
}