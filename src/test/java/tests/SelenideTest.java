package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
//        Configuration.browser="Opera";
        Configuration.browserSize = "1980x1024";
//        Configuration.assertionMode= AssertionMode.SOFT;  //rezim testirovanij
//        Configuration.clickViaJs=true;
//        Configuration.headless=true;   //браузер мод(включить выключить )
        Configuration.reportsFolder = "target/screenshoots/";


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(false)
//                .savePageSource(true)
//        );
    }




    @Test
    public void poSelenideTest() {

        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();
        loginPage.userName.setValue(ReadProperties.username());
        loginPage.psw.setValue(ReadProperties.password());
        loginPage.button.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All projects"));


    }


}
