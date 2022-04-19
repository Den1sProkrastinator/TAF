import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.WeakHashMap;

public class SmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowserService browserService= new BrowserService();
        driver = browserService.getDriver();

    }

    @Test
    public void validateIKTCalculator() throws InterruptedException {

        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");

        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement button= driver.findElement(By.id("calc-mass-c"));

//        height.sendKeys(Keys.ENTER);

        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();
        Thread.sleep(2000);


    WebElement result = driver.findElement(By.id("imt-result"));

        Assert.assertEquals(result.getText(),"17.3 - Недостаточная (дефицит) масса тела");
    }


    @Test
    public  void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        WebElement kreatin = driver.findElement(By.id("oCr"));
        WebElement age=driver.findElement(By.id("oAge"));
        WebElement weight=driver.findElement(By.id("oWeight"));
        WebElement height=driver.findElement(By.id("oHeight"));
        WebElement butom =  driver.findElement(By.cssSelector("input[type=\"button\" i]"));

        Select   selectSex = new Select(selectWebElement);

        selectSex.selectByIndex(1);
        Thread.sleep(2000);

        kreatin.sendKeys("80");
        Thread.sleep(2000);
        age.sendKeys("38");
        Thread.sleep(2000);
        weight.sendKeys("55");
        Thread.sleep(2000);
        height.sendKeys("163");
        Thread.sleep(2000);
        butom.click();
        Thread.sleep(20000);



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
