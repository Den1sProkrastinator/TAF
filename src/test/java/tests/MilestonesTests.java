package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() {
        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                ("Denis", "sss", "dasdsa", "5/10/2022", "5/15/2022").isPageOpened());
    }


    @Test(priority = 2)
    public void readMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        Thread.sleep(2000);
        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(milestoneReviewStep.startMilestone()
                .getSuccessStart().getText(), "Successfully started the milestone.");
    }


    @Test(priority = 4)
    public void editMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        Thread.sleep(200);
        milestonesStep.readMilestones("Denis");
        Thread.sleep(200);
        Assert.assertEquals(createAndEditMilestoneStep.editMilestone("Admin")
                .getSuccessUpdate().getText(), "Successfully updated the milestone.");
    }

    @Test(priority = 5)
    public void deleteMilestone() throws InterruptedException {
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
