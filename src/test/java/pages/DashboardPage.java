package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {


    // Блок описания селекторов для элементов
    private By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Dashboard')]");
    private String projectNameLocator = "//div/a[@style and text()='Replace']";

    public DashboardPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }


    // Блок атомарных методов

    public WebElement getProjectByName(String projectName) {
        return waitService.waitForExists(By.xpath(projectNameLocator.replace("Replace", projectName)));
    }

    //Блок комплексных методов

    public ProjectsPage projectSelection(String projectName) {

        getProjectByName(projectName).click();

        return new ProjectsPage(driver);
    }


}
