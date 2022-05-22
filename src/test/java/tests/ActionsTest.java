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


public class ActionsTest extends BaseTest {


    @Test
    public void contextMenuTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement boxLocator = wait.waitForExists(By.id("hot-spot"));

        actions
                .moveToElement(boxLocator, 15, 15)
                .contextClick(boxLocator)
                .build()
                .perform();


        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


    @Test
    public void dynamicControlsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkBoxLocator = wait.waitForExists(By.cssSelector("[type='checkbox']"));
        WebElement removeButtonLocator = wait.waitForExists(By.cssSelector("[onclick='swapCheckbox()']"));
        WebElement enableDisableButtonLocator = wait.waitForExists(By.cssSelector("[onclick='swapInput()']"));

        actions
                .moveToElement(checkBoxLocator)
                .click()
                .build()
                .perform();
        Thread.sleep(2000);
        actions
                .moveToElement(removeButtonLocator)
                .click()
                .build()
                .perform();
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());

        Assert.assertTrue(wait.waitForElementInvisible(checkBoxLocator));
        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled") != null);

        actions
                .moveToElement(enableDisableButtonLocator)
                .click()
                .build()
                .perform();

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());

        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled") == null);

    }

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

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
