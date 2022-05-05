package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTests extends BaseTest {
    @Test

    public void successProjectSelection(){
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password());
        dashBoardStep.projectSelection("Denis_QA18_PO_HW");
        Assert.assertTrue(dashBoardStep.successSelectionProject().isPageOpened());
    }

}
