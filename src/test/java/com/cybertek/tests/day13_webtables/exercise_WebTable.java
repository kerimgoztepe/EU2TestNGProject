package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class exercise_WebTable {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeUp() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr/td"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void test2(){
        int rows = getRows();
        int columns = getColumns();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String tableItem = "//table[@id='table1']//tbody/tr[" + i + "]/td[" + j + "]";
                String wantedItem = "//table[@id='table1']//tbody/tr[" + i + "]";

                WebElement element = driver.findElement(By.xpath(tableItem));
                if (element.getText().equals("Jason")){
                    WebElement target = driver.findElement(By.xpath(wantedItem));
                    System.out.println("Jason info = " + target.getText());
                }



            }

        }
    }

    private int getRows() {
        List<WebElement> rowsNo = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        return rowsNo.size();
    }

    private int getColumns() {
        List<WebElement> columnNo = driver.findElements(By.xpath("//table[@id='table1']//thead/tr/th"));
        return columnNo.size();
    }
}
