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

        WebElement checkBoxLocator = wait.waitForExists(By.cssSelector("[type='checkbox']"));
        dynamicControlsStep.removeDynamicControls();
        Assert.assertEquals(dynamicControlsStep.getMessageElement().getText(),"It's gone!");

        Assert.assertTrue(wait.waitForElementInvisible(checkBoxLocator));

        Assert.assertTrue(dynamicControlsStep.elementStatusIsDisabled());


        dynamicControlsStep.enableDisableClick();

        Assert.assertEquals(dynamicControlsStep.getMessageElement().getText(),"It's enabled!");

        Assert.assertTrue(dynamicControlsStep.elementStatusIsEnabled());

    }


}
