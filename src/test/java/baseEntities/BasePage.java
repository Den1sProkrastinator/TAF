package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import services.WaitsService;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;

    protected WaitsService waitsService;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService=new WaitsService(driver, Duration.ofSeconds(ReadProperties.timeout()));

    }

    protected abstract By getPageIdentifier();

    protected  abstract By getInvisibleElementIdentifier();

    protected abstract   By getVisibleElementIdentifier();


    public boolean isPageOpened() {
        return waitsService.waitForExists(getPageIdentifier()).isDisplayed();
    }

    public boolean checkedElementIsVisible(){
        return waitsService.waitForExists(getVisibleElementIdentifier()).isDisplayed();
    }
    public boolean checkedElementIsInvisible(){
        return waitsService.waitForExists(getInvisibleElementIdentifier()).isEnabled();
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
