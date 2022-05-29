package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() throws InterruptedException {
        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertEquals(createAndEditMilestoneStep.createMilestones
                ("Denis", "reference", "your description", "6/10/2022", "6/15/2022")
                .successStartMilestone.getText(),"Successfully added the new milestone.");
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
     Assert.assertTrue(milestoneReviewStep.startMilestone().isDisplayed());
    }


//    @Test(priority = 4)
//    public void editMilestone() throws InterruptedException {
//        loginAndOpenMilestoneMenu();
//        Thread.sleep(200);
//        milestonesStep.readMilestones("Denis");
//        Thread.sleep(200);
////        Assert.assertTrue(createAndEditMilestoneStep.editMilestone("Admin").isPageOpened());
//    }
//
//    @Test(priority = 5)
//    public void deleteMilestone() throws InterruptedException {
//        loginAndOpenMilestoneMenu();
//
////       Assert.assertTrue(milestonesStep.deleteMilestone("Denis").isPageOpened());
//    }

    private void loginAndOpenMilestoneMenu() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");

    }


}
