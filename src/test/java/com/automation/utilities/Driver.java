package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    private static WebDriver driver;

    //so noone can create an object of Driver class
    //everyone should call static getter method instead
    private Driver(){

    }

    public synchronized static WebDriver getDriver(){
        //if webdriver object does not exist create it
        if (driver==null) {
            String browser= ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver=new ChromeDriver(chromeOptions);
                    break;
                case "chromeheadless":
                    //to run chrome without interface(headless)
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions options=new ChromeOptions();
                    options.setHeadless(true);
                    driver=new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
