package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

       public void readMilestones (String milestoneName){
        milestonesPage.getMilestoneName(milestoneName).click();

       }

       public void startMilestone () throws InterruptedException {
        milestonesPage.getStartMilestone().click();
      Thread.sleep(2000);
        milestonesPage.getStartMilestoneButton().click();
       }


//       public void editMilestone(String parent){
//        milestonesPage.getEditMilestoneButton().click();
//
//
//       }







}
