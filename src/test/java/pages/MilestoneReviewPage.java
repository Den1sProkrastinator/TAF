package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestoneReviewPage extends BasePage {
    public MilestoneReviewPage(WebDriver driver) {
        super(driver);
    }


    //локаторы
    private By milestoneIsOpening = By.cssSelector(".content-header-title.page_title");

    private By startMilestoneLocator = By.id("navigation-milestones-start");

    private By startMilestoneButtonLocator = By.id("startMilestoneSubmit");


    private By editButtonLocator = By.xpath("//div/a[text()='Edit']");

    private By successActionLocator = By.xpath("//div[@class='message message-success']");



    @Override
    protected By getPageIdentifier() {
        return milestoneIsOpening;
    }




    //атомарные методы

    public WebElement getStartMilestone() {
        return waitService.waitForExists(startMilestoneLocator);
    }

    public WebElement getStartMilestoneButton() {
        return waitService.waitForVisibilityLocatedBy(startMilestoneButtonLocator);
    }

    public WebElement getEditButton() {
        return waitService.waitForExists(editButtonLocator);
    }


    public WebElement getSuccessAction() {
        return waitService.waitForExists(successActionLocator);
    }



    //Блок комплексных методов

    public MilestoneReviewPage startMilestone() {
        getStartMilestone().click();
        getStartMilestoneButton().click();
        return this;
    }

    public CreateAndEditMilestonePage editMilestoneButtonClick() {

        getEditButton().click();

        return new CreateAndEditMilestonePage(driver);
    }


}