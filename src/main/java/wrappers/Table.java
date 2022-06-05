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

    public TableRow getRow(String text)throws Exception {
        ArrayList<UIElement> list = uiElement.findUIElements(By.tagName("tr"));
        int index = 0 ;

        for (UIElement uiElement :list) {
            if (uiElement.getText().equals(text)){

            return new TableRow(driver, list.get(index));}
            index++;
        }
        throw new Exception("DropDown element was not found");

    }



    public void getColumn(int i) {
    }

    public void getColumn(String header) {


    }

    public int getColumnIndex(String header) {
        int index = 0;
        for (UIElement element : uiElement.findUIElements(By.tagName("tr"))) {
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


//    public ArrayList<UIElement> getCellByText(String rowName, String classValue)   {
//
//        ArrayList<UIElement> result = new ArrayList<>();
//
//        ArrayList<UIElement> listTR = uiElement.findUIElements(By.tagName("tr"));
//        int index= 0;
//        for (UIElement uiElement:listTR) {
//            result.add(index, createTable(listTR.get(index)));
//
//        }
//        return result;
//
//
//    }
//    private UIElement createTable (UIElement tr) {
//        By by = By.className("action");
//        ArrayList<WebElement> tds = tr.findElements(by);
//        TableColumnClass result = new TableColumnClass();
//
//        тут вы присваиваете конкретные ячейки таблицы
//        result.setName(tds.get(0));
//        result.setEmail(tds.get(1));
//        return result
//
//    }



    public UIElement  getElementFromCell(UIElement cellElement, By by) {
        return cellElement.findElement(by);
    }

    public void getElementFromCell(String sourceColumnName, String valueSourceColumnName, String targetColumnName) {

    }
}
