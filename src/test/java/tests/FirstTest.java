package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
private  WebDriver  driver;


        @Test
        public void browserTest (){
            SimpleDriver simpleDriver= new SimpleDriver ();
        driver  =    simpleDriver.getDriver();

        }
    @Test
    public void browserTest1 (){
        AdvancedDriver advancedDriverDriver= new AdvancedDriver();
        driver  =    advancedDriverDriver.getDriver();

    }
    }

