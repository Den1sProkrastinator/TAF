package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath="https://shootsmashchopstomp1.testrail.io/index.php?/milestones/add/1";

    private By formLocator = By.id("form");
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return formLocator;
    }
    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }




}
