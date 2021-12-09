package com.cybertek.tests.exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task {

    /*
1- Open an empty browser
2- Navigate to https://www.amazon.com/
3- Get the page title
4- Verify the title "Amazon.com. Spend less. Smile more."
5- Navigate to https://www.youtube.com/
6- Get the page title
7- Verify the title "YouTube"
8- Navigate back to https://www.amazon.com/
9- Refresh the web page
10-Quit the page
     */



    @Test
    public void task1(){

        //1- Open an empty browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2- Navigate to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3- Get the page title
        String amazonPageTitle = driver.getTitle();
        System.out.println("amazonPageTitle = " + amazonPageTitle);

        //4- Verify the title "Amazon.com. Spend less. Smile more."
        if (amazonPageTitle.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("--- Amazon page title is VERIFIED ---");
        }else {
            System.out.println("***** Amazon page title is WRONG *****");
        }

        //5- Navigate to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        //6- Get the page title
        String youtubePageTitle = driver.getTitle();
        System.out.println("youtubePageTitle = " + youtubePageTitle);

        //7- Verify the title "YouTube"
        if (youtubePageTitle.equals("YouTube")){
            System.out.println("--- Youtube page title is VERIFIED ---");
        }else {
            System.out.println("***** Youtube page title is WRONG *****");
        }

        //8- Navigate back to https://www.amazon.com/
        driver.navigate().back();

        //9- Refresh the web page
        driver.navigate().refresh();

        //10-Quit the page
        driver.quit();


    }

}
