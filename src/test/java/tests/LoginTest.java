package tests;

import org.testng.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import steps.LoginStep;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() {

        Assert.assertTrue( loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()).
                isPageOped());
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(loginStep.inCorrectLogin("sfaf",ReadProperties.password())
                .getErrorTextLocator().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }



    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(loginStep.inCorrectLogin(ReadProperties.username(),"233")
                        .getErrorTextLocator().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
