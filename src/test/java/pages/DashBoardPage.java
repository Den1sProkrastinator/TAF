package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePage {
    private WebDriver driver;
    private final static String pagePath= "/index.php?/dashboard";

    // Блок описания селекторов для элементов
    private By headerLabelLocator = By.className("content-header-title");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerLabelLocator;
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderLabelLocator() {
        return driver.findElement(headerLabelLocator);
    }


}
