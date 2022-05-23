package tests;

import baseEntities.BaseTest;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;


import java.time.Duration;


public class HW_Tests extends BaseTest {


    @Test
    public void contextMenuTest() {

        contextMenuStep.contextMenu();
    }



    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(30));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));


        fileUploadPath.sendKeys("C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\download.jpg");

        jsExecutor.executeScript("arguments[0].click();", wait.waitForExists(By.id("file-submit")));

        Assert.assertEquals(wait.waitForExists(By.className("example")).getText(), "File Uploaded!\n" +
                "download.jpg");


    }


    @Test
    public void fileDownloadTest() {
        driver.get("http://the-internet.herokuapp.com/download");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement fileDownloadPath = wait.waitForExists(By.linkText("some-file.txt"));


        jsExecutor.executeScript("arguments[0].click();", fileDownloadPath);


    }

    @Test

    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(30));

        driver.switchTo().frame(wait.waitForExists(By.id("mce_0_ifr")));
        Assert.assertEquals(wait.waitForExists(By.cssSelector("#tinymce")).getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

    }


    @Test
    public void javaScriptAlertsTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");


        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String muText = "Text for test";
        WebElement webElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));


        jsExecutor.executeScript("arguments[0].click();", webElement);


        Alert alert = driver.switchTo().alert();


        alert.sendKeys(muText);


        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: " + muText);


    }
}
