package com.cybertek.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    //Task:
    //write a static method that takes a string parameter name:browserType
    //based on the value of parameter
    //it will setup the browser and
    //the method must return chromedriver or firefoxdriver object
    //name: getDriver
    public static WebDriver getDriver(String browserType){
        WebDriver driver= null;
        //"Chrome"  , "chrome", "CHROME"
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                //System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge Dev\\Application\\msedge.exe");
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "ie":
                //System.setProperty("webdriver.ie.driver", "pathofchromedriver\\IEDriverServer.exe");
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
        }
        return driver;

    }
}
