package baseEntities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.ContextMenuPage;
import pages.DynamicControlsPage;
import pages.FileUploadPage;


public class BaseStep {
    protected WebDriver driver;

    protected Actions actions;

    protected JavascriptExecutor javascriptExecutor;
    protected ContextMenuPage contextMenuPage;

    protected DynamicControlsPage dynamicControlsPage;

    protected FileUploadPage fileUploadPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        actions = new Actions(driver);

        javascriptExecutor= (JavascriptExecutor) driver;

        contextMenuPage = new ContextMenuPage(driver);

        dynamicControlsPage =new DynamicControlsPage(driver);

        fileUploadPage =new FileUploadPage(driver);



    }
}
