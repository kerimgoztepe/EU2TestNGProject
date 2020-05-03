package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class exercise {

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
//Loop içinde geçişler yok sadece ilk resim için işlem yapıyor???
    @Test
    public void test() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");
        for (int i = 0; i < 4; i++) {
            WebElement img1 = driver.findElement(By.tagName("img"));
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(img1).perform();

        }
    }
}


