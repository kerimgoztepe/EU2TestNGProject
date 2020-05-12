package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class exercise {

    WebDriver driver;

    @DataProvider
    public static Object[][] credentials() {
        return new Object[][]{
                {"storemanager61", "UserUser123"},
                {"salesmanager117", "UserUser123"}};
    }

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test(dataProvider = "credentials")
    public void test1(String username, String password) throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='dropdown dropdown-level-1']"));
        for (int i = 0; i <= 5; i++) {
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(elements.get(i)).perform();
            Thread.sleep(5000);
            System.out.println(elements.get(i).getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys("storemanager61");
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        String str = "//li[@class='dropdown dropdown-level-1'][1]";
        WebElement element = driver.findElement(By.xpath(str));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.xpath("(//li[@class='dropdown-menu-single-item'])[2]"));
        actions.moveToElement(button).click().perform();
        Assert.assertTrue(element.isDisplayed(), "verif is OK");
        System.out.println(element.getText());
        List<WebElement> elements = driver.findElements(By.className("//thead[@class='grid-header']/tr/th"));
        System.out.println(elements.size());
        List<WebElement> elements1 = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        System.out.println(elements1.size());
    }

}
