package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DynamicControlsPage;
import services.BrowsersService;
import services.WaitsService;
import steps.ContextMenuStep;
import steps.DynamicControlsStep;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected ContextMenuStep contextMenuStep;

    protected DynamicControlsStep dynamicControlsStep;

    protected WaitsService wait;


    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();
        contextMenuStep = new ContextMenuStep(driver);
        dynamicControlsStep = new DynamicControlsStep(driver);
        wait= new WaitsService(driver, Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
