package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

import static configuration.ReadProperties.*;

public class XPathSelectors {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }


    @Test
    public void xPathSelectors() {
        driver.get(getUrl());

        WebElement myLogin = driver.findElement(By.id("user-name"));
        myLogin.sendKeys(username());
        WebElement myPassword = driver.findElement(By.id("password"));
        myPassword.sendKeys(password());
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        //Поиск по атрибуту
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contents_wrapper']")).isDisplayed());

        //Поиск по тексту
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Name (A to Z)']")).isDisplayed());

        //Поиск по частичному совпадению атрибута
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@class, 'inventory')]")).isDisplayed());

        //Поиск по частичному совпадению текста
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Add ')]")).isDisplayed());

        //Поиск по ancestor
        Assert.assertTrue(driver.findElement(By.xpath("//option/ancestor::select")).isDisplayed());

        //Поиск по descendant
        Assert.assertTrue(driver.findElement(By.xpath("//select/descendant::option")).isDisplayed());

        //Поиск по following
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='inventory_item_price']/following::button")).isDisplayed());

        //Поиск по parent
        Assert.assertTrue(driver.findElement(By.xpath("//button/parent::div")).isDisplayed());

        //Поиск по  preceding
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='inventory_item_price']/preceding::button")).isDisplayed());

        // Поиск элемента с условием AND
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Sauce Labs Bolt T-Shirt' and @class='inventory_item_img']")).isDisplayed());
    }



}
