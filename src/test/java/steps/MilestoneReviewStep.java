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
        milestoneReviewPage.getStartMilestone().click();
        Thread.sleep(2000);
        milestoneReviewPage.getStartMilestoneButton().click();
        Thread.sleep(2000);
        return checkStartMilestone;
    }



}