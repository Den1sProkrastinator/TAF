package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestoneReviewPage;

public class MilestonesStep extends BaseStep {

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public void addMilestones() {
        milestonesPage.getAddMilestones().click();

    }

    public MilestoneReviewPage readMilestones(String milestoneName) {
        milestonesPage.getMilestoneName(milestoneName).click();
        return milestoneReviewPage;

    }


    public void deleteMilestone(String milestoneName) {

        milestonesPage.getDeleteButton(milestoneName).click();
        milestonesPage.getOkButton().click();
    }


}
