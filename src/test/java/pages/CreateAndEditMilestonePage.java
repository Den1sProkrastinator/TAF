package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAndEditMilestonePage extends BasePage {
    public CreateAndEditMilestonePage(WebDriver driver) {
        super(driver);
    }

    //локаторы
    private By nameLocator = By.id("name");
    private By referenceLocator = By.id("reference");
    private By descriptionDisplayLocator = By.id("description_display");
    private By startDateLocator = By.id("start_on");
    private By endDateLocator = By.id("due_on");
    private By addMilestoneButtonLocator = By.id("accept");


    //локатор проверки
    private By successStartMilestoneButtonLocator = By.xpath(
            "//div[@class='message message-success' and text()='Successfully added the new milestone.']");

    @Override
    protected By getPageIdentifier() {
        return successStartMilestoneButtonLocator;
    }

    //атомарные методы
    public WebElement getName() {
        return waitService.waitForExists(nameLocator);
    }

    public WebElement getReference() {
        return waitService.waitForExists(referenceLocator);
    }

    public WebElement getDescriptionDisplay() {
        return waitService.waitForExists(descriptionDisplayLocator);
    }

    public WebElement getStartDate() {
        return waitService.waitForExists(startDateLocator);
    }

    public WebElement getEndDate() {
        return waitService.waitForExists(endDateLocator);
    }

    public WebElement getAddMilestoneButton() {
        return waitService.waitForExists(addMilestoneButtonLocator);
    }

    //Блок комплексных методов

    public CreateAndEditMilestonePage createMilestones(String name, String reference, String description, String startDate, String endDate) {
        getName().sendKeys(name);
        getReference().sendKeys(reference);
        getDescriptionDisplay().sendKeys(description);
        getStartDate().sendKeys(startDate);
        getEndDate().sendKeys(endDate);
        getAddMilestoneButton().click();
        return this;
    }



    public MilestoneReviewPage editMilestone(String editDescription)  {

        getDescriptionDisplay().sendKeys(editDescription);
       getAddMilestoneButton().click();

        return  new MilestoneReviewPage(driver);
    }


}
