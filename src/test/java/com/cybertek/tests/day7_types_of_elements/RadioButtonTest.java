package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class RadioButtonTest {

        @Test
        public void radioBtnTest1() throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("http://practice.cybertekschool.com/radio_buttons");

            // better to run this code to see whether we successfully located web element or not
            WebElement blueRadioButton = driver.findElement(By.id("blue"));
            WebElement redRadioButton = driver.findElement(By.id("red"));

            //how to check is radio button selected ?
            System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
            System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());
            Thread.sleep(3000);

            //verify blue is selected red is not selected
            Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");
            Assert.assertFalse(redRadioButton.isSelected(),"Verify Red is NOT selected");
            Thread.sleep(3000);

            //how to select radio button ?
            //we use click method to select radio buttons
            redRadioButton.click();

            //verify blue is not selected red is selected
            Assert.assertFalse(blueRadioButton.isSelected(),"Verify Blue is NOT selected");
            Assert.assertTrue(redRadioButton.isSelected(),"Verify Red is selected");
            Thread.sleep(3000);

            driver.quit();
        }

    }

