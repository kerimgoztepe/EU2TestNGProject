package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class wattsappCode {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://web.whatsapp.com/");
        // bu arada whatsapp web i açmak için karekod u okutmak gerekiyor telefona
        Thread.sleep(10000);
        //g2_cyberDE daha önce mesaj attığınız kişilerden birini seçiyor şimdilik. Rehberinizden istediğinizi seçebilirsiniz :)
        WebElement groupName = driver.findElement(By.xpath("(//span[@title='Kilciler'])[1]"));
        groupName.click();
        Thread.sleep(5000);
        WebElement messageBox = driver.findElement(By.xpath("(//div[@class='_2S1VP copyable-text selectable-text'])[2]"));
        Thread.sleep(1000);
        for(int i= 0; i<6;i++) {
            messageBox.sendKeys("Merhabalar. Ben mesaj atma otomasyonu :-) Günaydınlar...");
            Thread.sleep(1000);
            messageBox.sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
