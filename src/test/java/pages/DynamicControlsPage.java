package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlsPage extends BasePage {
    private final static String pagePath = "/dynamic_controls";

    private By checkboxLocator = By.cssSelector("[type='checkbox']");
    private By swapCheckboxLocator = By.cssSelector("[onclick='swapCheckbox()']");
    private By swapInputLocator = By.cssSelector("[onclick='swapInput()']");

    private By messageLocator = By.id("message");





    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected By getInvisibleElementIdentifier() {
        return messageLocator;
    }

    @Override
    protected By getVisibleElementIdentifier() {
        return checkboxLocator;
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    public WebElement getCheckboxSpot() {
        return waitsService.waitForExists(checkboxLocator);
    }

    public WebElement getSwapCheckboxSpot() {
        return waitsService.waitForExists(swapCheckboxLocator);
    }

    public WebElement getSwapInputSpot() {
        return waitsService.waitForExists(swapInputLocator);
    }

    public WebElement getMessageSpot() {
        return waitsService.waitForExists(messageLocator);
    }

}
