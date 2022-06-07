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
        createAndEditMilestonePage.getName().sendKeys(milestone.getName());
        createAndEditMilestonePage.getReference().sendKeys(milestone.getReference());
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys(milestone.getDescription());
        createAndEditMilestonePage.getStartDate().sendKeys(milestone.getStartDate());
        createAndEditMilestonePage.getEndDate().sendKeys(milestone.getEndDate());
        createAndEditMilestonePage.getAddMilestoneButton().click();
        return createAndEditMilestonePage;
    }

    public MilestoneReviewPage editMilestone(MilestoneBuilder milestone)  {
        milestoneReviewPage.getEditButton().click();
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys(milestone.getDescription());
        createAndEditMilestonePage.getAddMilestoneButton().click();
        return milestoneReviewPage;
    }


}
