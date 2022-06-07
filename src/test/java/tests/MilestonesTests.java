package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.MilestoneBuilder;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .name("Denis")
                .reference("reference")
                .description("description")
                .startDate("6/15/2022")
                .endDate("6/16/2022")
                .build();

        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                (milestone).isPageOpened());
    }


    @Test(priority = 2)
    public void readMilestone() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .milestoneName("Denis")
                .build();

        loginAndOpenMilestoneMenu();

        Assert.assertTrue(milestonesStep.readMilestones(milestone).isPageOpened());

    }

    @Test(priority = 3)
    public void startMilestone() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .milestoneName("Denis")
                .build();

        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones(milestone);

        Assert.assertEquals(milestoneReviewStep.startMilestone()
                .getSuccessAction().getText(), "Successfully started the milestone.");
    }


    @Test(priority = 4)
    public void editMilestone() {

        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .description("Description")
                .milestoneName("Denis")
                .build();
        loginAndOpenMilestoneMenu();

        milestonesStep.readMilestones(milestone);

        Assert.assertEquals(createAndEditMilestoneStep.editMilestone(milestone)
                .getSuccessAction().getText(), "Successfully updated the milestone.");
    }

    @Test(priority = 5)
    public void deleteMilestone() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .milestoneName("Denis")
                .build();
        loginAndOpenMilestoneMenu();

        Assert.assertEquals(milestonesStep.deleteMilestone(milestone)
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
