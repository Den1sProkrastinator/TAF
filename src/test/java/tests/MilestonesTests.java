package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest {



    @Test
    public void addMilestones()  {
        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                ("Denis", "sss", "dasdsa", "5/10/2022", "5/15/2022").isPageOpened());
    }


    @Test
    public void readMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        Thread.sleep(2000);
     Assert.assertTrue( milestonesStep.readMilestones("Denis").isPageOpened());

    }

    @Test
    public void startMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");
        milestoneReviewStep.startMilestone();

    }


    @Test
    public void editMilestone() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        Thread.sleep(2000);
        milestonesStep.readMilestones("Denis");
        Thread.sleep(2000);

        createAndEditMilestoneStep.editMilestone("Admin");


    }
//    @Test
//    public void deleteMilestone()  {
//        loginAndOpenMilestoneMenu();
//   milestonesStep.deleteMilestone("Denis");
//
//    }

    private void loginAndOpenMilestoneMenu() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");
    }





}
