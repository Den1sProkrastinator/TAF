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

    @Test
    public void correctLogin() {
        open(ReadProperties.getUrl());
        LoginPage loginPage=new LoginPage();
        FeedPage feedPage = new FeedPage();
        loginPage.email.setValue(ReadProperties.email());
        loginPage.psw.setValue(ReadProperties.password());
        loginPage.button.click();
        feedPage.navigationMenu.shouldBe(exist);


    }

    @Test
    public  void inCorrectEmail(){
        open(ReadProperties.getUrl());
        LoginPage loginPage=new LoginPage();
        loginPage.email.setValue("incorrectEmail@gmail.com");
        loginPage.psw.setValue(ReadProperties.password());
        loginPage.button.click();
        loginPage.alertText.shouldHave(text("Your email or password is wrong"));
    }

    @Test
    public  void inCorrectPSW(){
        open(ReadProperties.getUrl());
        LoginPage loginPage=new LoginPage();
        loginPage.email.setValue(ReadProperties.email());
        loginPage.psw.setValue("123456");
        loginPage.button.click();
        loginPage.alertText.shouldHave(text("Your email or password is wrong"));
    }
}
