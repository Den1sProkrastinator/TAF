package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath="";

    //локаторы

    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionDisplayLocator = By.id("description_display");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");

    private By addMilestoneButtonLocator = By.id("accept");

    private By cancelButtonLocator = By.cssSelector(".button.button-left.button-negative.button-cancel.milestone-form-cancel");

    private By successAddedLocator = By.xpath("//div[text()='Successfully added the new milestone.']");

    private String milestonesNameLocator = "//div/a[.='Replace']";

    private By milestoneIsOpeningLocator= By.cssSelector("content-header-title page_title display-inline-block");

    private By startMilestoneLocator = By.id("navigation-milestones-start");

    private By startMilestoneButtonLocator = By.id("startMilestoneSubmit");

    private By successStartMilestoneButtonLocator = By.cssSelector("message message-success");






    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
         return successAddedLocator;
    }

//    public By getLocatorIdentifier(){
//
//    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getName(){
       return driver.findElement(nameLocator);
    }
    public WebElement getReference(){
       return driver.findElement(referenceLocator);
    }
    public WebElement getDescriptionDisplay(){
       return driver.findElement(descriptionDisplayLocator);
    }
    public WebElement getStartDate(){
       return driver.findElement(startDateLocator);
    }
    public WebElement getEndDate(){
       return driver.findElement(endDateLocator);
    }
    public WebElement getAddMilestoneButton(){
       return driver.findElement(addMilestoneButtonLocator);
    }
    public WebElement getStartMilestone(){
       return driver.findElement(startMilestoneLocator);
    }
    public WebElement getStartMilestoneButton(){
       return driver.findElement(startMilestoneButtonLocator);
    }

    public WebElement getMilestoneIsOpening(){
       return driver.findElement(milestoneIsOpeningLocator);
    }

    public WebElement getMilestoneName(String milestoneName){
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace",milestoneName)));
    }
    public WebElement getMilestoneIsOpening(String milestoneName){
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace",milestoneName)));
    }



}
