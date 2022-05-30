package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MilestoneReviewPage;

public class MilestoneReviewStep extends BaseStep {
    public MilestoneReviewStep(WebDriver driver) {
        super(driver);
    }

    public MilestoneReviewPage startMilestone() throws InterruptedException {
        milestoneReviewPage.startMilestone.click();
        Thread.sleep(2000);
        milestoneReviewPage.startMilestoneButton.click();
        Thread.sleep(2000);
        return milestoneReviewPage;
    }



}
