package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

import java.io.Reader;

public class Task_6 extends ReadProperties {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

    }

    @Test
    public void login() throws InterruptedException {

        driver.get(getUrl());

        WebElement myLogin = driver.findElement(By.id("user-name"));
        myLogin.sendKeys(username());


        WebElement myPassword = driver.findElement(By.id("password"));
        myPassword.sendKeys(password());


        WebElement button = driver.findElement(By.id("login-button"));
        button.click();


        //add to card

        WebElement itemButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        itemButton.click();

        WebElement cardButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cardButton.click();


        // item check

        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(),
                "Sauce Labs Backpack");

        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(), "$29.99");


    }

    @Test
    public void locatorTest() throws InterruptedException {
        driver.get(getUrl());

        WebElement myLogin = driver.findElement(By.id("user-name"));
        myLogin.sendKeys(username());


        WebElement myPassword = driver.findElement(By.id("password"));
        myPassword.sendKeys(password());


        WebElement button = driver.findElement(By.id("login-button"));
        button.click();





        //  поиск по айди

        Assert.assertTrue(driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).isDisplayed());


        // поиск по  name

        Assert.assertTrue(driver.findElement(By.name("remove-sauce-labs-backpack")).isDisplayed());

        //поиск  по  className

        Assert.assertTrue(driver.findElement(By.cssSelector(".product_sort_container")).isDisplayed());



        //поиск оп tagname

        Assert.assertTrue(driver.findElement(By.cssSelector("a")).isDisplayed());

        //поиск по teg  и значению из атрибута class




    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
