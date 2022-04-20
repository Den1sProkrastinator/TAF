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
        WebElement typeOfRoom = driver.findElement(By.id("room_type"));

        Select   selectTypeOfRoom = new Select(typeOfRoom);
        WebElement typeOfHeating = driver.findElement(By.id("heating_type"));
        Select selectTypeOfHeating= new Select(typeOfHeating);

        WebElement heatLoss = driver.findElement(By.id("el_f_losses"));
        WebElement button = driver.findElement(By.name("button"));

        width.sendKeys("3");
        Thread.sleep(2000);
        length.sendKeys("4");
        Thread.sleep(2000);
        selectTypeOfRoom.selectByIndex(1);
        Thread.sleep(2000);
        selectTypeOfHeating.selectByIndex(1);
        Thread.sleep(2000);
        heatLoss.sendKeys("12");
        Thread.sleep(2000);
        button.click();
        Thread.sleep(3000);

//        Assert.assertEquals(width.getText(),"Поверхность тела:1.58 (кв.м)");



    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
