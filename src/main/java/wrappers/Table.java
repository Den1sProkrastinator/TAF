package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;

    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public Table(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public TableRow getRow(int i) {
        ArrayList<UIElement> list = uiElement.findUIElements(By.tagName("tr"));
        return new TableRow(driver, list.get(i));
    }

    public void getRow(String text) {

    }

    public void getColumn(int i) {

    }

    public void getColumn(String header) {

    }

    public int getColumnIndex(String header) {
        int index = 0;
        for (UIElement element : uiElement.findUIElements(By.tagName("th"))) {
            if (element.getText().equals(header)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public UIElement getCell(int columnNumber, int rowNumber) {
        TableRow row = getRow(rowNumber);
        ArrayList<UIElement> list = row.findUIElements(By.tagName("td"));

        return list.get(columnNumber);
    }

    public UIElement  getElementFromCell(UIElement cellElement, By by) {
        return cellElement.findElement(by);
    }

    public void getElementFromCell(String sourceColumnName, String valueSourceColumnName, String targetColumnName) {

    }
}
