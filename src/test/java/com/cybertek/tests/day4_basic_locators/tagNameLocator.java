package com.cybertek.tests.day4_basic_locators;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputbox = driver.findElement(By.tagName("input"));
        fullNameInputbox.sendKeys("Mike Smith Tag Name ");
        WebElement emailInputbox = driver.findElement(By.name("email"));
        emailInputbox.sendKeys("mike@smith.com");
        //click the button with tagname
        driver.findElement(By.tagName("button")).click();
        //print the message
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.quit();
    }
}