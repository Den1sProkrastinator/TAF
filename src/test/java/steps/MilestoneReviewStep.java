package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MilestoneReviewPage;

public class MilestoneReviewStep extends BaseStep {
    public MilestoneReviewStep(WebDriver driver) {
        super(driver);
    }

    public MilestoneReviewPage.CheckStartMilestone startMilestone() throws InterruptedException {
        Thread.sleep(3000);
        milestoneReviewPage.getStartMilestone().click();
        Thread.sleep(3000);
        milestoneReviewPage.getStartMilestoneButton().click();

        return checkStartMilestone;
    }



}
