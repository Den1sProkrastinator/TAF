package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MilestoneReviewPage;
import wrappers.DropDown;

public class DropDownTest extends BaseTest {


    @Test
    public void dropDownTest() throws Exception {
    loginAndOpenMilestoneMenu();
        new MilestoneReviewPage(driver)
                .editMilestoneButtonClick();

        WebElement dropDownMenuElement= driver.findElement(By.id("navigation-menu")) ;

        dropDownMenuElement.click();


        DropDown dropDown= new DropDown(driver,By.className("dropdown-menu-link"));

        dropDown.select("TestRail User Guide");
        Thread.sleep(2000);




}

    private void loginAndOpenMilestoneMenu() {

        new LoginPage(driver)

                .successLogin(ReadProperties.username(), ReadProperties.password())
                .projectSelection("AUF");


    }
}