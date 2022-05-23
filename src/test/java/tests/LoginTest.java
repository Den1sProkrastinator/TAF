package tests;

import org.testng.Assert;
import pages.DashboardPage;
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
                isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(loginStep.incorrectLogin("sfaf",ReadProperties.password())
                .getErrorTextElement().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }



    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(loginStep.incorrectLogin(ReadProperties.username(),"233")
                        .getErrorTextElement().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");

    }
}
