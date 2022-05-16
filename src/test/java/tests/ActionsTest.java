package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath();
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }

    @Test
    public void contextMenu() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement boxLocator = wait.waitForExists(By.id("hot-spot"));

        actions
                .moveToElement(boxLocator, 15, 15)
                .contextClick(boxLocator)
                .build()
                .perform();

        actions
                .keyDown(Keys.ENTER)
                .build()
                .perform();
        Thread.sleep(2000);
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
        Thread.sleep(2000);
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());

        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled")==null);

    }

    @Test
    public void fileUpload() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/upload");


        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpg").getPath();


        fileUploadPath.sendKeys("C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\download.jpg");
        wait.waitForExists(By.id("file-submit")).submit();
        Thread.sleep(2000);




    }
}
