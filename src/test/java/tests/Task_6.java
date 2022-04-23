package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_6 {
private WebDriver  driver;
    @BeforeMethod
    public void setup(){
        driver = new BrowsersService().getDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public  void test() throws InterruptedException{
        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement myItem = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        myItem.click();
        Thread.sleep(2000);

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
