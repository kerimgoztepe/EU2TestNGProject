package com.cybertek.tests.day4_basic_locators;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        //make browser fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullNameInputbox = driver.findElement(By.name("full_name"));
        fullNameInputbox.sendKeys("Mike Smith");
        //put some email and click sign up button
        WebElement emailInputbox = driver.findElement(By.name("email"));
        emailInputbox.sendKeys("mike@smith.com");
        //proper way
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();
        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();
        // verify "Thank you for signing up. Click the button below to return to the home page."
        Thread.sleep(3000);
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement actualMessageElement = driver.findElement(By.name("signup_message"));
        String actualMessage = actualMessageElement.getText();
        //lazy way
        String message = driver.findElement(By.name("signup_message")).getText();
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }
        driver.quit();
    }
}
