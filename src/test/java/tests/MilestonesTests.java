package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.MilestoneBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() {
        MilestoneBuilder milestone = new MilestoneBuilder.Builder()
                .withName("Denis")
                .withReference("reference")
                .withDescription("desctiption")
                .withStartDate("6/11/2022")
                .withEndDate("/615/2022")
                .build();

        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                (milestone).isPageOpened());
    }


    @Test(priority = 2)
    public void readMilestone() {

        loginAndOpenMilestoneMenu();
        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone() {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(milestoneReviewStep.startMilestone()
                .getSuccessAction().getText(), "Successfully started the milestone.");
    }


    @Test(priority = 4)
    public void editMilestone() {
        loginAndOpenMilestoneMenu();

        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(createAndEditMilestoneStep.editMilestone("Admin")
                .getSuccessAction().getText(), "Successfully updated the milestone.");
    }

    @Test(priority = 5)
    public void deleteMilestone() {
        loginAndOpenMilestoneMenu();

        Assert.assertEquals(milestonesStep.deleteMilestone("Denis")
                .getSuccessDeleteMilestone().getText(), "Successfully deleted the milestone (s).");
    }

    private void loginAndOpenMilestoneMenu() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");

    }


}
