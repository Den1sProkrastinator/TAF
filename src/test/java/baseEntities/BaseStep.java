package baseEntities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;
import pages.DynamicControlsPage;


public class BaseStep {
    protected WebDriver driver;

    protected Actions actions;
    protected ContextMenuPage contextMenuPage;

    protected DynamicControlsPage dynamicControlsPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        actions = new Actions(driver);

        contextMenuPage = new ContextMenuPage(driver);

        dynamicControlsPage =new DynamicControlsPage(driver);

    }
}
