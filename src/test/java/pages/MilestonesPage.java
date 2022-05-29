package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestonesPage extends BasePage {


    // локаторы
    private String milestonesNameLocator = "//div/a[.='Replace']";

    private String deleteButtonLocator =
            "//div/div/a[@href and text()='Replace']/following::a[@class='deleteLink'][1]";

    @FindBy(xpath = "//*[@id=\"deleteDialog\"]/div[3]/a[1]")
    public WebElement okButton;


    @FindBy(xpath = "//div[text()='Successfully added the new milestone.']")
    public WebElement successAdded;


    @FindBy(id = "navigation-milestones-add")
    public WebElement addMilestones;

    @FindBy(xpath = "//div[@class='message message-success']")
    public WebElement successDelete;


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return successAdded;
    }

    //атомарные методы

    public WebElement getMilestoneName(String milestoneName) {
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace", milestoneName)));
    }


    public WebElement getDeleteButton(String milestoneName) {
        return driver.findElement(By.xpath(deleteButtonLocator.replace("Replace", milestoneName)));
    }

}
