package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage  extends BasePage {

    private final static String pagePath = "/upload";

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    private By fileUploadPathLocator = By.id("file-upload");
    private By fileSubmitLocator = By.id("file-submit");

    private By fileUploadedSuccessLocator = By.className("example");

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


    public WebElement getSubmit() {
        return waitsService.waitForExists(fileSubmitLocator);
    }

    public WebElement getFileUploadedSuccess() {
        return waitsService.waitForExists(fileUploadedSuccessLocator);
    }
    public WebElement getFileUpload() {
        return waitsService.waitForExists(fileUploadPathLocator);
    }
}
