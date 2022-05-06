package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath="https://shootsmashchopstomp1.testrail.io/index.php?/milestones/add/1";


    //локаторы
    private By formLocator = By.id("form");
    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionDisplayLocator = By.id("description_display");
    private By startOnLocator = By.id("start_on");
    private By dueOnLocator = By.id("due_on");
    private By isCompletedLocator = By.id("is_completed");
    private By addMilestoneButtonLocator = By.id("accept");
    private By cancelButtonLocator = By.className("button button-left button-negative button-cancel milestone-form-cancel");
    private By successAddedLocator = By.xpath("//div[text()='Successfully added the new milestone.']");
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

    public WebElement getName(){
       return driver.findElement(nameLocator);
    }
    public WebElement getReferenceLocator(){
       return driver.findElement(referenceLocator);
    }
    public WebElement getDescriptionDisplayLocator(){
       return driver.findElement(descriptionDisplayLocator);
    }
    public WebElement getStartOnLocator(){
       return driver.findElement(startOnLocator);
    }
    public WebElement getDueOnLocator(){
       return driver.findElement(dueOnLocator);
    }
    public WebElement getAddMilestoneButtonLocator(){
       return driver.findElement(addMilestoneButtonLocator);
    }


}
