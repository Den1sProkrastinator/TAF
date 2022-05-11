package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CreateAndEditMilestonePage;

public class CreateAndEditMilestoneStep extends BaseStep {
    public CreateAndEditMilestoneStep(WebDriver driver) {
        super(driver);
    }
    public CreateAndEditMilestonePage createMilestones(String name, String reference, String description, String startDate, String endDate) {
        createAndEditMilestonePage.getName().sendKeys(name);
        createAndEditMilestonePage.getReference().sendKeys(reference);
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys(description);
        createAndEditMilestonePage.getStartDate().sendKeys(startDate);
        createAndEditMilestonePage.getEndDate().sendKeys(endDate);
        createAndEditMilestonePage.getAddMilestoneButton().click();
        return createAndEditMilestonePage;
    }

    public void editMilestone(String editDescription) {
        milestoneReviewPage.getEditButton().click();
        createAndEditMilestonePage.getDescriptionDisplay().sendKeys(editDescription);
        createAndEditMilestonePage.getAddMilestoneButton().click();
    }


}
