package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class ContextMenuStep extends BaseStep {


    public ContextMenuStep(WebDriver driver) {
        super(driver);
    }

    public  void contextMenu(){

contextMenuPage.openPageByUrl();

        actions
                .moveToElement(contextMenuPage.getHotSpot(), 15, 15)
                .contextClick(contextMenuPage.getHotSpot())
                .build()
                .perform();
        Alert alert= driver.switchTo().alert();
        alert.accept();

    }

}
