package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CreateAndEditMilestonePage extends BasePage {
    public CreateAndEditMilestonePage(WebDriver driver) {
        super(driver);
    }
    //локаторы

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="reference")
    public WebElement reference;

    @FindBy(id="description_display")
    public WebElement descriptionDisplay;

    @FindBy(id="start_on")
    public WebElement startDate;

    @FindBy(id="due_on")
    public WebElement endDate;

    @FindBy(id="accept")
    public WebElement addMilestoneButton;


    //локатор проверки
    @FindBy(xpath = "//div[@class='message message-success' and text()='Successfully added the new milestone.']")
   public By successStartMilestoneButton;

    @Override
    protected WebElement getPageIdentifier() {
        return  driver.findElement(successStartMilestoneButton);
    }



}
