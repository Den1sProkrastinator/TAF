package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.DashBoardStep;
import steps.LoginStep;

import steps.MilestonesStep;
import steps.ProjectsStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;


    protected ProjectsStep projectsStep;

    protected DashBoardStep dashBoardStep;

    protected MilestonesStep milestonesStep;


    @BeforeMethod
    public void setup() {

        driver = new BrowsersService().getDriver();
        loginStep = new LoginStep(driver);

        projectsStep = new ProjectsStep(driver);
        dashBoardStep = new DashBoardStep(driver);
        milestonesStep = new MilestonesStep(driver);
        driver.get(ReadProperties.getUrl());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
