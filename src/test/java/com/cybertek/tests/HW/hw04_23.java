package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class hw04_23 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /*
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String expectedResult = "The date of birth is not valid";
        String actualResult = driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText();
        Assert.assertEquals(expectedResult, actualResult, "verifying the existence of invalid birthday message");
    }
    /*
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java,JavaScript
     */

    @Test
    public void test2() {

    }

    @Test
    public void test3() {
        //Step 1. Go to “https://practicecybertekschool.
        //herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        //Step 3. Enter only one alphabetic character into first
        //name input box.
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("a");

        //Step 4. Verify that warning message is displayed:
        //“first name must be more than 2 and less than 64
        //characters long”
        WebElement warnMessage = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));
        Assert.assertTrue(warnMessage.isDisplayed(), "warning message is displayed");


    }

    @Test
    public void test6() throws InterruptedException {
        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(2000);

        //Step 2. Copy and save email as a string.
        WebElement element = driver.findElement(By.xpath("//span[@id='email']"));
        String email = element.getText();

        //Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        Thread.sleep(2000);

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Halim Iltas");
        //Step 6. Enter email from the Step 2.
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        Thread.sleep(2000);
        //Step 7. Click Sign Up
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Step 8. Verify that following message is displayed:
        //“Thank you for signing up. Click the button below to
        //return to the home page.”
        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        String actualText = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
        Assert.assertEquals(actualText, expectedText, "verify sign in");

        //Step 9. Navigate back to the “https://
        //www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(1000);

        //Step 10. Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”
        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("(//tbody/tr/td[2])[1]")).click();
        Thread.sleep(1000);

        //Step 12. Verify that email is from: “do-notreply@
        //practice.cybertekschool.com”
        //Step 13. Verify that subject is: “Thanks for
        //subscribing to practice.cybertekschool.com!”
        String actualTextMessage = driver.findElement(By.id("predmet")).getText();
        Assert.assertTrue(actualTextMessage.contains("Thanks for subscribing"));

    }
// Test 10
    @Test
    public void TestCase10forLoopClick() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        // there are 4 status code(200/301/404/500) under same parent, create a WebElementLİST of them
        List<WebElement> allCodes = driver.findElements(By.xpath("//div//ul/li"));
        //get text of each element into a new LIST to use after finding element by tex and click it
        List<String> codes = new ArrayList<>();
        for (WebElement allElement : allCodes) {
            //add text to new list
            codes.add(allElement.getText());
        }
        for (int i = 0; i < codes.size(); i++) {
            // find element by partialLink ( which was stored with earlier for loop)
            driver.findElement(By.partialLinkText(codes.get(i))).click();
            //String manupulation to create expected results
            String expectedResult = "This page returned a " + codes.get(i).toString() + " status code";
            String actualResult = driver.findElement(By.xpath("//p")).getText();
            //just to show results
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);
            // We can not get only one part of text so we use contains method of String class which return boolean
            Assert.assertTrue(actualResult.contains(expectedResult), "verify code");
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }

    }


    // Test 10 alternative - same method findBy xpath
    @Test
    public void test10alternate() throws InterruptedException {
        //navigate to related link
        driver.get("https://practice-cybertekschool.herokuapp.com/status_codes");
        // there is 4 status code under same parrent, create a WebElement list of them
        List<WebElement> allElements = driver.findElements(By.xpath("//div//ul/li"));

        // get the codes "text"  from allElemets LIST one by one,
        List codes = new ArrayList();
        for (WebElement allElement : allElements) {
            codes.add(allElement.getText());
            //code.add(200);
            //code.add(301);
        }

        for (int i = 0; i < codes.size(); i++) {
            String xpathAdress = "//a[contains(.,'" + codes.get(i).toString() + "')]";
            driver.findElement(By.xpath(xpathAdress)).click();
            String expectedResult = "This page returned a " + codes.get(i).toString() + " status code";
            String actualResult = driver.findElement(By.xpath("//p")).getText();
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);
            Assert.assertTrue(actualResult.contains(expectedResult), "verify code");
            driver.navigate().back();
        }

    }
/***
 * Test case #11
 * Step 1. Go to “https://practicecybertekschool.
 * herokuapp.com”
 * Step 3. And click on “Status Codes”.
 * Step 4. Then click on “404”.
 * Step 5. Verify that following message is displayed:
 * “This page returned a 404 status code”
 */

    @Test
    public void test11(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 3. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        //Step 4. Then click on “404”
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
        //Step 5. Verify that following message is displayed: “This page returned a 404 status code”
        String Actualtext = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 404')]")).getText();
        String Expectedtext = "This page returned a 404 status code";
        Assert.assertTrue(Actualtext.contains(Expectedtext));
        //System.out.println(Expectedtext);


    }

    /***
     * Step 1. Go to “https://practicecybertekschool.
     * herokuapp.com”
     * Step 3. And click on “Status Codes”.
     * Step 4. Then click on “500”.
     * Step 5. Verify that following message is displayed:
     * “This page returned a 500 status code”
     */
    @Test
    public void test12(){
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 3. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        //Step 4. Then click on “505”
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
        //Step 5. Verify that following message is displayed:“This page returned a 500 status code”
        String Actualtext = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 500')]")).getText();
        String Expectedtext = "This page returned a 500 status code";
        Assert.assertTrue(Actualtext.contains(Expectedtext));


    }


        @AfterClass
        public void after() {

            driver.quit();
        }


}