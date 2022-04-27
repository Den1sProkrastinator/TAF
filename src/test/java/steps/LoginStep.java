package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public DashBoardPage successLogin(String email, String psw) {
        login(email, psw);
        return dashBoardPage;
    }

    public LoginPage inCorrectLogin(String email, String psw) {
        login(email, psw);
        return loginPage;
    }

    private void login(String email, String psw)

    {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage logout(String email, String psw) {

        return loginPage;

    }


}
