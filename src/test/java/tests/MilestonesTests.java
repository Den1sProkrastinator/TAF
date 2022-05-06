package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest {


    @Test
    public void addMilestones() throws InterruptedException {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        projectsStep.menuNavigation("Milestones");
        Thread.sleep(2000);
        Assert.assertTrue(projectsStep.addMilestones().isPageOpened());

    }



}
