package com.cybertek.tests.HW;

import com.cybertek.utilities.WebDriverFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class canvasCheckTryOut {


    @Test
    public void Canvas() throws InterruptedException, IOException {

        String path = "C:\\Users\\LENOVO\\IdeaProjects\\EU2TestNGProject\\src\\test\\resources\\dersler.xlsx";
        Workbook workbook = WorkbookFactory.create(new File(path));
        Sheet lessonList = workbook.getSheet("Sheet1");
        int lastRow1 = lessonList.getLastRowNum();
        Sheet studentList = workbook.getSheet("EU7");
        int lastRow2 = studentList.getLastRowNum();

        ArrayList<Cell> Lessons = new ArrayList<>();
        ArrayList<Cell> Students = new ArrayList<>();
        //String[] mylastarray = new String[10];

        String mesaj = lessonList.getRow(0).getCell(0).getStringCellValue();
        System.out.println(mesaj);

        for (int i = 1; i <= lastRow1; i++) {
            Lessons.add(lessonList.getRow(i).getCell(0));
        }

        for (Cell cell : Lessons) {
            System.out.println(cell.getStringCellValue());
        }

        for (int i = 1; i <= lastRow2; i++) {
            Students.add(studentList.getRow(i).getCell(0));
        }

        String mail = "hiltas@cybertekschool.com";
        String password = "7378OnurNermin";

        ////////////////////////////////////////////////////

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://cybertekschool.okta.com/app/UserHome");
        driver.findElement(By.xpath("//*[@id=\"okta-signin-username\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"okta-signin-password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"okta-signin-submit\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"form8\"]/div[2]/input")).click();
        Thread.sleep(20000);


        /** OPEN YOUR MOBILE PHONE AND APPROVE OKTA LOGIN*/


        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        driver.get("https://learn.cybertekschool.com/courses/540");
        for (Cell lesson : Lessons) {
            driver.get(lesson.getStringCellValue());
            driver.switchTo().defaultContent();
            Thread.sleep(5000);
            //String nameOfLesson = driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/ul/li[4]/span")).getText();
            driver.switchTo().frame(1);
            Thread.sleep(10000);
            WebElement insightTab = driver.findElement(By.xpath("//*[@id=\"tab-insights\"]"));
            insightTab.click();
            Thread.sleep(3000);

            for (Cell student : Students) {
                driver.findElement(By.xpath("//*[.=\"" + student.getStringCellValue() + "\"]")).click();
                Thread.sleep(1000);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", insightTab);


                Thread.sleep(3000);
            }
        }
    }
}

