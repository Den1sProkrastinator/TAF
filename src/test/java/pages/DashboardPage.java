package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {


    // Блок описания селекторов для элементов

    @FindBy(xpath = "//div[contains(@class, 'content-header-title') and contains(text(), 'Dashboard')]")
    public WebElement headerTitleLabel;
    private String projectNameLocator="//div/a[@style and text()='Replace']";

    public DashboardPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected WebElement getPageIdentifier() {
        return headerTitleLabel;
    }




    // Блок атомарных методов

    public WebElement getProjectByName(String projectName){
        return driver.findElement(By.xpath(projectNameLocator.replace("Replace",projectName)));
    }



}
