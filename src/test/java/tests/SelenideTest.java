package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import configuration.ReadProperties;
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
      Configuration.reportsFolder= "target/screenshoots/";
    }


    @Test
    public void simpleSelenideTest() {
        open(ReadProperties.getUrl());
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        $(".content-header-title.page_title").shouldBe(visible).shouldHave(text("All Projects"));


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

    @Test
    public void simpleSelenideTest1() {
        open("/");
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        $(".page_title").shouldBe(visible).shouldHave(text("All Projects"));

        $$("div.project")
                .filter(visible)
                .shouldBe(size(4))
                .find(text("AUF"))
                .click();


        $$("div.project")
                .first();

        $$("div.project")
                .get(2);



        sleep(2000);
        refresh();//обновляет страницу
        title();
       executeJavaScript("");
    }

    @Test
    public void simpleSelenideTest2() {
        open(ReadProperties.getUrl());
        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();

        System.out.println($(byText("Denis_QA18_PO_HW")).innerText());
        System.out.println( $(byText("Denis_QA18_PO_HW")).getText());
        System.out.println( $(byText("Denis_QA18_PO_HW")).innerHtml());
        System.out.println( $(byText("Denis_QA18_PO_HW")).data(""));
        System.out.println( $(byText("Denis_QA18_PO_HW")).val());
        System.out.println( $(byText("Denis_QA18_PO_HW")).getValue());


        $(byText("Denis_QA18_PO_HW")).scrollTo();
        $(byText("Denis_QA18_PO_HW")).doubleClick();
        $(byText("Denis_QA18_PO_HW")).hover();
        $(byText("Denis_QA18_PO_HW")).find(By.xpath(""));
        $(byText("Denis_QA18_PO_HW")).closest("tr");
        $(byText("Denis_QA18_PO_HW")).ancestor("div");






    }
    @Test
    public void simpleSelenideTest3() {

        open("/");


        $(By.id("name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#button_primary").click();
        open("/index.php?/admin/projects/overview");

        $$(By.className("hoverSensitive"))
                .shouldHave(size(26))
                .find(text("AUF"))
                .find(By.tagName("a"))
                .click();

        $("#announcement")
                .should(exist)
                .shouldBe(visible)
                .shouldHave(exactText("This is the description for the project1"));


        $("#announcement")
                .should(exist).should(hidden).should(disappear).should(not(visible))
                .shouldBe(readonly)
                .shouldHave(name("name"))
                .shouldHave(value("john"))
                .shouldHave(type("checkbox"))
                .shouldBe(empty)
                .shouldBe(focused);


    }
}
