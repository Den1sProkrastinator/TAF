package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MilestoneReviewPage;
import wrappers.CheckBox;

public class CheckBoxTest extends BaseTest {
    @Test
    public void checkBoxTest() throws InterruptedException {

        loginAndOpenMilestoneMenu();
        new MilestoneReviewPage(driver)
                .editMilestoneButtonClick();

        CheckBox  checkBox = new CheckBox(driver, By.id("show_announcement"));

        checkBox.click();



    }

    private void loginAndOpenMilestoneMenu() {

        new LoginPage(driver)

                .successLogin(ReadProperties.username(), ReadProperties.password())
                .projectSelection("AUF");


    }


}

