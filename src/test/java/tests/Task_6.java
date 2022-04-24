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
    public void  login() throws InterruptedException {

        driver.get(getUrl());

        WebElement myLogin = getElementById("user-name");
        myLogin.sendKeys(username());

        Thread.sleep(2000);



        WebElement myPassword = driver.findElement(By.id("password"));
        myPassword.sendKeys(password());
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        Thread.sleep(2000);

        //add to card

        WebElement itemButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        itemButton.click();

        WebElement cardButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cardButton.click();

        Thread.sleep(2000);
        // item check

        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name")).getText(),
                "Sauce Labs Backpack");

        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(), "$29.99");
        Thread.sleep(2000);

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
        Assert.assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
        // поиск по  name
        Assert.assertTrue(driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).isDisplayed());
        //поиск  по  className
        Assert.assertTrue(driver.findElement(By.className("btn")).isDisplayed());
        //поиск оп tagName
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
        //поиск по link ext
        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Backpack")).isDisplayed());
        //поиск по partialLinkText
        Assert.assertTrue(driver.findElement(By.partialLinkText("Labs Backpack")).isDisplayed());

        //CSS
        //поиск по .class
        Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_item_description")).isDisplayed());
        //.class1.class2
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_primary.btn_small")).isDisplayed());

        // поиск по .class1 .class2
        Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_item_description .inventory_item_label")).isDisplayed());


        // поиск по #id
        Assert.assertTrue(driver.findElement(By.cssSelector("#item_4_title_link")).isDisplayed());
        // поиск по tagName
        Assert.assertTrue(driver.findElement(By.cssSelector("button")).isDisplayed());
        // поиск по tagname.class
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn")).isDisplayed());
        // поиск по [attribute=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[value='az']")).isDisplayed());
        // поиск по [attribute~=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[value~='az']")).isDisplayed());
        // поиск по  [attribute|=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[value|=lohi]")).isDisplayed());
        // поиск по [attribute^=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class^=bm]")).isDisplayed());
        // поиск по [attribute$=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class$=button]")).isDisplayed());


        // поиск по [attribute*=value] не получилось сделать этот пункт
        Assert.assertTrue(driver.findElement(By.cssSelector("[class*=Backpack]")).isDisplayed());
    }

    WebElement myLogin = driver.findElement(By.id("user-name"));

    private WebElement getElementById(String elementId){
        return driver.findElement(By.id(elementId));
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
