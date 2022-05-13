package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;
//import pages.MilestonesPage;


public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;

    protected CreateAndEditMilestonePage createAndEditMilestonePage;

    protected MilestoneReviewPage milestoneReviewPage;

    //лассы для проверок
    protected MilestoneReviewPage.CheckStartMilestone checkStartMilestone;
    protected MilestonesPage.CheckDeleteMilestone checkDeleteMilestone;

    protected MilestoneReviewPage.CheckSuccessUpdate checkSuccessUpdate;



    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        createAndEditMilestonePage = new CreateAndEditMilestonePage(driver);
        milestoneReviewPage = new MilestoneReviewPage(driver);
        checkStartMilestone=new MilestoneReviewPage.CheckStartMilestone(driver);
        checkDeleteMilestone = new MilestonesPage.CheckDeleteMilestone(driver);
        checkSuccessUpdate=new MilestoneReviewPage.CheckSuccessUpdate(driver);



    }
}
