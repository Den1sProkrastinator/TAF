package tests;

import baseEntities.BaseTest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {



    @Test
    public void contextMenu()  {
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
    public void dynamicControls() throws InterruptedException {
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
        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled")!=null);

        actions
                .moveToElement(enableDisableButtonLocator)
                .click()
                .build()
                .perform();

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());

        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled")==null);

    }

    @Test
    public void fileUpload()  {
        driver.get("http://the-internet.herokuapp.com/upload");


        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
//        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpg").getPath();


        fileUploadPath.sendKeys("C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\download.jpg");
        wait.waitForExists(By.id("file-submit")).submit();


    }


    @Test
    public void fileDownload() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/download");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileDownloadPath = wait.waitForExists(By.linkText("some-file.txt"));


        fileDownloadPath .click();

        Thread.sleep(500);

        fileDownloadPath.click();

        Thread.sleep(15000);

    }



}
