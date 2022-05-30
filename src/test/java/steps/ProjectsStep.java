package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.MilestonesPage;

public class ProjectsStep extends BaseStep {


    public ProjectsStep(WebDriver driver) {
        super(driver);
    }

    public void menuNavigation(String menuName) {
        projectsPage.getMenuByName(menuName).click();

    }

    public void addMilestones() {
        projectsPage.getAddMilestones().click();

    }


}
