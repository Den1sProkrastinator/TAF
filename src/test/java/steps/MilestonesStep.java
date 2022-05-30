package steps;

import baseEntities.BaseStep;
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

    public MilestoneReviewPage readMilestones(String milestoneName) {
        milestonesPage.getMilestoneName(milestoneName).click();
        return milestoneReviewPage;

    }


    public MilestonesPage deleteMilestone(String milestoneName) throws InterruptedException {

        milestonesPage.getDeleteButton(milestoneName).click();
        milestonesPage.getOkButton().click();
        Thread.sleep(2000);
        return milestonesPage;
    }


}
