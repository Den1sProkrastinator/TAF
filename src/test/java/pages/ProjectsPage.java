package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

    //локаторы
    @FindBy(xpath = "//div[contains(@class, 'content-header-title') and contains(text(), '')]")
    public WebElement headerTitleLabelName;


    @FindBy(id = "navigation-milestones-add")
    public WebElement addMilestones;

    private String navigationName = "//div//li/a[text()='Replace']";


    public ProjectsPage(WebDriver driver) {
        super(driver);

    }


    //атомарные методы
    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabelName;
    }


    public WebElement getMenuByName(String menuName) {
        return driver.findElement(By.xpath(navigationName.replace("Replace", menuName)));
    }


}
