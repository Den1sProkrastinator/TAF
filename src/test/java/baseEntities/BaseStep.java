package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashBoardPage dashBoardPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);

    }


}
