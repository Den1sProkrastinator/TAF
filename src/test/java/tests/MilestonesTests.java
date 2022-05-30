package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;

import org.testng.Assert;
import org.testng.annotations.Test;



public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones()  {
        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertEquals(createAndEditMilestoneStep.createMilestones
                ("Denis", "reference", "your description", "6/10/2022", "6/15/2022")
                .successStartMilestone.getText(),"Successfully added the new milestone.");
    }


    @Test(priority = 2)
    public void readMilestone() {
        loginAndOpenMilestoneMenu();

        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");
        Assert.assertEquals(milestoneReviewStep.startMilestone()
                .successStart.getText(),"Successfully started the milestone.");

    }


    @Test(priority = 4)
    public void editMilestone()  {
        loginAndOpenMilestoneMenu();

        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(createAndEditMilestoneStep.editMilestone("Admin")
                .successUpdate.getText(),"Successfully updated the milestone.");
    }

    @Test(priority = 5)
    public void deleteMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();


       Assert.assertEquals(milestonesStep.deleteMilestone("Denis").successDelete.getText(),"Successfully deleted the milestone (s).");
    }




    //метод для логина
    private void loginAndOpenMilestoneMenu() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");

    }


}
