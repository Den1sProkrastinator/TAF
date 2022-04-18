package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
