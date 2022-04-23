package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class SmokeTestCalculatorsLaminat {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public  void laminatCalculator() throws  InterruptedException{

        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement roomLenght= driver.findElement(By.id("ln_room_id"));
        roomLenght.clear();
        roomLenght.sendKeys("500");

        WebElement widthLenght= driver.findElement(By.id("wd_room_id"));
        widthLenght.clear();
        widthLenght.sendKeys("400");

        WebElement ln_lam_id= driver.findElement(By.id("ln_lam_id"));
        ln_lam_id.clear();
        ln_lam_id.sendKeys("2000");

        WebElement wd_lam_id= driver.findElement(By.id("wd_lam_id"));
        wd_lam_id.clear();
        wd_lam_id.sendKeys("200");

        WebElement n_packing= driver.findElement(By.id("n_packing"));
        n_packing.clear();
        n_packing.sendKeys("8");


        WebElement radioButton = driver.findElement(By.id("direction-laminate-id1"));
        radioButton.click();


        WebElement calculateButton = driver.findElement(By.cssSelector(".calc-btn-div"));

        calculateButton.click();



        // ниже вознилки проблемы с локаторами


        WebElement numBoards= driver.findElement(By.cssSelector
                ("div [style='padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;']"));
        Assert.assertEquals(numBoards.getText(), "53");
//        /*WebElement numBox= driver.findElement(By.cssSelector(".calc-result div:nth-child(2)"));
//        Assert.assertEquals(numBox.getAttribute("value"), "Количество упаковок ламината: 7");
//        Thread.sleep(20000);





    }
}
