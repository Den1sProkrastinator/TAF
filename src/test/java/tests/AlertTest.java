package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AlertTest extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        alert.accept();

    }

    @Test
    public void confirmationInfoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");


    }

    @Test
    public void confirmationDeclineInfoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");


    }

    @Test
    public void promtInfoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Test message");

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
