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


    @Override
    protected By getPageIdentifier() {
        return milestoneIsOpening;
    }

    //атомарные методы

    public WebElement getStartMilestone() {
        return driver.findElement(startMilestoneLocator);
    }

    public WebElement getStartMilestoneButton() {
        return driver.findElement(startMilestoneButtonLocator);
    }

    public WebElement getEditButton() {
        return driver.findElement(editButtonLocator);
    }


    //классы проверок

    public static class CheckStartMilestone extends BasePage {
        public CheckStartMilestone(WebDriver driver) {
            super(driver);
        }

        private By successStartLocator = By.xpath(
                "//div[@class='message message-success' and text()='Successfully started the milestone.']");

        @Override
        protected By getPageIdentifier() {
            return successStartLocator;
        }
    }


    public static class CheckSuccessUpdate extends BasePage {

        private By successUpdateLocator = By.xpath(
                "//div[@class='message message-success' and text()='Successfully updated the milestone.']");

        public CheckSuccessUpdate(WebDriver driver) {
            super(driver);
        }

        @Override
        protected By getPageIdentifier() {
            return successUpdateLocator;
        }
    }
}
