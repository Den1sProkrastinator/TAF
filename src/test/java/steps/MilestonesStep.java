package steps;

import baseEntities.BaseStep;
import models.MilestoneBuilder;
import org.openqa.selenium.WebDriver;
import pages.MilestoneReviewPage;
import pages.MilestonesPage;

public class MilestonesStep extends BaseStep {

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public void addMilestones() {
        milestonesPage.getAddMilestones().click();

    }

    public MilestoneReviewPage readMilestones(MilestoneBuilder milestone) {
        milestonesPage.getMilestoneName(milestone.getMilestoneName()).click();
        return milestoneReviewPage;

    }


    public MilestonesPage deleteMilestone(MilestoneBuilder milestone)  {
        milestonesPage.getDeleteButton(milestone.getMilestoneName()).click();
        milestonesPage.getOkButton().click();
        return milestonesPage;
    }


}
