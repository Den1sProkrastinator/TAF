package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.Milestone;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() {
        Milestone milestone = new Milestone();
        milestone.setName("Denis");
        milestone.setReference("reference");
        milestone.setDescription("description");
        milestone.setStartDate("6/10/2022");
        milestone.setEndDate("6/15/2022");
        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                (milestone).isPageOpened());
    }


    @Test(priority = 2)
    public void readMilestone()  {

        loginAndOpenMilestoneMenu();
        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone()  {
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
    public void deleteMilestone()  {
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
