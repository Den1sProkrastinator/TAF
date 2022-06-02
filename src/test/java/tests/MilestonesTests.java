package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.MilestoneBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MilestonesTests extends BaseTest {


    @Epic("Milestone test")
    @Feature("CRUD Milestone")

    @Step("Milestone name  - Denis ")
    @Test(priority = 1 , description = "Add new Milestone")
    public void addMilestones() throws IOException {
        MilestoneBuilder milestone = new MilestoneBuilder.Builder()
                .withName("Denis")
                .withReference("reference")
                .withDescription("description")
                .withStartDate("6/11/2022")
                .withEndDate("6/15/2022")
                .build();

        loginAndOpenMilestoneMenu();
        milestonesStep.addMilestones();
        Assert.assertTrue(createAndEditMilestoneStep.createMilestones
                (milestone).isPageOpened());
        getBytes("strelkov.jpeg");
    }

    @Step("Milestone your are reading ")
    @Test(priority = 2 , description = "Read milestone")
    public void readMilestone() {

        loginAndOpenMilestoneMenu();
        Assert.assertTrue(milestonesStep.readMilestones("Denis").isPageOpened());

    }
    @Step("Milestone your are starting ")
    @Test(priority = 3, description = "Start milestone")
    public void startMilestone() {
        loginAndOpenMilestoneMenu();
        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(milestoneReviewStep.startMilestone()
                .getSuccessAction().getText(), "Successfully started the milestone.");
    }

    @Step("milestone to be removed ")
    @Test(priority = 4, description = "Edit milestone")
    public void editMilestone() {
        loginAndOpenMilestoneMenu();

        milestonesStep.readMilestones("Denis");

        Assert.assertEquals(createAndEditMilestoneStep.editMilestone("Admin")
                .getSuccessAction().getText(), "Successfully updated the milestone.");
    }

    @Test(priority = 5, description = "Delete milestone")
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

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources", resourceName));
    }


}
