package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlTest extends BaseTest {

    @Test
    public void dynamicControlTest() throws InterruptedException {
        dynamicControlsStep.openPage();

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));


        Assert.assertTrue(dynamicControlsStep.removeDynamicControls().checkedElementIsInvisible());


//        Assert.assertTrue(wait.waitForElementInvisible((WebElement) By.cssSelector("[type='checkbox']")));


        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled") != null);

        dynamicControlsStep.enableDisableClick();
        Thread.sleep(2000);
        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(wait.waitForExists(By.cssSelector("[type='text']")).getAttribute("disabled") == null);

    }
}
