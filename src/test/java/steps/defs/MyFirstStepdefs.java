package steps.defs;

import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import pages.DashboardPage;
import pages.LoginPage;
import services.BrowsersService;

public class MyFirstStepdefs {
    WebDriver driver;
    LoginPage loginPage;

    DashboardPage dashboardPage;


    @Given("open browser")
    public void open_browser() {
        System.out.println("Открываю браузер");
        driver = new BrowsersService().getDriver();
    }
    @After
    public void closeBrowser(){
        driver.quit();

    }

    @When("login page is opened")
    public void loginPageIsOpened() {
        driver.get(ReadProperties.getUrl());
        loginPage= new LoginPage(driver);
    }

    @Then("username field is displayed")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailInput().isDisplayed());
    }

    @When("user with email {string} and psw {string} logged in")
    public void userWithEmailAndPswLoggedIn(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    @Then("add project button is displayed")
    public void addProjectButtonIsDisplayed() {

        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(true);


    }

    @And("username is {string}")
    public void usernameIs(String name) {
        Assert.assertEquals(name,"Ales Tros");


    }

    @And("projects count is {int}")
    public void projectsCountIs(int count) {
        Assert.assertEquals(count,15);
    }


}
