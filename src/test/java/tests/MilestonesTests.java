package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAndEditMilestonePage;
import pages.LoginPage;
import pages.MilestonesPage;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class MilestonesTests extends BaseTest {


    @Test(priority = 1)
    public void addMilestones() {

        loginAndOpenMilestoneMenu();

        Assert.assertTrue(new MilestonesPage(driver)
                .addMilestones()
                .createMilestones("Denis", "reference"
                        , "description", "6/10/2022"
                        , "6/15/2022")
                .isPageOpened());
    }


    @Test(priority = 2)
    public void readMilestone() {

        loginAndOpenMilestoneMenu();

        Assert.assertTrue(new MilestonesPage(driver)
                .readMilestones("Denis")
                .isPageOpened());
    }

    @Test(priority = 3)
    public void startMilestone() {
        loginAndOpenMilestoneMenu();

        Assert.assertEquals(
                new MilestonesPage(driver)
                        .readMilestones("Denis")
                        .startMilestone()
                        .getSuccessAction()
                        .getText(), "Successfully started the milestone.");
    }


    @Test(priority = 4)
    public void editMilestone() {

        loginAndOpenMilestoneMenu();

        Assert.assertEquals(
                new MilestonesPage(driver)
                        .readMilestones("Denis")
                        .editMilestoneButtonClick()
                        .editMilestone("Edit text")
                        .getSuccessAction().getText(), "Successfully updated the milestone.");
    }

    @Test(priority = 5)
    public void deleteMilestone() {

        loginAndOpenMilestoneMenu();

        Assert.assertEquals(
                new MilestonesPage(driver)
                        .deleteMilestone("Denis")
                        .getSuccessDeleteMilestone()
                        .getText(), "Successfully deleted the milestone (s).");
    }

    private void loginAndOpenMilestoneMenu() {

        new LoginPage(driver)

                .successLogin(ReadProperties.username(), ReadProperties.password())
                .projectSelection("Denis_QA18_PO_HW")
                .menuNavigation("Milestones");

    }


}
