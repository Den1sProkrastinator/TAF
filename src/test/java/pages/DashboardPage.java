package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard";

    // Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Dashboard')]");
    private String projectNameLocator="//div/a[@style and text()='Replace']";

    public DashboardPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов


    public WebElement getProjectByName(String projectName){
        return waitService.waitForExist(By.xpath(projectNameLocator.replace("Replace",projectName)));
    }



}
