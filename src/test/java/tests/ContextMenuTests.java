package tests;

import baseEntities.BaseTest;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;


import java.time.Duration;


public class ContextMenuTests extends BaseTest {


    @Test
    public void contextMenuTest() {
        contextMenuStep.contextMenu();
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