package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "";

    //локаторы страницы  создания milestone и редактирования

    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionDisplayLocator = By.id("description_display");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");
    private By addMilestoneButtonLocator = By.id("accept");

    // локаторы навигации во вкладке milestone
    private String milestonesNameLocator = "//div/a[.='Replace']";

    private By editButtonLocator = By.xpath("//div/a[text()='Edit']");

    private String deleteButtonLocator=
            "//div/div/a[@href and text()='Replace']/following::a[@class='deleteLink'][1]";
    private By okButtonLocator=By.xpath("//*[@id=\"deleteDialog\"]/div[3]/a[1]");

    private By successAddedLocator = By.xpath("//div[text()='Successfully added the new milestone.']");

    private By addMilestonesLocator = By.id("navigation-milestones-add");



    private By startMilestoneLocator = By.id("navigation-milestones-start");

    private By startMilestoneButtonLocator = By.id("startMilestoneSubmit");

    private By successStartMilestoneButtonLocator = By.cssSelector("message message-success");



    private By milestoneIsOpeningLocator = By.cssSelector(".content-header-title.page_title.display-inline-block");



    private By acceptDeleteLocator = By.xpath("//*[@id=\"deleteDialog\"]/div[2]/div/div/label/input");





    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return successAddedLocator;
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getName() {
        return driver.findElement(nameLocator);
    }

    public WebElement getReference() {
        return driver.findElement(referenceLocator);
    }

    public WebElement getDescriptionDisplay() {
        return driver.findElement(descriptionDisplayLocator);
    }

    public WebElement getStartDate() {
        return driver.findElement(startDateLocator);
    }

    public WebElement getEndDate() {
        return driver.findElement(endDateLocator);
    }

    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneButtonLocator);
    }

    public WebElement getStartMilestone() {
        return driver.findElement(startMilestoneLocator);
    }

    public WebElement getStartMilestoneButton() {
        return driver.findElement(startMilestoneButtonLocator);
    }

    public WebElement getMilestoneIsOpening() {
        return driver.findElement(milestoneIsOpeningLocator);
    }

    public WebElement getEditButton() {
        return driver.findElement(editButtonLocator);
    }


    public WebElement getAcceptDelete(){
        return driver.findElement(acceptDeleteLocator);
    }

    public WebElement getOkButton(){
        return driver.findElement(okButtonLocator);
    }

    public WebElement getMilestoneName(String milestoneName) {
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace", milestoneName)));
    }


    public WebElement getMilestoneIsOpening(String milestoneName) {
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace", milestoneName)));
    }

    public WebElement getDeleteButton(String milestoneName) {
        return driver.findElement(By.xpath(deleteButtonLocator.replace("Replace",milestoneName)));
    }

    public WebElement getAddMilestones(){
        return  driver.findElement(addMilestonesLocator);
    }

}
