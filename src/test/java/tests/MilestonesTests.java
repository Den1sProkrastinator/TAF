package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest {

private void loginAndOpenMilestone(){
    loginStep.successLogin(
            ReadProperties.username(),
            ReadProperties.password());
    dashBoardStep.projectSelection("Denis_QA18_PO_HW");
    projectsStep.menuNavigation("Milestones");
}
    @Test
    public void addMilestones() throws InterruptedException {
        loginAndOpenMilestone();
        projectsStep.addMilestones();
     Assert.assertTrue(milestonesStep.createMilestones
             ("Denis","sss","dasdsa","5/10/2022","5/15/2022").isPageOpened());
    }

    @Test
    public void readMilestone(){
        loginAndOpenMilestone();
milestonesStep.readMilestones("Denis");
    }
    @Test //добавить ожидание !
    public void startMilestone() throws InterruptedException {
        loginAndOpenMilestone();
   milestonesStep.readMilestones("Denis");
   milestonesStep.startMilestone();

    }


//    @Test
//    public void editMilestone(){
//        loginAndOpenMilestone();
//        milestonesStep.readMilestones("Denis");
//    milestonesStep.editMilestone("Admin");
//    }







}
