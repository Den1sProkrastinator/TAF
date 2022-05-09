package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";

    private By headerTitleLabelName = By.xpath(
            "//div[contains(@class, 'content-header-title') and contains(text(), '')]");
    private  String  navigationName ="//div//li/a[text()='Replace']";
    private By addMilestonesLocator = By.id("navigation-milestones-add");

    public ProjectsPage(WebDriver driver) {
        super(driver);

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


    public WebElement getMenuByName(String menuName){
        return driver.findElement(By.xpath(navigationName.replace("Replace",menuName)));
    }
    public WebElement getAddMilestones(){
        return  driver.findElement(addMilestonesLocator);
    }




}
