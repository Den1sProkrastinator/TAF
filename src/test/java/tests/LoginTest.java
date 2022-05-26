package tests;

import models.User;
import models.UserBuilder;
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

        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw(ReadProperties.password());

        Assert.assertTrue( loginStep.successLogin(
               user).
                isPageOpened());
    }

    @Test
    public void incorrectEmailLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw("ReadProperties.password()");


        Assert.assertEquals(loginStep.incorrectLogin(user)
                .getErrorTextElement().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
        Assert.assertTrue(false);
    }



    @Test
    public void incorrectPswLoginTest() {
        User user = new User();
        user.setEmail(ReadProperties.username());
        user.setPsw("ReadProperties.password()");

        Assert.assertEquals(loginStep.incorrectLogin(user)
                        .getErrorTextElement().getText(),"Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }

    @Test
    public void successLoginBuilderTest() {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail("sss")
                .withPSW("22222")
                .build();




    }
}
