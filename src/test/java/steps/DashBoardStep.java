package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.ProjectsPage;

public class DashBoardStep extends BaseStep {
    public DashBoardStep(WebDriver driver) {
        super(driver);
    }

    public void projectSelection(String projectName) {
        dashboardPage.getProjectByName(projectName).click();
    }


}
