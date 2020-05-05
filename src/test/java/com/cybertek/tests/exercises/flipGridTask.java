package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class flipGridTask {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //driver.navigate().to("https://my.flipgrid.com/");
        driver.get("https://my.flipgrid.com");
        Thread.sleep(3000);

        //make full-screen to better see pop-ups and prevent problems
        driver.manage().window().maximize();

        //locate Login with Google box, click on it
        driver.findElement(By.xpath("//button[@data-testid='googleSSOButton__button__login']")).click();
        //Thread.sleep(2000); // yeni acılan pop up pencerenin tam yuklenmesı ıcın bekle

        //Handle new window
        Set<String> currentWindowHandle = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();

        for (String newWindow : currentWindowHandle) {
            if (!newWindow.equals(currentWindowHandle)) {
                driver.switchTo().window(newWindow);
            }
        }

        //locate emailbox, send email, click Enter
        driver.findElement(By.id("identifierId")).sendKeys("h_iltas@yahoo.com", Keys.ENTER);

        //locate password box, send password, click Enter
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("03412Key", Keys.ENTER);

        //Switch back to main window
        driver.switchTo().window(mainWindow);

        //locate counter and get number of watches
        WebElement counter = driver.findElement(By.xpath("(//td[@class='table__cell  text-center hide-for-medium-down'])[1]"));
        String firstCount = counter.getText();

        // loop for watch video
        int n = 5;
        for (int i = 1; i <= n; i++) {
            driver.findElement(By.xpath("//img[1]")).click();
            Thread.sleep(6000);
            Actions escButton = new Actions(driver);
            escButton.click().perform();
        }

        //get the last watch counter number as String
        String lastCount = counter.getText();

        System.out.println("lastCount = " + lastCount);
        System.out.println("firstCount = " + firstCount);

        //parse String counter values to Integer to verify that count is increased
        int firstCountInt = Integer.valueOf(firstCount);
        int lastCountInt = Integer.valueOf(lastCount);

        //verification of increased number
        Assert.assertTrue(lastCountInt == firstCountInt + n, "verification of increased views by " + n + " times");

    }


}