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

import static configuration.ReadProperties.*;

public class xPathSelectors {
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

        //Поиск по following(не работает)
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());
        //Поиск по parent(не работает)
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value]/parent::value")).isDisplayed());
        //Поиск по  preceding (не работает)
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());

        // Поиск элемента с условием AND
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Sauce Labs Bolt T-Shirt' and @class='inventory_item_img']")).isDisplayed());
    }


    @Test
    public void basicXPathSelectors1() {
        driver.get(getUrl());

        // Абсолютный xpath
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/div/div[2]")).isDisplayed());

        // Все эелемнты на странице начина с HTML
        driver.findElements(By.xpath("//*"));

        // Аналог поиска по tagName
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже р1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аьттрибут id
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и aтрибут target со значением
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента у которого значение аттрибута начинается с
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'new')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит равно
        Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'All Projects']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = 'Todos']")).isDisplayed());

        // Поиск элемента у которого текстовое значение содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'All Projects')]")).isDisplayed());

        // Поиск элемента по индексу
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());



    }

    @Test
    public void axesXPathTest() {
        driver.get(getUrl());

        // Поиск родителя у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::div")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following-sibling::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());
    }
}
