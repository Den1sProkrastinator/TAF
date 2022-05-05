package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    public SideMenuPage sideMenuPage;

    private By headerTitleLabelName = By.xpath(
            "//div[contains(@class, 'content-header-title') and contains(text(), '')]");

    public ProjectsPage(WebDriver driver) {
        super(driver);

        sideMenuPage = new SideMenuPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelName;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getProjectByNameLocator(){

        return   driver.findElement(headerTitleLabelName);
    }



}
