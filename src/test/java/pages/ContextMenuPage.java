package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {

    private final static String pagePath = "/context_menu";

    private By hotSpotLocator = By.id("hot-spot");



    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected By getInvisibleElementIdentifier() {
        return null;
    }

    @Override
    protected By getVisibleElementIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getHotSpot() {
        return waitsService.waitForExists(hotSpotLocator);
    }


}
