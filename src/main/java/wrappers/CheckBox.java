package wrappers;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class CheckBox {
    ArrayList<UIElement> uiElements;


    public CheckBox(WebDriver driver, By by) {
        uiElements = new ArrayList<>();

        for (WebElement element : driver.findElements(by)) {
            uiElements.add(new UIElement(driver, element));
        }

    }


    public void clickByValue(String value) throws Exception {

        for (UIElement uiElement : uiElements) {
            if (uiElement.getAttribute("value").equals(value)) {
                uiElement.click();
                return;
            }
        }

        throw new Exception("Value was not found");
    }


    public void clickByIndex(int index)  {
        uiElements.get(index).click();

    }


}








