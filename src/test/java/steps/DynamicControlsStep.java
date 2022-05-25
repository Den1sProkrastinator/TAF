package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DynamicControlsPage;

public class DynamicControlsStep extends BaseStep {
    public DynamicControlsStep(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        dynamicControlsPage.openPageByUrl();
    }
    public DynamicControlsPage removeDynamicControls() throws InterruptedException {


        actions
                .moveToElement(dynamicControlsPage.getCheckboxSpot())
                .click()
                .build()
                .perform();

        Thread.sleep(2000);

        actions
                .moveToElement(dynamicControlsPage.getSwapCheckboxSpot())
                .click()
                .build()
                .perform();
        Thread.sleep(2000);
        return dynamicControlsPage;
    }



    public  void enableDisableClick(){


        actions
                .moveToElement(dynamicControlsPage.getSwapInputSpot())
                .click()
                .build()
                .perform();
    }

    public DynamicControlsPage getCheckboxr(){
        return dynamicControlsPage;
    }

    public DynamicControlsPage getTexWebelement(){
        return dynamicControlsPage;
    }

    public boolean elementStatusIsDisabled(){
       return   dynamicControlsPage.getTextLocator().getAttribute("disabled") != null;
    }
      public boolean elementStatusIsEnabled(){
       return   dynamicControlsPage.getTextLocator().getAttribute("disabled") == null;
    }

}
