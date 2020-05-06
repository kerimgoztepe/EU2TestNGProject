package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class exercise_VyTrack_Tables {

    WebDriver driver;

    @DataProvider // truck driver credentials for login
    public static Object[][] credentials() {

        return new Object[][]{{"user16", "UserUser123"}};
    }
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }

    @Test (dataProvider = "credentials")
    public void test1 (String userName, String password){
        //use credentials provided by data provider and login
        driver.findElement(By.id("prependedInput")).sendKeys(userName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        //System.out.println("Before clicking submit Title : " + driver.getTitle());
        driver.findElement(By.id("_submit")).click();

        //hover over Fleet module then Hover over to Vehicle Contracts module and click
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        WebElement element2 = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[1]"));
        action.moveToElement(element1).pause(1000).click().perform();
        action.moveToElement(element2).pause(1000).click().perform();

        //locate and find out row and column numbers using methods below
        int rows = getRows();
        int columns = getColumns();

        //looking for item "Sharon Beatty"
        String name = "Sharon Beatty";

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                String tableItem = "//tbody/tr[" + i + "]/td[" + j + "]";

                WebElement element = driver.findElement(By.xpath(tableItem));
                if (element.getText().equals(name)){
                    String wantedItem = "//tbody/tr[" + i + "]";
                    WebElement targetItem = driver.findElement(By.xpath(wantedItem));
                    System.out.println("Item info = " + targetItem.getText());
                    break;
                }
            }
        }

    }
    private int getRows() {
        List<WebElement> rowsNo = driver.findElements(By.xpath("//tbody/tr"));
        return rowsNo.size();
    }

    private int getColumns() {
        List<WebElement> columnNo = driver.findElements(By.xpath("//thead/tr/th"));
        return columnNo.size();
    }
}
