package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CreateAndEditMilestonePage;
import pages.MilestoneReviewPage;

public class CreateAndEditMilestoneStep extends BaseStep {
    public CreateAndEditMilestoneStep(WebDriver driver) {
        super(driver);
    }
    public CreateAndEditMilestonePage createMilestones(String name, String reference, String description, String startDate, String endDate)  {
        createAndEditMilestonePage.name.sendKeys(name);
        createAndEditMilestonePage.reference.sendKeys(reference);
        createAndEditMilestonePage.descriptionDisplay.sendKeys(description);
        createAndEditMilestonePage.startDate.sendKeys(startDate);
        createAndEditMilestonePage.endDate.sendKeys(endDate);
        createAndEditMilestonePage.addMilestoneButton.click();
        return createAndEditMilestonePage;
    }

    public void editMilestone(String editDescription) throws InterruptedException {
        milestoneReviewPage.editButton.click();
        createAndEditMilestonePage.descriptionDisplay.sendKeys(editDescription);
        createAndEditMilestonePage.addMilestoneButton.click();
        Thread.sleep(3000);

    }


}
