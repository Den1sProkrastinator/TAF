package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitService;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitService waitService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitService = new WaitService(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    protected abstract By getPageIdentifier();


    public boolean isPageOpened() {
        return waitService.waitForExist(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }

}
