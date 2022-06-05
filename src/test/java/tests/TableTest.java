package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MilestoneReviewPage;
import wrappers.DropDown;
import wrappers.Table;

public class TableTest extends BaseTest {


//    @Test
//    public void tableTest() throws Exception {
//        loginAndOpenMilestoneMenu();
//
//         driver.get("https://denisthebestqaintheworld.testrail.io/index.php?/admin/projects/overview");
//
//
//        Table table = new Table(driver,By.className("grid"));
//
//       table.getRow("AUF");
//       table.getCellByText("AUF","icon-small-delete").click();
//       Thread.sleep(2000);
   // }

    private void loginAndOpenMilestoneMenu() {

        new LoginPage(driver)

                .successLogin(ReadProperties.username(), ReadProperties.password())
                .projectSelection("AUF");


    }

}
