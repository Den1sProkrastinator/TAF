package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MilestoneReviewPage extends BasePage {



    //локаторы
    @FindBy(css =".content-header-title.page_title")
    public WebElement milestoneIsOpening;

    @FindBy(id ="navigation-milestones-start")
    public WebElement startMilestone;

    @FindBy(id ="startMilestoneSubmit" )
    public WebElement startMilestoneButton;

    @FindBy(xpath = "//div/a[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//div[@class='message message-success' and text()='Successfully started the milestone.']")
    public WebElement successStart;

    @FindBy(xpath = "//div[@class='message message-success' and text()='Successfully updated the milestone.']")
    public WebElement successUpdate;


    public MilestoneReviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return milestoneIsOpening;
    }

}
