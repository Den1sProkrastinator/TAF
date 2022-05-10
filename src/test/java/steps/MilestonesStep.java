package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import pages.MilestonesPage;

public class MilestonesStep extends BaseStep {

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage createMilestones(String name, String reference, String description, String startDate, String endDate) {
        milestonesPage.getName().sendKeys(name);
        milestonesPage.getReference().sendKeys(reference);
        milestonesPage.getDescriptionDisplay().sendKeys(description);
        milestonesPage.getStartDate().sendKeys(startDate);
        milestonesPage.getEndDate().sendKeys(endDate);
        milestonesPage.getAddMilestoneButton().click();
        return milestonesPage;
    }

    public void readMilestones(String milestoneName) {
        milestonesPage.getMilestoneName(milestoneName).click();

    }

    public void startMilestone() throws InterruptedException {
        milestonesPage.getStartMilestone().click();
        Thread.sleep(2000);
        milestonesPage.getStartMilestoneButton().click();
    }


    public void editMilestone(String editDescription) {
        milestonesPage.getEditButton().click();

        milestonesPage.getDescriptionDisplay().sendKeys(editDescription);

        milestonesPage.getAddMilestoneButton().click();

    }

    public void deleteMilestone() throws InterruptedException {
        milestonesPage.getEditButton().click();

        milestonesPage.getAddMilestoneButton().click();

        milestonesPage.getDeleteButton().click();
        Thread.sleep(2000);
        milestonesPage.getDeleteButton().click();
        Thread.sleep(2000);
   milestonesPage.getOkButton().click();

    }




}
