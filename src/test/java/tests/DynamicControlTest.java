package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlTest extends BaseTest {

    @Test
    public void dynamicControlTest() throws InterruptedException {

        dynamicControlsStep.openPage();

        Assert.assertTrue(dynamicControlsStep.removeDynamicControls().checkedElementIsVisible());

//        Assert.assertTrue(dynamicControlsStep.getCheckboxLocator().checkedElementIsInvisible()); пройтись дебагом

        Assert.assertTrue(dynamicControlsStep.elementStatusIsDisabled());

        dynamicControlsStep.enableDisableClick();

        Assert.assertTrue(wait.waitForVisibilityLocatedBy(By.id("message")).isDisplayed());

        Assert.assertTrue(dynamicControlsStep.elementStatusIsEnabled());

    }
}
