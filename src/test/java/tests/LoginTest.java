package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import steps.LoginStep;
import sun.awt.windows.ThemeReader;
import wrappers.RadioButton;
import wrappers.Table;

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


    @Test
    public void radioButtonTest() throws Exception {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        Thread.sleep(2000);
        driver.get("https://denisthebestqaintheworld.testrail.io/index.php?/admin/projects/add");
        Thread.sleep(2000);
        RadioButton suiteMode = new RadioButton(driver, By.name("suite_mode"));
        suiteMode.select("2");

        Thread.sleep(2000);
    }

    @Test
    public void tableTest() throws Exception {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        driver.get("https://denisthebestqaintheworld.testrail.io/index.php?/admin/projects/overview");
        Table table = new Table(driver,By.cssSelector("table.grid"));
        System.out.println(table.getColumnIndex("Project"));

        Thread.sleep(2000);
    }

}
