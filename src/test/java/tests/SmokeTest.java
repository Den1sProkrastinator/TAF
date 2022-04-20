package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void validateSKF() throws InterruptedException {
         driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        WebElement width = driver.findElement(By.id("el_f_width"));
        WebElement length = driver.findElement(By.id("el_f_lenght"));
        WebElement length1 = driver.findElement(By.id("el_f_lenght"));


//        Select   selectSex = new Select(selectWebElement);

//        selectSex.selectByIndex(1);

        Thread.sleep(2000);

        Assert.assertEquals(width.getText(),"Поверхность тела:1.58 (кв.м)");



    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
