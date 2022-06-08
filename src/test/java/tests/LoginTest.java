package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();

        Configuration.browserSize = "1980x1024";
        Configuration.reportsFolder = "target/screenshoots/";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @Test(description = "success login")
    public void successLogin() {

      new LoginPage().successLogin(ReadProperties.email(),ReadProperties.password())
              .getNavigationMenu()
              .shouldBe(exist);


    }

    @Test(description = "enter incorrect emil")
    public  void inCorrectEmail(){

        new LoginPage().inCorrectLogin("ssssss",ReadProperties.password())
                .getIncorrectEmail()
                .shouldHave(text("Invalid email address"));
    }

    @Test(description = "enter incorrect password")
    public  void inCorrectPSW(){

        new LoginPage().inCorrectLogin(ReadProperties.email(),"ssssss")
                .getIncorrectPSW()
                .shouldHave(text("Your email or password is wrong"));
    }


}
