package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DynamicControlsPage;

public class DynamicControlsStep extends BaseStep {
    public DynamicControlsStep(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        dynamicControlsPage.openPageByUrl();
    }

    public DynamicControlsPage removeDynamicControls()  {

        actions
                .moveToElement(dynamicControlsPage.getCheckbox())
                .click()
                .build()
                .perform();



        actions
                .moveToElement(dynamicControlsPage.getSwapCheckboxSpot())
                .click()
                .build()
                .perform();

        return dynamicControlsPage;
    }


    public void enableDisableClick() {


        actions
                .moveToElement(dynamicControlsPage.getSwapInputSpot())
                .click()
                .build()
                .perform();
    }


    public boolean elementStatusIsDisabled() {
        return dynamicControlsPage.getTextLocator().getAttribute("disabled") != null;
    }

    public boolean elementStatusIsEnabled() {
        return dynamicControlsPage.getTextLocator().getAttribute("disabled") == null;
    }


    public WebElement getMessageElement() {
        return dynamicControlsPage.getMessageSpot();
    }


}


