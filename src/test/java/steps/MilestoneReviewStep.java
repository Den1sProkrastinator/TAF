package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MilestoneReviewPage;

public class MilestoneReviewStep extends BaseStep {
    public MilestoneReviewStep(WebDriver driver) {
        super(driver);
    }

    public MilestoneReviewPage startMilestone()  {
        milestoneReviewPage.getStartMilestone().click();

        milestoneReviewPage.getStartMilestoneButton().click();

        return milestoneReviewPage;
    }



}
