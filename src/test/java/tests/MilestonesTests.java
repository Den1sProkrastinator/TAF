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
    public void readMilestone()  {
        loginAndOpenMilestoneMenu();

        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");

     Assert.assertTrue(milestoneReviewStep.startMilestone().isPageOpened());
    }


    @Test(priority = 4)
    public void editMilestone()  {
        loginAndOpenMilestoneMenu();

        milestonesStep.readMilestones("Denis");

        Assert.assertTrue(createAndEditMilestoneStep.editMilestone("Admin").isPageOpened());
    }

    @Test(priority = 5)
    public void deleteMilestone()  {
        loginAndOpenMilestoneMenu();

       Assert.assertTrue(milestonesStep.deleteMilestone("Denis").isPageOpened());
    }

    private void loginAndOpenMilestoneMenu() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");

    }


}
