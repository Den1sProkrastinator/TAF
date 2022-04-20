package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorTest {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new BrowsersService().getDriver();


    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void basicLocatorsTest_1() throws InterruptedException {
        driver.get(ReadProperties.getUrl());



        //Find web elemet by ID

        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());

        //Find Web element by name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());

        //Find web element by tag name
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

    }



    @Test
    public void basicLocatorsTest_2() throws InterruptedException {

        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);

        //Find new elements by linkText

        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);

        //Find new element by ClassName

        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();
        Thread.sleep(2000);


        //Find web element by PartialLinkTex
        driver.findElement(By.partialLinkText("your password")).click();
        Thread.sleep(2000);



    }


}
