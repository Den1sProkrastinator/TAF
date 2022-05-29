package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadStep extends BaseStep {

    public void openPage() {
        fileUploadPage.openPageByUrl();
    }

    public FileUploadStep(WebDriver driver) {
        super(driver);
    }


    public void fileUpload() {

        openPage();

        fileUploadPage.getFileUpload().sendKeys("C:\\TeachMeSkilsCourse\\TAF\\src\\test\\resources\\download.jpg");

        javascriptExecutor.executeScript("arguments[0].click();", fileUploadPage.getSubmit());


    }

    public WebElement getSuccessElement() {

        return fileUploadPage.getFileUploadedSuccess();

    }


}
