package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {


    // локаторы
    private String milestonesNameLocator = "//div/a[.='Replace']";

    private String deleteButtonLocator = "//div/div/a[@href and text()='Replace']/following::a[@class='deleteLink'][1]";
    private By okButtonLocator = By.xpath("//*[@id=\"deleteDialog\"]/div[3]/a[1]");

    private By successAddedLocator = By.xpath("//div[text()='Successfully added the new milestone.']");

    private By addMilestonesLocator = By.id("navigation-milestones-add");

    private By successDeleteLocator = By.xpath("//div[@class='message message-success']");


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }


    //блок атомарных методов
    @Override
    protected By getPageIdentifier() {
        return successAddedLocator;
    }


    public WebElement getOkButton() {
        return waitService.waitForExists(okButtonLocator);
    }

    public WebElement getMilestoneName(String milestoneName) {
        return waitService.waitForExists(By.xpath(milestonesNameLocator.replace("Replace", milestoneName)));
    }

    public WebElement getDeleteButton(String milestoneName) {
        return waitService.waitForExists(By.xpath(deleteButtonLocator.replace("Replace", milestoneName)));
    }

    public WebElement getAddMilestones() {
        return waitService.waitForExists(addMilestonesLocator);
    }

    public WebElement getSuccessDeleteMilestone() {
        return waitService.waitForExists(successDeleteLocator);
    }



    // блок комплексных методов
    public MilestoneReviewPage readMilestones(String milestoneName) {
        getMilestoneName(milestoneName).click();
        return new MilestoneReviewPage(driver);
    }

    public CreateAndEditMilestonePage addMilestones() {
      getAddMilestones().click();
      return new CreateAndEditMilestonePage(driver);
    }

    public MilestonesPage deleteMilestone(String milestoneName)  {
        getDeleteButton(milestoneName).click();
        getOkButton().click();
        return this;
    }


}
