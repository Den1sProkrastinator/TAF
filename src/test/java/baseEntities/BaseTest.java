package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DynamicControlsPage;
import services.BrowsersService;
import steps.ContextMenuStep;
import steps.DynamicControlsStep;

public class BaseTest {
    protected WebDriver driver;

    protected ContextMenuStep contextMenuStep;

    protected DynamicControlsStep dynamicControlsStep;


    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        contextMenuStep = new ContextMenuStep(driver);
        dynamicControlsStep = new DynamicControlsStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
