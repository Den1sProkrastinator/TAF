package wrappers;

import org.openqa.selenium.*;
import services.WaitService;

import java.time.Duration;

public class CheckBox {

    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver,by);
    }

    public void click() {
       uiElement.click();
    }

}
