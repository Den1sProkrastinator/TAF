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
    public void validateIKTCalculation() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/");
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement button = driver.findElement(By.id("calc-mass-c"));

        height.sendKeys("183");
        weight.sendKeys("58");
        button.click();

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("imt-result"));
        Assert.assertEquals(result.getText(), "17.3 - Недостаточная (дефицит) масса тела");
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");

        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);

        WebElement kreatin = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.cssSelector("input[type=\"button\" i]"));

        kreatin.sendKeys("80");
        Thread.sleep(2000);
        age.sendKeys("38");
        Thread.sleep(2000);
        weight.sendKeys("55");
        Thread.sleep(2000);
        height.sendKeys("163");
        Thread.sleep(2000);
        button.click();
        Thread.sleep(2000);

        WebElement txtMDRD=driver.findElement(By.id("txtMDRD"));
        WebElement txtMDRD1=driver.findElement(By.id("txtMDRD1"));
        WebElement txtCG=driver.findElement(By.id("txtCG"));
        WebElement txtBSA=driver.findElement(By.id("txtBSA"));

        Assert.assertEquals(txtMDRD.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(txtMDRD.getText(), "ХБП: 2 стадия (при наличии почечногоповреждения)");
        Assert.assertEquals(txtMDRD.getText(), "Cockroft-Gault: 70 (мл/мин)");
        Assert.assertEquals(txtMDRD.getText(), "Поверхность тела:1.58 (кв.м)");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
