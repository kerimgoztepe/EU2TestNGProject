package com.cybertek.tests.HW;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class VyTrack_US8_05_04 extends TestBase {

   @Test
    public void Test1() throws InterruptedException {
        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
       driver.get(ConfigurationReader.get("url"));
        //Use credentials to login
       WebElement userNameBox = driver.findElement(By.id("prependedInput"));
       userNameBox.sendKeys(ConfigurationReader.get("storemanager_username"));
       WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
       passwordBox.sendKeys(ConfigurationReader.get("storemanager_password")+ Keys.ENTER);

       //wait until loading completes
       WebDriverWait wait = new WebDriverWait(driver, 20);
       WebElement loader= driver.findElement(By.cssSelector(".loader-mask>.loader-frame"));
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       /***
        * AC1: Verify that authorized user should be able to access Vehicle Contract
        * and able to see all vehicle contracts on the grid
        */

       //hover over to Fleet module
       WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
       actions.moveToElement(fleet).pause(2000).perform();

       //Hover over to Vehicle Contracts module and click
       WebElement contracts = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]"));
       actions.moveToElement(contracts).pause(2000).click().perform();

       //wait until loading completes
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       //get title and print
       System.out.println("driver.getTitle() = " + driver.getTitle());

       //verify to see all vehicle contracts as a list
       String expected = "All - Vehicle Contract - Entities - System - Car - Entities - System";
       String actual = driver.getTitle();
       Assert.assertEquals(actual,expected,"verify to see vehicle contracts as a list");

       List<WebElement> contractsList = driver.findElements(By.xpath("//tbody/tr"));
       for (WebElement element : contractsList) {
           System.out.println("element.toString() = " + element.getText());
       }



       /***
        * AC2: Verify that authorized user should be able to create Vehicle contract
        */

       //Click on Create Vehicle Contract button
       driver.findElement(By.partialLinkText("Create Vehicle Contract")).click();

       //wait until loading completes
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       //verify to see all dropdown items on the grid
       ArrayList<String> items = new ArrayList<>();
       items.add("Leasing");
       items.add("Personal Loan");
       items.add("Credit Card");
       items.add("Cash");

       WebElement typeDropdown = driver.findElement(By.linkText("Choose a value..."));
       typeDropdown.click();

      List<WebElement> typeElements = driver.findElements(By.xpath("//*[@class='select2-result-label']"));

      for (int i = 0; i < typeElements.size(); i++) {
           Assert.assertEquals(typeElements.get(i).getText(),items.get(i),"verify dropdown items to see");
           System.out.println("items = " + typeElements.get(i).getText());
       }


      //enter valid info to empty spaces
      typeElements.get(2).click();
      driver.findElement(By.name("custom_entity_type[Responsible]")).sendKeys("Halim Smith");
      driver.findElement(By.name("custom_entity_type[ActivationCost]")).sendKeys("12345");
      driver.findElement(By.name("custom_entity_type[OdometerDetails]")).sendKeys("12345");
      driver.findElement(By.name("custom_entity_type[Vendor]")).sendKeys("Halim Malim");
      driver.findElement(By.name("custom_entity_type[Driver]")).sendKeys("Osman Driver");

      //Click on Save And Close button
      driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
      wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

      //verify to see "Entity saved" message
      WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
      Assert.assertTrue(message.isDisplayed(), "verify save message is displayed");

/**
 * Verify that authorized user should be able to Edit or Delete the Vehicle Contract or do more action
 */

       //hover over to Fleet module
       actions.moveToElement(fleet).pause(2000).perform();

       //Hover over to Vehicle Contracts module and click
       actions.moveToElement(contracts).pause(2000).click().perform();

       //wait until loading completes
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       //locate a contract and click on it
       driver.findElement(By.linkText("Halim Smith")).click();

       //wait until loading completes
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       /*//Verify that you get your vehicle info successfully
       String actualVehicleInfo = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();
       String expectedVehicleInfo = "Halim Smith Vendor Driver Smith Muhammet Ali";
       Assert.assertTrue(actualVehicleInfo.contentEquals(expectedVehicleInfo),"verify vehicle info");
       System.out.println("expectedVehicleInfo = " + expectedVehicleInfo);
       System.out.println("actualVehicleInfo = " + actualVehicleInfo);
       Thread.sleep(3000);*/



        //verify that you edit one vehicle contract info add new info and verify you made changes

       //locate edit button and click
       WebElement editButton = driver.findElement(By.xpath("//a[@title='Edit Vehicle Contract']"));
       actions.moveToElement(editButton).click().perform();
       Thread.sleep(2000);

       //locate VehiclesModel button and click
       WebElement VehiclesModelButton = driver.findElement(By.xpath("//a[.='VehiclesModel']"));

       //use actions to click on VehiclesModel button
       actions.moveToElement(VehiclesModelButton).click().perform();
       Thread.sleep(2000);

       //locate 1st add button and click
       WebElement AddButton1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
       AddButton1.click();
       Thread.sleep(2000);

       //locate any element (Accord) and click on it then click on select button
       WebElement checkBoxItem = driver.findElement(By.xpath("//tbody/tr[12]/td[1]"));
       checkBoxItem.click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//*[.='Select'])[2]")).click();
       Thread.sleep(2000);

       //locate and verify model name is displayed
       String expectedName = "Model Name: Accord";
       WebElement modelName = driver.findElement(By.xpath("//*[.='Model Name: Accord']"));
       Assert.assertTrue(modelName.isDisplayed(),"verify that model name is displayed");
       Assert.assertTrue(expectedName.contentEquals(modelName.getText()),"verify that modelName is equal to our expected name");
       System.out.println("expectedName = " + expectedName);
       System.out.println("modelName = " + modelName.getText());

       //locate save and close button and click
       driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

       //waiting for the loader is gone
       wait = new WebDriverWait(driver, 10);
       loader= driver.findElement(By.cssSelector(".loader-mask>.loader-frame"));
       wait.until(ExpectedConditions.invisibilityOfAllElements(loader));

       //locate and verify change message is displayed (be careful just a few seconds then message is gone
       WebElement flashMessage= driver.findElement(By.xpath("//div[@class='flash-messages-holder']"));
       wait.until(ExpectedConditions.visibilityOf(flashMessage));
       System.out.println("flashMessage = " + flashMessage.getText());

       Assert.assertTrue(flashMessage.isDisplayed(), "add vehicle model message is displayed");


   }

}
