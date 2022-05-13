package pages;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {


    // локаторы навигации во вкладке milestone
    private String milestonesNameLocator = "//div/a[.='Replace']";


    private String deleteButtonLocator =
            "//div/div/a[@href and text()='Replace']/following::a[@class='deleteLink'][1]";
    private By okButtonLocator = By.xpath("//*[@id=\"deleteDialog\"]/div[3]/a[1]");

    private By successAddedLocator = By.xpath("//div[text()='Successfully added the new milestone.']");

    private By addMilestonesLocator = By.id("navigation-milestones-add");




    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return successAddedLocator;
    }





    public WebElement getOkButton() {
        return driver.findElement(okButtonLocator);
    }

    public WebElement getMilestoneName(String milestoneName) {
        return driver.findElement(By.xpath(milestonesNameLocator.replace("Replace", milestoneName)));
    }


    public WebElement getDeleteButton(String milestoneName) {
        return driver.findElement(By.xpath(deleteButtonLocator.replace("Replace", milestoneName)));
    }

    public WebElement getAddMilestones() {
        return driver.findElement(addMilestonesLocator);
    }



    //классы для проверки
    public static class CheckDeleteMilestone extends BasePage {
        private By successDeleteLocator = By.xpath(
                "//div[@class='message message-success']");
        public CheckDeleteMilestone(WebDriver driver) {
            super(driver);
        }

        @Override
        protected By getPageIdentifier() {
            return successDeleteLocator;
        }
    }
}
