package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MilestonesPage;

public class MilestonesStep extends BaseStep {

    public MilestonesStep(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage createMilestones(String name, String reference, String description, String startDate, String endDate) {
        milestonesPage.getName().sendKeys(name);
        milestonesPage.getReference().sendKeys(reference);
        milestonesPage.getDescriptionDisplay().sendKeys(description);

        //добавить дату через клик
        milestonesPage.getStartDate().sendKeys(startDate);


        //добваить дату через клик
        milestonesPage.getEndDate().sendKeys(endDate);

        milestonesPage.getAddMilestoneButton().click();

        return milestonesPage;
    }



}
