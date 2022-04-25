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
    public void electricityCalculator() throws InterruptedException {
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

        length.sendKeys("4");

        selectTypeOfRoom.selectByIndex(1);

        selectTypeOfHeating.selectByIndex(1);

        heatLoss.sendKeys("12");

        button.click();



        WebElement floor_cable_power = driver.findElement(By.id("floor_cable_power"));
        WebElement spec_floor_cable_power = driver.findElement(By.id("spec_floor_cable_power"));

      Assert.assertEquals(floor_cable_power.getAttribute("value"),"13");
      Assert.assertEquals(spec_floor_cable_power.getAttribute("value"),"1");



    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
