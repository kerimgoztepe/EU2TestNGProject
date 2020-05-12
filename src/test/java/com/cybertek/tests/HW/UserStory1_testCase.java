package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class UserStory1_testCase {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa1.vytrack.com/user/login");
    }


    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider(name = "UserLoginPreConditions")
    public Object[][] loginData(Method testCase){    // username + password sıralamasını kullan!!
    /* long way
        Object [][] users = new Object[][]{
                {"user7", "UserUser123"},
                {"user8", "UserUser123"},
                {"user9", "UserUser123"}
        }; */
        return new Object[][]{
                {"user7" , "UserUser123"}/*,
                    {"user8" , "UserUser123"},
                    {"user9" , "UserUser123"}*/ };
    }



    @Test(dataProvider = "UserLoginPreConditions" )
    public void UserStory_1_Test(String userName, String password) throws InterruptedException {
        // User Story 1: As a truck driver I should be able to access Vehicle under Fleet module.
        // Acceptance Criteria
//        1.Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
//        2.Verify that when user  click on any car on the grid , system should display general information about the car
//        3.Verify that truck driver can add Event and it should display under Activity tab and General information page as well .
//        4.Verify that Truck driver can reset the Grid by click on Grid setting

        // Driver login home page
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        String actualTitle= driver.getTitle();


        // waite for loading  circle
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loader= driver.findElement(By.cssSelector(".loader-mask>.loader-frame"));
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));


        //*****************  Verify AC-1  *****************

        // click module
        WebElement fleetModule = driver.findElement(By.xpath("//span[contains(text(), 'Fleet')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetModule).pause(1000).perform();
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();

        //wait for loading  circle
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        //verify Vehicle information page is displayed
        String expectedTitle= "Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //extra verify with table heads
        String expectedInfo = "LICENSE PLATE\n" + "TAGS\n" + "DRIVER\n" + "LOCATION\n" + "CHASSIS NUMBER\n" + "MODEL YEAR\n" + "LAST ODOMETER\n" + "IMMATRICULATION DATE\n" + "FIRST CONTRACT DATE\n" + "CVVI\n" + "SEATS NUMBER\n" + "DOORS NUMBER\n" + "COLOR\n" + "TRANSMISSION\n" + "FUEL TYPE\n" + "CO2 EMISSIONS\n" + "HORSEPOWER\n" + "HORSEPOWER TAXATION\n" + "POWER (KW)";
        String actualInfo =driver.findElement(By.xpath("//thead[@class='grid-header']")).getText();
        //Assert.assertEquals(actualInfo,expectedInfo);


        //*****************  Verify AC-2  *****************

        //locate the first cell and click
        WebElement firstRowPlate= driver.findElement(By.xpath("(//tbody//td)[1]"));
        String expectedPlate= firstRowPlate.getText();
        firstRowPlate.click();

        //wait
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        //Verify system should display general information about the car
        String actualPlate= driver.findElement(By.xpath("(//h5/../div/div)[1]")).getText();  // //chil -- parent -- child
        Assert.assertEquals(actualPlate, expectedPlate);

        // and also Verify General info page
        String pageHead= driver.findElement(By.tagName("h5")).getText();
        Assert.assertEquals(pageHead,"General Information");


        //*****************  Verify AC-3  *****************

        // Click on add event button
        //driver.findElement(By.partialLinkText("Add Event")).click(); //ATTENTION, direk link ismi kullanma, boşluk vb var!!
        //driver.findElement(By.cssSelector(".btn.icons-holder-text.no-hash")).click();

        //wait
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        //enter input into  event title
        String eventTitle= "group study title";
        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys(eventTitle);

        //switch to iframe
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).sendKeys("This is group study description");

        //switch back to the main html page & click submit BUTTON
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //wait
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        // Verify flash message is displayed
        WebElement flashMessage= driver.findElement(By.xpath("//div[@class='flash-messages-holder']"));

        // add wait for visibilty of flash message
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        System.out.println("flashMessage = " + flashMessage.getText());

        Assert.assertTrue(flashMessage.isDisplayed(), "add event message is displayed");

        //Verify that truck driver can add Event and it should display under Activity tab and General

        //refresh the page for the event to be displayed
        driver.navigate().refresh();
        wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

        String actualEventTitle= driver.findElement(By.tagName("strong")).getText();
        Assert.assertEquals(actualEventTitle, eventTitle);


        // to be continue insallah... (10/05/2020)
        //*****************  Verify AC-4  *****************

    }
}
