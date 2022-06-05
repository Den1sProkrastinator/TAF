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
    public void checkBoxTest() throws Exception {

        loginAndOpenMilestoneMenu();
        new MilestoneReviewPage(driver)
                .editMilestoneButtonClick();

        CheckBox  checkBox = new CheckBox(driver, By.id("show_announcement"));

        checkBox.clickByIndex(0);
        Thread.sleep(2000);

        checkBox.clickByValue("1");
        Thread.sleep(2000);


    }


 @Test
    public void checkBoxTest1() throws Exception {

       driver.get("http://the-internet.herokuapp.com/checkboxes");



        CheckBox  checkBox = new CheckBox(driver, By.xpath("//input[@type='checkbox']"));

        checkBox.clickByIndex(0);
        Thread.sleep(2000);



    }

    private void loginAndOpenMilestoneMenu() {

        new LoginPage(driver)

                .successLogin(ReadProperties.username(), ReadProperties.password())
                .projectSelection("AUF");


    }


}

