import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTest {
private  WebDriver  driver;


        @Test
        public void browserTest (){
            SimpleDriver simpleDriver= new SimpleDriver();
        driver  =    simpleDriver.getDriver();

        }
    @Test
    public void browserAdvacedTest (){
        AdvancedDriver advancedDriverDriver= new AdvancedDriver();
        driver  =    advancedDriverDriver.getDriver();

    }
    @Test
    public void browserServiseTests (){
        BrowserService browserService= new BrowserService();
        driver  =    browserService.getDriver();

    }


    }

