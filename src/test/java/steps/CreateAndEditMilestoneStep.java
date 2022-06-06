package steps;

import baseEntities.BaseStep;
import models.MilestoneBuilder;
import org.openqa.selenium.WebDriver;
import pages.CreateAndEditMilestonePage;

import pages.MilestoneReviewPage;

public class CreateAndEditMilestoneStep extends BaseStep {
    public CreateAndEditMilestoneStep(WebDriver driver) {
        super(driver);
    }
    public CreateAndEditMilestonePage createMilestones(MilestoneBuilder milestone) {
        createAndEditMilestonePage.getName().sendKeys();
        createAndEditMilestonePage.getReference().sendKeys();
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys();
        createAndEditMilestonePage.getStartDate().sendKeys();
        createAndEditMilestonePage.getEndDate().sendKeys();
        createAndEditMilestonePage.getAddMilestoneButton().click();
        return createAndEditMilestonePage;
    }

    public MilestoneReviewPage editMilestone(String editDescription)  {
        milestoneReviewPage.getEditButton().click();
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys(editDescription);
        createAndEditMilestonePage.getAddMilestoneButton().click();
        return milestoneReviewPage;
    }


}
